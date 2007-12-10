/**
 * @(#) DefaultDelegate.java 1.0 Mar 20, 2007
 * Copyright 2005 IBS Software Services (P) Ltd. All Rights Reserved.
 *  
 * This software is the proprietary information of IBS Software Services (P) Ltd.
 * Use is subject to license terms.
 *
 * Warning: This software is protected by copyright law and international treaties 
 * and conventions. Unauthorized use, distribution or reproduction of this software, 
 * or of any parts thereof, may result in prosecution and penalties." 
 *
 */
package com.merrill.examples.framework.client.delegate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.StringTokenizer;


import com.merrill.examples.framework.business.BI;

/**
 * DefaultDelegate - Description
 * 
 * 
 * @author a-1346
 * 
 */

/**
 * <pre>
 * 
 * Revision History
 * Revision 		Date      			Author			Description
 * 1.0				Mar 20, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class DefaultDelegate<S extends BI> implements Delegate {

	private String module;

	private String subModule;

	private S service;
	
	private Map<String, String> delegateRequestMap;

	public void setModule(String module) {
		this.module = module;
	}

	public void setSubModule(String subModule) {
		this.subModule = subModule;
	}

	private Object[] createArgumentsForCall(Object... ars) {
		Collection<Object> args = new ArrayList<Object>();
		if(!(ars==null)){
			for (Object o : ars) {
				args.add(o);
			}
		}
		return args.toArray();

	}

	public <T extends Object> T despatchRequest(String action, Object... objects) throws DelegateException {
		
		System.out.println("<DELEGATE> <Entering> : \n<module>\n"+this.module+"\n</module>\n<submodule>"+this.subModule+"</submodule></DELEGATE>\n");
		System.out.println("<DELEGATE><ACTION>"+action+"</ACTION></DELEGATE>\n");
		Object[] args = null;
		Class[] parTypes = null;
		Object returnValue=null;
		
		
		
		
		
		
		if(this.delegateRequestMap.get(action)==null)
			throw new DelegateException(action +" Not mapped in application Config for <MODULE> : "+this.module+" , <SUBMODULE> "+this.subModule);
		
		String actionParamTypes = (String)this.delegateRequestMap.get(action);
		
		
		String[] actionParamTypesClazz =actionParamTypes.split("\\,");
		
		if(objects!=null){
		
			
			if(objects.length>0){
				args = createArgumentsForCall(objects);
				
				
				Collection<Class> parCollection = new ArrayList<Class>();
				for (String clazz : actionParamTypesClazz) {
					try {
						parCollection.add(Class.forName(clazz.trim()));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						throw new DelegateException("CLASS NOT FOUND");
					}
				}
				
				parCollection = unWrapMethodParameters(parCollection);
				parTypes = parCollection.toArray(new Class[parCollection
						.size()]);
			
			}
			else{
				args = createArgumentsForCall(objects);
				
				
				Collection<Class> parCollection = new ArrayList<Class>();
				for (Object o : args) {
					parCollection.add(o.getClass());
				}
				
				parCollection = unWrapMethodParameters(parCollection);
				parTypes = parCollection.toArray(new Class[parCollection
						.size()]);
			}
			
		
		}else
		{
			args = new Object[1];
			args[0] = null;
			try {
				parTypes = new Class[]{Class.forName(actionParamTypes)};
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				throw new DelegateException("CLASS NOT FOUND");
			}
			
		}
		
		try {
			Method m = this.service.getClass().getMethod(action, parTypes);
			returnValue = m.invoke(this.service, args);
		} catch (SecurityException e) {
			
			e.printStackTrace();
			throw new DelegateException("ACCESS_DENIED_ERROR");
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
			throw new DelegateException("UNEXPECTED_SERVER_ERROR");
		}
		
		return (returnValue==null ?null: (T)returnValue);
	}

	private Class<?> getPrimitiveType(Class parClas)
			 {
		Class<?> unwrappedType = null;
		if ("Integer".equals(parClas.getSimpleName())) {
			unwrappedType = Integer.TYPE;
		} else if ("Long".equals(parClas.getSimpleName())) {
			unwrappedType = Long.TYPE;
		} else if ("Float".equals(parClas.getSimpleName())) {
			unwrappedType = Float.TYPE;
		} else if ("Double".equals(parClas.getSimpleName())) {
			unwrappedType = Double.TYPE;
		} else {
			unwrappedType = parClas;
		}
		return unwrappedType;

	}

	/*
	 * Unwrap any wrapped primitives in method parameters
	 */
	private Collection<Class> unWrapMethodParameters(
			Collection<Class> parClasses)  {
		Collection<Class> pars = new ArrayList<Class>(parClasses.size());
		for (Class c : parClasses) {
			pars.add(getPrimitiveType(c));
		}
		return pars;
	}

	public <T extends Object> T despatchRequest(String action) throws DelegateException {
		return despatchRequest(action, new Object[0]);
	}

	public void setService(S service) {
		this.service = service;
		
	}

	public void setDelegateRequestMap(Map<String,String> delegateRequestMap) {
		this.delegateRequestMap = 	delegateRequestMap;	
	}



}

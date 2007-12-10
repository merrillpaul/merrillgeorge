/**
 * @(#) JNDIDBConnectionProvider.java 1.0 Apr 13, 2007
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
package com.merrill.examples.framework.security.auth.provider.db.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.merrill.examples.framework.security.auth.provider.db.ConnectionProvider;


/**
 * JNDIDBConnectionProvider - Description
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
 * 1.0				Apr 13, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class JNDIDBConnectionProvider implements ConnectionProvider {

	private String jndiName;
	
	/**
	 * @param jndiName the jndiName to set
	 */
	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.provider.db.ConnectionProvider#getConnection()
	 */
	public Connection getConnection() {
		Connection con=null;
		
		try {
			Context ctx = getInitialContext();
			DataSource ds = (DataSource)ctx.lookup(this.jndiName);
			
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	private Context getInitialContext() throws NamingException{
		return new InitialContext();
	}

}

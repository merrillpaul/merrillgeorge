/**
 * @(#) DefaultValidator.java 1.0 Apr 13, 2007
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
package com.merrill.examples.framework.security.auth.validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.merrill.examples.framework.security.auth.credentials.UserCredentials.Credential;
import com.merrill.examples.framework.security.auth.provider.db.ConnectionProvider;

/**
 * DefaultValidator - Description
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

public class DefaultValidator extends TokenAwareValidator {

	private ConnectionProvider connectionProvider;
	
	private String userTableName;
	
	private String userNameColumn;
	
	private String userPasswordColumn;
	/**
	 * @param userNameColumn the userNameColumn to set
	 */
	public void setUserNameColumn(String userNameColumn) {
		this.userNameColumn = userNameColumn;
	}

	/**
	 * @param userPasswordColumn the userPasswordColumn to set
	 */
	public void setUserPasswordColumn(String userPasswordColumn) {
		this.userPasswordColumn = userPasswordColumn;
	}

	/**
	 * @param userTableName the userTableName to set
	 */
	public void setUserTableName(String userTableName) {
		this.userTableName = userTableName;
	}

	/**
	 * @param connectionProvider the connectionProvider to set
	 */
	public void setConnectionProvider(ConnectionProvider connectionProvider) {
		this.connectionProvider = connectionProvider;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.validator.AbstractValidator#afterUserValidation()
	 */
	@Override
	protected void afterUserValidation() throws ValidationException {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.auth.validator.AbstractValidator#validateUser()
	 */
	@Override
	protected boolean validateUser() throws ValidationException {
		boolean valid=false;
		String providedUserName = 	this.userCredentials
										.getCredential(Credential.USERNAME);
		String providedUserPassword = this.userCredentials
										.getCredential(Credential.PASSWORD);
		
		
		Connection connection = null;
		PreparedStatement pstatement =  null;
		ResultSet rs =  null;
		
		connection = this.connectionProvider.getConnection();
		try {
			pstatement = connection.prepareStatement(constructQuery());
			pstatement.setString(1, providedUserName);
			pstatement.setString(2, providedUserPassword);
			rs = pstatement.executeQuery();
			
			valid = rs.next();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			try {
				if(rs!=null)
					rs.close();
				if(pstatement!=null)
					pstatement.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		
		return valid;
	}
	
	private String constructQuery() {
		return new StringBuilder().append(" SELECT 1 FROM ").append(this.userTableName)
				.append(" WHERE ").append(this.userNameColumn).append(" = ? AND ")
				.append(this.userPasswordColumn).append(" = ? ").toString();
	}

}

/**
 * @(#) Test.java 1.0 May 18, 2007
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
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Test - Description
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
 * 1.0				May 18, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		 DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

		    String url = "jdbc:oracle:thin:@192.168.0.193:1521:TST1";
		   

		    // Connect to the database PRT_PORT_MST
		    // You can put a database name after the @ sign in the connection URL.
		    Connection conn =
		      DriverManager.getConnection (url, "iportsh_test", "iportsh_test");
		    
		    //Statement st = conn.createStatement();
		    //ResultSet rs = st.executeQuery("select * from PRT_PORT_MST where VERSION = (select 0 from dual)");
		    
		    PreparedStatement st = conn.prepareStatement("select * from PRT_PORT_MST where VERSION = ?");
		    st.setString(1, "(select 0 from dual)");
		    ResultSet rs = st.executeQuery();
		    while (rs.next())
		        System.out.println (rs.getString (1) + "  " + rs.getString (2));
		    
		    rs.close();
		    st.close();
		    conn.close();
	}

}

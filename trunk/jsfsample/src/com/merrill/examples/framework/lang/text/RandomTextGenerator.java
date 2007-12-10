/**
 * @(#) RandomTextGenerator.java 1.0 Apr 10, 2007
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
package com.merrill.examples.framework.lang.text;



/**
 * RandomTextGenerator - Description
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
 * 1.0				Apr 10, 2007				a-1346			First draft
 * 
 * </pre>
 */

public interface RandomTextGenerator {
	/**
     * <p>Creates a random string whose length is the number of characters
     * specified.</p>
     *
      *
     * @param count  the length of random string to create
     * @return the random string
     */
    String random(int count);
    
    
    /**
     * <p>Creates a random string whose length is the number of characters
     * specified.</p>
     *
     * <p>Characters will be chosen from the set of characters whose
     *
     * @param count  the length of random string to create
     * @return the random string
     */
    String randomAscii(int count);
    
    
    /**
     * <p>Creates a random string whose length is the number of characters
     * specified.</p>
     *
     * <p>Characters will be chosen from the set of alphabetic
     * characters.</p>
     *
     * @param count  the length of random string to create
     * @return the random string
     */
    String randomAlphabetic(int count);
    
    /**
     * <p>Creates a random string whose length is the number of characters
     * specified.</p>
     *
     * <p>Characters will be chosen from the set of alphabetic
     * characters.</p>
     *
     * @param count  the length of random string to create
     * @return the random string
     */
    String randomAlphaNumeric(int count);
    
    /**
     * <p>Creates a random string whose length is the number of characters
     * specified.</p>
     *
     * <p>Characters will be chosen from the set of numeric
     * characters.</p>
     *
     * @param count  the length of random string to create
     * @return the random string
     */
    String randomNumeric(int count); 
    
    
}

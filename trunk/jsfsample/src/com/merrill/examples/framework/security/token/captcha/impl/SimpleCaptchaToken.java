/**
 * @(#) SimpleCaptchaToken.java 1.0 Apr 9, 2007
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
package com.merrill.examples.framework.security.token.captcha.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import com.merrill.examples.framework.security.token.captcha.CaptchaToken;

/**
 * SimpleCaptchaToken - Description
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
 * 1.0				Apr 9, 2007				a-1346			First draft
 * 
 * </pre>
 */

public class SimpleCaptchaToken implements CaptchaToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7870464157167602344L;
	private String actualKey;
	public SimpleCaptchaToken(String testToken) {
		super();
		this.actualKey = testToken;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.token.captcha.CaptchaToken#getTokenImage()
	 */
	public BufferedImage getTokenImage() {
//		final constants
        final double shearx = 0.54;
        final double sheary = 0.2;
        final double rotate = Math.toRadians(-19);
        //default size
        int imageWidth = 300;
        int imageHeight = 100;
        //get a fix on the token dimensions
        BufferedImage i1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D g1 = i1.createGraphics();
        AffineTransform t1 = new AffineTransform();
        t1.translate(0, 0);
        t1.shear(shearx, sheary);
        t1.rotate(rotate);
        TextLayout l = new TextLayout(this.actualKey, getFont(), g1.getFontRenderContext());
        Shape s = l.getOutline(t1);
        Rectangle r = s.getBounds();
        //got the tokens rendered dimensions
        double w = r.getWidth();
        double h = r.getHeight();
        //determine the new image size, if required
        if ((w * 2) > imageWidth) {
            imageWidth = (int)w * 2;
        }
        if ((h * 2) > imageHeight) {
            imageHeight = (int)h * 2;
        }
        //now render the actual image
        BufferedImage i2 = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = i2.createGraphics();
        g2.setPaint(
            new GradientPaint(0, 0, Color.red, imageWidth / 2, imageHeight / 2, Color.yellow, true));
        g2.fill(
            new Rectangle2D.Double(0, 0, imageWidth, imageHeight));
        AffineTransform t2 = new AffineTransform();
        t2.translate(imageWidth / 2.0 - w / 2.0, imageHeight / 2.0 + h / 2.0);
        t2.shear(shearx, sheary);
        t2.rotate(rotate);
        g2.setPaint(Color.BLUE);
        g2.fill(l.getOutline(t2));
        return i2;
	}

	/* (non-Javadoc)
	 * @see com.merrill.examples.framework.security.token.Token#validateToken(java.lang.String)
	 */
	public boolean validateToken(String tokenKey) {
		boolean yes =false;
		
		if(tokenKey!=null){
			if(tokenKey.equals(actualKey))
				yes = true;
		}
		return yes;
		
	}
	
	private Font getFont() {
        Font f = new Font("Times New Roman", Font.PLAIN, 40);
        return f;
    }

}

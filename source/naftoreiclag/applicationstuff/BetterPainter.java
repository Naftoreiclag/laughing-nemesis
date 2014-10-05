/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */

package naftoreiclag.applicationstuff;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;

public class BetterPainter
{
	private Graphics2D graphics;
	public Graphics2D getGraphics() { return graphics; }
	private AffineTransform originalTransform;
	
	private Composite originalComposite;
	
	private Map<String, AffineTransform> savedTransforms = new HashMap<String, AffineTransform>();
	
	private double alpha = 1.0d;
	
	public BetterPainter(Graphics2D graphics)
	{
		this.graphics = graphics;
		this.originalTransform = graphics.getTransform();
		this.originalComposite = graphics.getComposite();
	}
	
	public Color getColor()
	{
		return graphics.getColor();
	}
	
	public void setColor(Color color)
	{
		graphics.setColor(color);
	}
	
	public void setAlpha(double alpha)
	{
		graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) alpha));
	}
	
	public void clearAlpha()
	{
		graphics.setComposite(originalComposite);
	}
	
	public double getAlpha()
	{
		return alpha;
	}
	
	public void drawCircle(double x, double y, double radius)
	{
		graphics.drawOval((int) (-radius + x), (int) (-radius + y), (int) (radius * 2), (int)(radius * 2));
	}
	
	public void clearSavedTransforms()
	{
		savedTransforms.clear();
	}
	
	public void saveTransform(String key)
	{
		savedTransforms.put(key, graphics.getTransform());
	}
	
	public void loadTransform(String key)
	{
		graphics.setTransform(savedTransforms.get(key));
	}
	
	public void deleteTransform(String key)
	{
		savedTransforms.remove(key);
	}
	
	public void loadTransformAndDelete(String key)
	{
		graphics.setTransform(savedTransforms.get(key));
		savedTransforms.remove(key);
	}
	
	public void translate(double x, double y)
	{
		graphics.translate(x, y);
	}
	public void scale(double x, double y)
	{
		graphics.scale(x, y);
	}
	
	public void resetTransform()
	{
		graphics.setTransform(originalTransform);
	}

	public void fillRect(double x, double y, double width, double height)
	{
		graphics.fillRect((int) x, (int) y, (int) width, (int) height);
	}
	
	public void drawRect(double x, double y, double width, double height)
	{
		graphics.drawRect((int) x, (int) y, (int) width, (int) height);
	}

	public void drawLine(double x1, double y1, double x2, double y2)
	{
		graphics.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
	}

	public void drawString(String string, double x, double y)
	{
		graphics.drawString(string, (float) x, (float) y);
	}

	public void drawStringCentered(String string, double x, double y)
	{
		Rectangle2D javaDumbRectangle = stringBox(string);
		
		// why
		graphics.drawString(string, (float) (x - (javaDumbRectangle.getWidth() / 2d)), (float) (y + (javaDumbRectangle.getHeight() / 4d)));
	}
	
	public Rectangle2D stringBox(String string)
	{
		return graphics.getFontMetrics().getStringBounds(string, graphics);
	}

	double printX = 0;
	double printY = 0;
	double line = 1;
	double offset = 0;
	
	public void beginPrinting(double x, double y)
	{
		printX = x;
		printY = y;
	}
	
	public void print(String string)
	{
		this.drawString(string, offset + printX, printY + (line * 15));
		offset += stringBox(string).getWidth();
	}
	
	public void print(Object object)
	{
		this.print(object.toString());
	}
	
	public void println()
	{
		offset = 0;
		++ line;
	}

	public void println(String string)
	{
		this.print(string);
		this.println();
	}
	
	public void println(Object object)
	{
		this.print(object);
		this.println();
	}
	
	public void endPrinting()
	{
		offset = 0;
		line = 1;
	}
}

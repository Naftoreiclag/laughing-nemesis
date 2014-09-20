/* Copyright (c) 2014 "Naftoreiclag" https://github.com/Naftoreiclag
 *
 * Distributed under the Apache License Version 2.0 (http://www.apache.org/licenses/)
 * See accompanying file LICENSE
 */

package naftoreiclag.laughingnemesis;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Map;

public class BetterPainter
{
	private Graphics2D graphics;
	public Graphics2D getGraphics() { return graphics; }
	private AffineTransform originalTransform;
	
	private Map<String, AffineTransform> savedTransforms = new HashMap<String, AffineTransform>();
	
	public BetterPainter(Graphics2D graphics)
	{
		this.graphics = graphics;
		this.originalTransform = graphics.getTransform();
	}
	
	public Color getColor()
	{
		return graphics.getColor();
	}
	
	public void setColor(Color color)
	{
		graphics.setColor(color);
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
}

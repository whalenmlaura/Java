// Author - Laura Whalen


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.util.Random;

public abstract class Shapes {
	public Random random = new Random();
	Color[] colorArray = {new Color(239, 83, 80), 
						  new Color(255, 112, 67),
						  new Color(255, 229, 127),
						  new Color(156, 204, 101),
						  new Color(102, 187, 106),
						  new Color(38, 166, 154),
						  new Color(38, 198, 218),
						  new Color(33, 150, 243),
						  new Color(92, 107, 192),
						  new Color(126, 87, 194),
						  new Color(171, 71, 188)};
	int randomColor;
		
	GradientPaint[] gradientArray = {(new GradientPaint(5, 30, new Color(224, 77, 249), 35, 100, new Color(126, 87, 194), true)),
						     		 (new GradientPaint(5, 30, new Color(37, 166, 106), 35, 100, new Color(61, 90, 255), true)),
						     		 (new GradientPaint(5, 30, new Color(48, 220, 242), 35, 100, new Color(12, 146, 252), true)),
						     		 (new GradientPaint(5, 30, new Color(255, 112, 67), 35, 100, new Color(255, 229, 127), true)),
						     		 (new GradientPaint(5, 30, new Color(255, 242, 127), 35, 100, new Color(116, 219, 121), true))};
	int randomGradient;

	public int xPoint; //top/left x/y coordinates
	public int yPoint;
	public int xVelocity; //direction
	public int yVelocity;
	
	public abstract void updateMove(int width, int height);
	public abstract void draw(Graphics g);

}

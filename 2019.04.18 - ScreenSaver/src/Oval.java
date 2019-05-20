// Author - Laura Whalen


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Oval extends Shapes {
	Ellipse2D oval;
	boolean hitWall = false;
	int size1;
	int size2;
	
	public Oval(int width, int height) {
		this.xPoint = random.nextInt(width);
		this.yPoint = random.nextInt(height);
		
		//random start direction 
		if(random.nextInt(2) == 0)
			this.xVelocity = 1;
		else
			this.xVelocity = -1;
		
		if(random.nextInt(2) == 0)
			this.yVelocity = 1;
		else
			this.yVelocity = -1;
		
		this.randomGradient = random.nextInt(gradientArray.length); //random gradient color
		size1 = random.nextInt(50); //randomized size
		size2 = random.nextInt(75);
		this.oval = new Ellipse2D.Double(xPoint, yPoint, size1, size2);
	}
	

	@Override
	public void updateMove(int width, int height) {
		//get the max of X, if greater or equal to frame width, go in right direction
		if(this.oval.getMaxX() >= width) {
			this.xVelocity = -1;
			hitWall = true;
		}
		
		//get the min of X, if less or equal to 0, go in left direction
		if(this.oval.getMinX() <= 0) {
			this.xVelocity = 1;
			hitWall = true;
		}
		
		//get the max of Y, if greater or equal to frame height, go in down direction
		if(this.oval.getMaxY() >= height) {
			this.yVelocity = -1;
			hitWall = true;
		}
		
		//get the min of Y, if greater or equal to 0, go in up direction
		if(this.oval.getMinY() <= 0) {
			this.yVelocity = 1;
			hitWall = true;
		}
		
		//top/left coordinate += the direction
		this.xPoint += xVelocity;
		this.yPoint += yVelocity;
		this.oval = new Ellipse2D.Double(xPoint, yPoint, size1, size2);
	}
	

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//if object hits the wall
		if(hitWall) {
			//new random gradient, new random size
			this.randomGradient = random.nextInt(gradientArray.length);
			this.size1 = random.nextInt(50);
			this.size2 = random.nextInt(75);
			hitWall = false;
		}
		
		g2d.setPaint(gradientArray[randomGradient]);
		g2d.fill(oval);
		
	}

}
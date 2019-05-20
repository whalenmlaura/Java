// Author - Laura Whalen


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Circle extends Shapes {
	Ellipse2D circle;
	boolean hitWall = false;
	int size;


	
	public Circle(int width, int height) {
		this.xPoint = random.nextInt(width);
		this.yPoint = random.nextInt(height);
		
		if(random.nextInt(2) == 0)
			this.xVelocity = 1;
		else
			this.xVelocity = -1;
		
		if(random.nextInt(2) == 0)
			this.yVelocity = 1;
		else
			this.yVelocity = -1;
		
		size = random.nextInt(75);
		this.randomColor = random.nextInt(colorArray.length);

		this.circle = new Ellipse2D.Double(xPoint, yPoint, size, size);
	}
	

	@Override
	public void updateMove(int width, int height) {
		if(this.circle.getMaxX() >= width) {
			this.xVelocity = -1;
			hitWall = true;
		}
		
		if(this.circle.getMinX() <= 0) {
			this.xVelocity = 1;
			hitWall = true;
		}
		
		if(this.circle.getMaxY() >= height) {
			this.yVelocity = -1;
			hitWall = true;
		}
		
		if(this.circle.getMinY() <= 0) {
			this.yVelocity = 1;
			hitWall = true;
		}
		
		this.xPoint += xVelocity;
		this.yPoint += yVelocity;
		this.circle = new Ellipse2D.Double(xPoint, yPoint, size, size);	
	}
	

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		if(hitWall) {
			this.randomColor = random.nextInt(colorArray.length);
			this.size = random.nextInt(75);
			hitWall = false;
		}
		
		g2d.setColor(colorArray[randomColor]);
		g2d.fill(circle);
		
	}

}

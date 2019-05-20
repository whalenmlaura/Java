// Author - Laura Whalen


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shapes {
	Rectangle2D rectangle;
	boolean hitWall = false;
	int size1;
	int size2;
	
	public Rectangle(int width, int height) {
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
		
		this.randomColor = random.nextInt(colorArray.length);
		size1 = random.nextInt(50);
		size2 = random.nextInt(75);
		this.rectangle = new Rectangle2D.Double(xPoint, yPoint, size1, size2);
	}
	

	@Override
	public void updateMove(int width, int height) {
		if(this.rectangle.getMaxX() >= width) {
			this.xVelocity = -1;
			hitWall = true;
		}
		
		if(this.rectangle.getMinX() <= 0) {
			this.xVelocity = 1;
			hitWall = true;
		}
		
		if(this.rectangle.getMaxY() >= height) {
			this.yVelocity = -1;
			hitWall = true;
		}
		
		if(this.rectangle.getMinY() <= 0) {
			this.yVelocity = 1;
			hitWall = true;
		}
		
		this.xPoint += xVelocity;
		this.yPoint += yVelocity;
		this.rectangle = new Rectangle2D.Double(xPoint, yPoint, size1, size2);
	}
	

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		if(hitWall) {
			this.randomColor = random.nextInt(colorArray.length);
			this.size1 = random.nextInt(50);
			this.size2 = random.nextInt(75);
			hitWall = false;
		}
		
		g2d.setColor(colorArray[randomColor]);
		g2d.fill(rectangle);

	}
}

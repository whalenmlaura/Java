// Author - Laura Whalen


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;


public class Star extends Shapes {
	Polygon star;	
	boolean hitWall = false;
	
	int xPoints[] = {65,77,119,83,93,65,37,47,11,53};
	int yPoints[] = {10,46,46,64,106,82,106,64,46,46};

	
	public Star(int width, int height) {
		this.xPoint = random.nextInt(width);
		this.yPoint = random.nextInt(height);
		star = new Polygon();
		
		//'addPoint' appends the specified coordinates to this Polygon (star)
		//updates the bounding box
		for(int i = 0; i < xPoints.length; i++) {
			star.addPoint(xPoints[i]+xPoint, yPoints[i]+yPoint);
		}
		
		if(random.nextInt(2) == 0)
			this.xVelocity = 1;
		else
			this.xVelocity = -1;
		
		if(random.nextInt(2) == 0)
			this.yVelocity = 1;
		else
			this.yVelocity = -1;
		
		this.randomColor = random.nextInt(colorArray.length);
	}
	

	@Override
	public void updateMove(int width, int height) {
		//Gets the bounding box of this Polygon. The bounding box is the smallest Rectangle whose sides
		//are parallel to the x and y axes of the coordinate space, and can completely contain the Polygon.
		if(this.star.getBounds().getMaxX() >= width) {
			this.xVelocity = -1;
			hitWall = true;
		}
		
		if(this.star.getBounds().getMinX() <= 0) {
			this.xVelocity = 1;
			hitWall = true;
		}
		
		if(this.star.getBounds().getMaxY() >= height) {
			this.yVelocity = -1;
			hitWall = true;			
		}
		
		if(this.star.getBounds().getMinY() <= 0) {
			this.yVelocity = 1;
			hitWall = true;			
		}
		
		this.star.translate(this.xVelocity, this.yVelocity);
	}
	

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		if(hitWall) {
			this.randomColor = random.nextInt(colorArray.length);
			hitWall = false;
		}
		
		g2d.setColor(colorArray[randomColor]);
		g2d.draw(star);

	}

}
import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*;

//Author - Laura Whalen


@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Shapes> shapeList = new ArrayList();
	Timer timer = new Timer(5, new TimerHandler());
	public Random random = new Random();
	
	
	public DrawPanel() { //default constructor	
		this.addMouseListener(new Mouse());
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		//for each shape of type Shapes in the shapeList - draw
		for(Shapes shape: shapeList) {
			shape.draw(g);
		}
		
	} 
	
	class Mouse implements MouseListener {
		public void mouseClicked(MouseEvent arg0) {
			//add shape to list based on random number between 0-3
			if(random.nextInt(4) == 0)
				shapeList.add((Shapes)new Rectangle(getWidth(), getHeight())); //explicit up-cast
			if(random.nextInt(4) == 1)
				shapeList.add((Shapes)new Circle(getWidth(), getHeight()));
			if(random.nextInt(4) == 2)
				shapeList.add((Shapes)new Oval(getWidth(), getHeight()));
			if(random.nextInt(4) == 3)
				shapeList.add((Shapes)new Star(getWidth(), getHeight()));	
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	private class TimerHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//for each shape of type Shapes in the shapeList - call the updateMove method and get the width and height of frame
			for(Shapes shape: shapeList) {
				shape.updateMove(getWidth(), getHeight());
			}
			repaint();	
		}
	}
}

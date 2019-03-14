// Author - Laura Whalen

import javax.swing.JOptionPane; //graphics library

public class Launcher {

	public static void main(String[] args) {
		try {
		Application app = new Application();
		app.start(); // this is how we call to the "non-static" world
		}//end try
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "An error has occured while running the application");
		}//end catch
	}//end main


}//end Launcher class
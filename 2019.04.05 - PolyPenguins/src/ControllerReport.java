//Author: Laura Whalen

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerReport {
	private ArrayList<Animal> animalList;
	
	public ControllerReport() {
		animalList = new ArrayList<>();
	}
	
	//OVERLOAD METHODS
	public void addAnimal(String species, String sex, double weight, String gpsCoordinates, double BP) {
		this.animalList.add(new Penguin(species, sex, weight, gpsCoordinates, BP));
	}
	
	public void addAnimal(String species, String sex, double weight, String gpsCoordinates, int numSpots) {
		this.animalList.add(new SeaLion(species, sex, weight, gpsCoordinates, numSpots));
	}
	
	public void addAnimal(String species, String sex, double weight, String gpsCoordinates, String dental) {
		this.animalList.add(new Walrus(species, sex, weight, gpsCoordinates, dental));
	}
	
	
//WRITE REPORT METHOD ----------------------------------------------------------------------------
	public void writeReport() {
		String report = "";
		
	  //for type  variable : array name
		for(Animal species : animalList)
			report += species.addLine() + "\n"; //call the method that adds formated line of text, and go to new line

		try {
			BufferedWriter buffWriter = new BufferedWriter(new FileWriter("AnimalReport.txt")); //write to AnimalReport.txt
			buffWriter.write(report); //write String report
			buffWriter.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


//READ REPORT METHOD ------------------------------------------------------------------------------
	//help from Cathy Bae
	public String readReport(String fileName) {
		String report = "";
		
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader("AnimalReport.txt"));
			String s = null;
			while((s=buffReader.readLine())!=null) // while line is not empty
				report += s + "\n";
			buffReader.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}	
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return report;
	}	
}

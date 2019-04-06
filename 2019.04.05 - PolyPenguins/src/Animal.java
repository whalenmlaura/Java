//Author: Laura Whalen

// ABSTRACT SUPERCLASS
public abstract class Animal {
	String species;
	String sex;
	double weight;
	GPS gps = new GPS();
	
	public Animal(String species, String gender, double weight, String gpsInfo) { //Constructor 
		this.species = species;
		this.sex = gender;
		this.weight = weight;
		this.gps.addGPS(gpsInfo);
	}
	
	//Abstract addLine (to report) method
	public abstract String addLine();
}

//Author: Laura Whalen

public class Walrus extends Animal {
	public String dental;
	
	Walrus(String species, String gender, double weight, String gpsInfo, String dental) {
		super(species, gender, weight, gpsInfo);
		this.dental = dental;
	}

	@Override
	public String addLine() {
		return this.species + "  -  " + this.sex + "  -  Weight: " + this.weight+"kg  -  GPS: " + this.gps.gpsInfo.get(0) + "  -  " + "Dental Health: " + this.dental;
	}
	
}
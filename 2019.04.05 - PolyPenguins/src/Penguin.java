//Author: Laura Whalen

public class Penguin extends Animal {
	public double BP;

	public Penguin(String species, String gender, double weight, String gpsInfo, double BP) {
		super(species, gender, weight, gpsInfo);
		this.BP = BP;
	}

	@Override
	public String addLine() {
		return this.species + "  -  " + this.sex + "  -  Weight: " + this.weight+"kg  -  GPS: " + this.gps.gpsInfo.get(0) + "  -  " + "BP: " + this.BP;
	}
	
}

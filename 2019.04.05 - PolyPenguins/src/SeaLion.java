//Author: Laura Whalen

public class SeaLion extends Animal {
	public int numSpots;

	SeaLion(String species, String gender, double weight, String gpsInfo, int numSpots) {
		super(species, gender, weight, gpsInfo);
		this.numSpots = numSpots;
	}

	@Override
	public String addLine() {
		//This is where the GPS getter is called. Always position 0 because we are only adding 1 GPS coordinate at a time
		return this.species + "  -  " + this.sex + "  -  Weight: " + this.weight+"kg  -  GPS: " + this.gps.gpsInfo.get(0) + "  -  " + "Spots: " + this.numSpots;
	}
	
}
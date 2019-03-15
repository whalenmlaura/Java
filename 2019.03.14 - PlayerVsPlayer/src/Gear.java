// Author: Laura Whalen

public class Gear {
	private int strengthMod;
	private int agilityMod;
	private int cost;
	
	public Gear(int strengthMod, int agilityMod, int cost) {
		this.strengthMod = strengthMod;
		this.agilityMod = agilityMod;
		this.cost = cost;
	}
	
	public int getStrengthMod() {
		return this.strengthMod;
	}
	
	public int getAgilityMod() {
		return this.agilityMod;
	}
	
	public int getCost() {
		return this.cost;
	}
	
}

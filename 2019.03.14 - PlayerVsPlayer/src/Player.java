
public abstract class Player {
	@SuppressWarnings("unused")
	private String name;
	private int maxHealth;
	private int currentHealth;
	private int strength;
	private int agility;
	private int gold;
	private Gear gear;
	
	public Player() {
		this.maxHealth = 100;
		this.currentHealth = this.maxHealth;
		this.gold = 100;
	}//end constructor

	public void setName(String name) {
		this.name = name;
	}
		
	public int getMaxHealth() {
		return this.maxHealth;
	}
	
	public int getCurrentHealth() {
		if (this.currentHealth <= 0)
			return 0;
		return this.currentHealth;
	}
	
	public void resetHealth() {
		this.currentHealth = this.maxHealth;
	}
	
	public void dealDamage(int health) {
		if (health > 0)
			this.currentHealth -= health;
	}
	
	public int getBeforeStregth() {
		return this.strength;
	}
	
	public int getAfterStrength() {
		return this.strength + this.gear.getStrengthMod();
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public int getAgility() {
		return this.agility;
	}
	
	public int getAfterAgility() {
		return this.agility + this.gear.getAgilityMod();
	}
	
	public void setAgility(int agility) {
		this.agility = agility;
	}
	
	public int getGold() {
		return this.gold;
	}
	
	public void addGold(int value) {
		this.gold += value;
	}
	
	public void subtractGold(int value) {
		this.gold -= value;
	}
	
	public void setGear(Gear item) {
		this.gear = item;
	}
	
	public abstract int attack();
	
	
}//end class
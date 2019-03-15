// Author: Laura Whalen

public class WileECoyote extends Player {
	
	public WileECoyote() {
		super(); //calls constructor of superclass
		
		this.setName("Wile E. Coyote");
		this.setStrength(60);
		this.setAgility(20);
	}
	
	@Override
	public int attack() {
		int attacknum = (((int)(Math.random() * 5 + 1)) * ((int)(Math.random() * 2 + 3)) 
				- ((int)(Math.random() * 35 + 45))) + (this.getAfterStrength());	
		if(attacknum > 1) {
			return attacknum;
		}
		else {
			return ((int)(Math.random() * 5 + 10));
		}
	}

}

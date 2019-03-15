
public class RoadRunner extends Player {
	
	public RoadRunner() {
		super(); //calls constructor of superclass
		
		this.setName("Road Runner");
		this.setStrength(30);
		this.setAgility(50);
	}
	
	@Override
	public int attack() {
		int attacknum = (((int)(Math.random() * 6 + 1)) * ((int)(Math.random() * 2 + 3)) 
				- ((int)(Math.random() * 30 + 40))) + (this.getAfterAgility());		
		if(attacknum > 1) {
			return attacknum;
		}
		else {
			return ((int)(Math.random() * 5 + 10));
		}
	}

}
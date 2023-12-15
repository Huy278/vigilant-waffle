public class Enemy {
	private String name;
	private double health, dmgMult;
	private int souls, defence, tier;
	private Weapon eWeapon;
	//Enemy constructor(Huy)
	public Enemy(String name, double health, double dmgMult, int souls, int tier){
		this.name=name;
		this.health=health;
		this.dmgMult=dmgMult;
		this.souls=souls;
		this.tier=tier;
		//Makes the enemy have a random weapon based on the tier of the enemy
		eWeapon=allWeapons.randomTieredWeapon(tier);
		defence=1;
	}
	//Parameterless constructor(Huy)
	public Enemy(){
		name="None";
		health=0.0;
		dmgMult=1;
		souls=0;
		tier=0;
		eWeapon=null;
		defence=1;
	}
	//Prints out enemy characteristics (Huy)
	public String toString(){
		return "Enemy: " + name + " | "+ Math.round(health) + " Health | " + eWeapon;
	}
	//makes them take damage based on incoming damage and their defence(Huy)
	public void takingDamage(double damageIn){
		health-=(damageIn/defence);
	}
	//getters
	public String getName(){
		return name;
	}
	public double getHealth(){
		return health;
	}
	//Outputs damage based on their dmg multiplier and weapon
	public double dealingDamage(){
		double outDmg=eWeapon.getDamage()*dmgMult;
		return outDmg;
	}
	//getters
	public int getTier(){
		return tier;
	}
	public Weapon getWeapon(){
		return eWeapon;
	}
	public int getSouls(){
		return souls;
	}
}
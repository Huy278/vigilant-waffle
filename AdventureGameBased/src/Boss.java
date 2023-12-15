
public class Boss {
	private String name;
	private int tier, soul;
	private double defence, dmgMult, health;
	private Weapon bWeapon;
	//constructor(Huy)
	public Boss(int health, int soul, double defence, int tier) {
		this.health=health;
		this.soul=soul;
		this.defence=defence;
		this.tier=tier;
		bWeapon=allWeapons.randomTieredWeapon(tier);
	}
	//print characteristics
	public String toString(){
		return "Boss: " + name + " | "+ health + " Health | " + bWeapon;
	}
	//self explanatory
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
	//deal damage
	public double dealingDamage(){
		double outDmg=bWeapon.getDamage()*dmgMult;
		return outDmg;
	}
	//getters
	public Weapon getWeapon(){
		return bWeapon;
	}
	public int getSouls(){
		return soul;
	}
	public void addHealth(double healthAdded){
		health= health + healthAdded;
	}
}

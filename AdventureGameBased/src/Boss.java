
public class Boss {
	private String name;
	private int tier, soul;
	private double defence, dmgMult, health;
	private Weapon bWeapon;
	public Boss(int health, int soul, double defence, int tier) {
		this.health=health;
		this.soul=soul;
		this.defence=defence;
		this.tier=tier;
		bWeapon=allWeapons.randomTieredWeapon(tier);
	}
	public String toString(){
		return "Boss: " + name + " | "+ health + " Health | " + bWeapon;
	}
	public void takingDamage(double damageIn){
		health-=(damageIn/defence);
	}
	public String getName(){
		return name;
	}
	public double getHealth(){
		return health;
	}
	public double dealingDamage(){
		double outDmg=bWeapon.getDamage()*dmgMult;
		return outDmg;
	}
	public Weapon getWeapon(){
		return bWeapon;
	}
	public int getSouls(){
		return soul;
	}
}

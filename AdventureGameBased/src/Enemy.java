public class Enemy {
	private String name;
	private double health, dmgMult;
	private int souls, defence, tier;
	private Weapon eWeapon;
	public Enemy(String name, double health, double dmgMult, int souls, int tier){
		this.name=name;
		this.health=health;
		this.dmgMult=dmgMult;
		this.souls=souls;
		this.tier=tier;
		eWeapon=allWeapons.randomTieredWeapon(tier);
		defence=1;
	}
	public Enemy(){
		name="None";
		health=0.0;
		dmgMult=1;
		souls=0;
		tier=0;
		eWeapon=null;
		defence=1;
	}
	public String toString(){
		return "Enemy: " + name + " | "+ health + " Health | " + eWeapon;
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
		double outDmg=eWeapon.getDamage()*dmgMult;
		return outDmg;
	}
	public int getTier(){
		return tier;
	}
	public Weapon getWeapon(){
		return eWeapon;
	}
	public int getSouls(){
		return souls;
	}
	public void addHealth(double healthAdded){
		health= health + healthAdded
	}
}
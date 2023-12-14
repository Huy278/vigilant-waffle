
public class Enemy {
	MySQLConnect mySQL = new MySQLConnect("adventure");
	private String name;
	private double health, dmgMult;
	private int souls, defence, tier;
	private Weapon eWeapon;

	public Enemy() {
		name="whale";
		health=15;
		dmgMult=3;
		Weapon eWeapon = new Weapon("blowhole", 2);
		 
		this.eWeapon=eWeapon;
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
	public Weapon getWeapon(){
		return eWeapon;
	}

}

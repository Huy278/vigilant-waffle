
public class Enemy {
	MySQLConnect mySQL = new MySQLConnect("adventure");
	private String name;
	private double health, dmgMult;
	private int soul, defence, tier;
	private Weapon eWeapon;
	public Enemy(String name) {
		
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

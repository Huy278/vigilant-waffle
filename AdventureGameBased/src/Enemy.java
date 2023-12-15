
public class Enemy {
	MySQLConnect mySQL = new MySQLConnect("adventure");
	private String name;
	private double health, dmgMult;
	private int souls, defence, tier;
	private Weapon eWeapon;

	public Enemy() {
		
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
	public int getTier(){
		return tier;
	}
}

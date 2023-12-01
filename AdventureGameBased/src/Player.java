
public class Player {
	private String name;
	private int soul;
	private double health, defence;
	private Weapon weapon1, weapon2, weapon3;
	public Player(String name) {
		this.name=name;
		health = 100;
		soul = 0;
		defence=1;
		weapon1 = new Weapon("Pitbull", 5.0);
	}
	public Weapon getPlayerWeapon1(){
		return weapon1;
	}
	public double getHealth(){
		return health;
	}
	public String getName(){
		return name;
	}
	public void takingDamage(double damageIn){
		health-=(damageIn/defence);
	}
	public String toString(){
		return "Player: " + name + " | "+ health + " Health | " + weapon1;
	}
}

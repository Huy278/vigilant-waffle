public class Weapon {
	private String name;
	private double damage;
	public Weapon(String name, double damage) {
		this.name=name;
		this.damage=damage;
	}
	public double getDamage(){
		return damage;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return name+" "+damage+" Dmg";
	}
}

public class Weapon {
	private String name;
	private double damage;
	private int tier;
	//Parameterless Construtor(Huy)
	public Weapon(){
		name="ERROR [No weapon]";
		damage=0.0;
		tier=0;
	}
	//Constructor
	public Weapon(String name, double damage, int tier) {
		this.name=name;
		this.damage=damage;
		this.tier=tier;
	}
	//getters
	public double getDamage(){
		return damage;
	}
	public String getName(){
		return name;
	}
	public int getTier(){
		return tier;
	}
	//prints the weapon characteristics
	public String toString(){
		String output = name+" ";
		if(tier==1){
			output+="Common";
		}
		else if(tier==2){
			output+="Rare";
		}
		else if(tier==3){
			output+="Medium Rare";
		}
		else if(tier==4){
			output+="Medium";
		}
		else if(tier==5){
			output+="Medium Well";
		}
		else if(tier==6){
			output+="Well Done";
		}
		return output+" "+damage+" Dmg";
	}
}

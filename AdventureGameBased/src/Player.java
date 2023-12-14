public class Player {
	private String name;
	private int soul;
	private double health, defense;
	private Object[] inventory;
	private Weapon weapon1, weapon2, weapon3;
	
	public Player(String name) {
		this.name=name;
		health = 100;
		soul = 0;
		defense=1;
		weapon1 = new Weapon("Pitbull", 5.0, 1);
		inventory = new Object[9];
	}
	public Weapon getPlayerWeapon1(){
		return weapon1;
	}
	public double getHealth(){
		return health;
	}
	public void addDefense(int defenseAdd){
		defense+=defenseAdd;
	}
	public String getName(){
		return name;
	}
	public void takingDamage(double damageIn){
		health-=(damageIn/defense);
	}
	public String toString(){
		return "Player: " + name + " | "+ health + " Health | " + weapon1;
	}
	public String printInventory(){
		String output="---Inventory---";
		for(int i=0;i<inventory.length;i++){
			if(inventory[i]!=null){
				output+="\n"+(i+1)+": "+inventory[i];
			}
		}
		return output;
	}
	public void deleteInventoryObj(int slot){
		inventory[slot-1]=null;
	}
}
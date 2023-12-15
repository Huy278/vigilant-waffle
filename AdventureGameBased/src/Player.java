import java.util.Scanner;

public class Player {
	private String name;
	private int soul;
	private double health, defense;
	private Object[] inventory;
	private Object selectedInv;
	private Weapon weapon1;
	static Scanner scanr = new Scanner(System.in);
	//Player constructor (Huy)
	public Player(String name) {
		this.name=name;
		health = 100;
		soul = 0;
		defense=1;
		inventory = new Object[9];
		//Hard coded inventory item(Huy)
		inventory[0] = new Weapon("Pitbull", 10.0, 1);
		selectedInv = inventory[0];
	}
	//setters and getters(Huy)
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
	public Object getSelectedInv(){
		return selectedInv;
	}
	//prints out stuff player related(Huy)
	public String toString(){
		return "Player: " + name + " | "+ Math.round(health) + " Health | " + selectedInv;
	}
	//Prints player inventory using the toString methods in the objects that are in the inventory(Huy)
	public String printInventory(){
		String output="---Inventory---";
		for(int i=0;i<inventory.length;i++){
			if(inventory[i]!=null){
				output+="\n"+(i+1)+": "+inventory[i];
			}
		}
		return output;
	}
	//self explanatory(Huy)
	public void selectInventorySlot(int slot){
		selectedInv=inventory[slot-1];
	}
	//self explanatory(Huy)
	public void addInventoryObj(Object newInvObj){
		for(int i=0;i<inventory.length;i++){
			if(inventory[i]!=null){
				inventory[i]=newInvObj;
				break;
			}
		}
		System.out.println("Your inventory is full! Throw something out to clear space");
	}
	//self explanatory
	public void deleteInventoryObj(int slot){
		inventory[slot-1]=null;
	}
	//this one does damage if the player has a weapon selected and if they dont it makes them select a weapon(Huy)
	public double dealingDamage(){
		boolean flag=true;
		Weapon weaponSelected=null;
		while(flag){
			if(selectedInv instanceof Weapon){
				weaponSelected = (Weapon) selectedInv;
				flag=false;
			}
			else{
				System.out.println("You do not have a weapon selected. Select a weapon from your inventory\n"+printInventory()+"Select another slot");
				selectInventorySlot(Integer.valueOf(scanr.nextLine()));
			}
		}
		return weaponSelected.getDamage();
	}
}
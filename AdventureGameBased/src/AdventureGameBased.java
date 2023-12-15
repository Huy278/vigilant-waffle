import java.util.Scanner;

public class AdventureGameBased {
	static Scanner scanr = new Scanner(System.in);
	static MySQLConnect mySQL = new MySQLConnect("adventure");
	static allWeapons weaponList = new allWeapons();
	static allEnemies enemyList= new allEnemies();
	public static void main(String[] args) {
		//creates the table which james did
		mySQL.createTable();
		//Makes the object array and it makes the database into a 2 dimensional array
		Object[][] addArray=mySQL.unpackWeaponDatabase();
		//puts the weapons into a weapon array from the 2 dimensional array
		putWeaponsInArray(addArray);
		//Makes the object array and it makes the database into a 2 dimensional array
		Object[][] enemyArr = mySQL.unpackEnemyDatabase();
		//puts the enemies into an enemy array from the 2 dimensional array
		putEnemiesInArray(enemyArr);
		boolean running=true;
		//while loop contains the entirety of the game currently
		while(running){
			clearScreen();
			System.out.println("Adventure Game\n\nEnter to Start");
			//Once they click enter it goes
			scanr.nextLine();
			clearScreen();
			int choice;
			//hard coded player object
			Player newPlayer=new Player("New guy");
			//random enemy
			Enemy newEnemy= allEnemies.randomTieredEnemy(1);
			choice=decisionMaker("Attack "+newEnemy,"Do nothing","Drink potions","Leave");
			if(choice==1){
				battle(newPlayer, newEnemy);
			}
			else if(choice==3){
				clearScreen();
				System.out.println("You drank");
				//use this to manually test mysql connection stuff
				
				/*MySQLConnect alfa = new MySQLConnect("adventure");
				alfa.createTable();
				Object[][] enemyArr = alfa.unpackEnemyDatabase();
				print(enemyArr);
				putEnemiesInArray(enemyArr);*/
			}
			System.out.println("Type \"Play Again\" to play again or anything else to quit.");
			if(!scanr.nextLine().equals("Play Again")){
				running=false;
			};
		}
			scanr.close();
	}
	public static int decisionMaker(String... decisions){
		boolean flag=true;
		int output=0;
		String input="";
		while(flag){
			for(int i=0; i<decisions.length; i++){
				System.out.println((i+1)+". "+decisions[i]);
			}
			input=scanr.nextLine();
			flag=false;
			try {
				if(Integer.parseInt(input)<decisions.length&&Integer.parseInt(input)>0){
        			output=Integer.parseInt(input);
				}
    		} catch (NumberFormatException e) {
				flag=true;
    		}
			if(flag){
				clearScreen();
				System.out.println("*ERROR* Please input an option from the above options\n");
			}
		}
		return output;
	}
	public static int decisionMaking(String decision1, String decision2, String decision3, String decision4) {
		boolean flag=true;
		int output=0;
		String input="";
		while(flag) {
			System.out.println(
			"\n1. "+ decision1+
			"\n2. "+ decision2+
			"\n3. "+ decision3+
			"\n4. "+ decision4);
			input = scanr.nextLine();
			flag=false;
			if(input.equals("1")) {
				output=1;
			}
			else if(input.equals("2")) {
				output=2;
			}
			else if(input.equals("3")) {
				output=3;
			}
			
			else if(input.equals("4")) {
				output=4;
			}
			else {
				flag=true;
				clearScreen();
				System.out.println("*ERROR* Please input an option from the above options" + input);
			}
			if(!flag){
				clearScreen();
				System.out.println("Decision " + input + " selected\n");
			}
		}
		return output;
	}
	public static boolean battle(Player thePlayer, Enemy theEnemy){
		boolean win=true;
		while(theEnemy.getHealth()>0){
			System.out.println(theEnemy+"\n"+thePlayer);
			if(decisionMaking("Attack with: "+thePlayer.getSelectedInv(),"Don't attack","Handstand","Stand still")==1){
				theEnemy.takingDamage(thePlayer.dealingDamage());
			}
			if(theEnemy.getHealth()>0){
				thePlayer.takingDamage(theEnemy.dealingDamage());
			}
			if(thePlayer.getHealth()<=0){
				break;
			}
		}
		if(theEnemy.getHealth()<=0){
			clearScreen();
			System.out.println(theEnemy+"\n"+thePlayer+"\n\nEnemy \""+theEnemy.getName()+"\" died, You win");
			return win;
		}
		else{
			win=false;
			System.out.println(theEnemy+"\n"+thePlayer+"\n\n"+thePlayer.getName()+" died, You lose");
			return win;
		}
	}
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	static void print (Object[][] arr) {
		String temp = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j< arr[0].length; j++) {
				temp += arr[i][j];
				if (j != arr[0].length-1) {
					temp += " | ";
				}
			}
			temp += "\n";
		}
		System.out.println(temp);
	}
	
	static void putWeaponsInArray (Object[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			weaponList.addWeapon(arr[i][0].toString(),((Number)arr[i][1]).doubleValue(),(int)arr[i][2]);
		}
	}
	static void putEnemiesInArray (Object[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			enemyList.addEnemy(arr[i][0].toString(),((Number)arr[i][1]).doubleValue(),((Number)arr[i][2]).doubleValue(),(int)arr[i][3],(int)arr[i][4]);
		}
	}
	//static void pickWeapon
}
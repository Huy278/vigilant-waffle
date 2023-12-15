import java.util.Scanner;

public class AdventureGameBased {
	static Scanner scanr = new Scanner(System.in);
	static MySQLConnect mySQL = new MySQLConnect("adventure");
	static allWeapons weaponList = new allWeapons();
	static allEnemies enemyList= new allEnemies();
	public static void main(String[] args) {
		mySQL.createTable();
		Object[][] weaponArray=mySQL.unpackWeaponDatabase();
		putWeaponsInArray(weaponArray);
		Object[][] enemyArr = mySQL.unpackEnemyDatabase();
		putEnemiesInArray(enemyArr);
		boolean running=true;
		while(running){
			clearScreen();
			System.out.println("Adventure Game\n\nEnter to Start");
			scanr.nextLine();
			clearScreen();
			int choice;
			Player newPlayer=new Player("New guy");
			Enemy newEnemy= allEnemies.randomTieredEnemy(1);
			choice=decisionMaking("Attack "+newEnemy,"Do nothing","Drink potions","Leave");
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
				System.out.println("*ERROR* Please input an option from the above options " + input);
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
			if(decisionMaking("Attack with: "+thePlayer.getPlayerWeapon1(),"Don't attack","Handstand","Stand still")==1){
				theEnemy.takingDamage(thePlayer.getPlayerWeapon1().getDamage());
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
}
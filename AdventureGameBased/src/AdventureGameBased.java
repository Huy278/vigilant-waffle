import java.util.Scanner;

public class AdventureGameBased {
	static Scanner scanr=new Scanner(System.in);
	MySQLConnect mySQL = new MySQLConnect("adventureGame");
	public static void main(String[] args) {
		boolean running=true;
		while(running){
			int level=1;
			clearScreen();
			System.out.println("Adventure Game\n\nEnter to Start");
			scanr.nextLine();
			clearScreen();
			int choice;
			Player newPlayer=new Player("New guy");
			choice=decisionMaking("Attack enemy: Baby","Do nothing","Drink potions","Leave");
			if(choice==1){
				Weapon gun = new Weapon("Gun", 20);
				Enemy baby= new Enemy("Baby", 10.0, 1.0, 1, 1, gun);
				battle(newPlayer, baby);
			}
			else if(choice==3){
				clearScreen();
				System.out.println("You drank");
				MySQLConnect alfa = new MySQLConnect("adventure");
				Object[][] enemyArr = alfa.unpackEnemyDatabase();
				print(enemyArr);
			}
			System.out.println("Type \"Play Again\" to play again or anything else to quit.");
			if(!scanr.nextLine().equals("Play Again")){
				running=false;
			};
		}
			scanr.close();
	}
	public static int decisionMaking(String decision1, String decision2, String decision3, String decision4) {
		Scanner scanr=new Scanner(System.in);
		boolean flag=true;
		int output=0;
		
		while(flag) {
			System.out.println(
			"\n1. "+ decision1+
			"\n2. "+ decision2+
			"\n3. "+ decision3+
			"\n4. "+ decision4);
			String input=scanr.nextLine();
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
		while(theEnemy.getHealth()>0&&thePlayer.getHealth()>0){
			System.out.println(theEnemy+"\n"+thePlayer);
			if(decisionMaking("Attack with: "+thePlayer.getPlayerWeapon1(),"Don't attack","Handstand","Stand still")==1){
				theEnemy.takingDamage(thePlayer.getPlayerWeapon1().getDamage());
			}
			if(theEnemy.getHealth()>0){
				thePlayer.takingDamage(theEnemy.dealingDamage());
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
}
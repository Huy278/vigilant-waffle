import java.util.Scanner;

public class AdventureGameBased {
	static Scanner scanr=new Scanner(System.in);
	MySQLConnect mySQL = new MySQLConnect("adventure");
	public static void main(String[] args) {
		System.out.println("Start Game\n\nEnter to Start");
		scanr.nextLine();
		int choice;
		choice=decisionMaking("Kill Babies", "Run away", "level thing", "Pick up weapon");
	}
	public static int decisionMaking(String decision1, String decision2, String decision3, String decision4) {
		Scanner scr=new Scanner(System.in);
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
				System.out.println("Decision " + input + " selected");
				output=1;
			}
			else if(input.equals("2")) {
				System.out.println("Decision " + input + " selected");
				output=2;
			}
			else if(input.equals("3")) {
				System.out.println("Decision " + input + " selected");
				output=3;

				//put level method here
				level starter = new level();
				

			}
			else if(input.equals("4")) {
				System.out.println("Decision " + input + " selected");
				output=4;
			}
			else {
				flag=true;
				System.out.println("*ERROR* Please input an option from the above options " + input);
			}
		}
		return output;
	}
}
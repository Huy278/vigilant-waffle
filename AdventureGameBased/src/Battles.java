import java.util.Scanner;
public class Battles {
	static Scanner scanr=new Scanner(System.in);
    public String name;
	public boolean done = false;
    public Battles() {
		/*System.out.println("wait whats name");
		String name=scanr.nextLine();
		Player p = new Player(name);
		Enemy e = new Enemy();	
		while(!done) {
			System.out.println("what you doing");

		}
		*/
		
		System.out.println("fight yes");
		scanr.nextLine();
		int choice;
		choice=decisionMaking("fioght enemy", "Run away", "dontpickthis","dontpickthis");
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
	public static int decisionMaking(String decision1, String decision2,String decision3,String decision4) {
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
				battle();
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
}

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Room {
    Random rnd = new Random();
    boolean done = false;
    Scanner Space = new Scanner(System.in);
    String input;
    int amount;
    int Ichose;

    public Room (Player thePlayer) {
        Weapon gun; 
        //Enemy[] enemyArray = new Enemy[amount];
        amount = rnd.nextInt(1,5);
        ArrayList<Enemy> enemyArray = new ArrayList<Enemy>();
        
        System.out.println(amount);
        while (!done) {
        System.out.println("what arth you doin");
        System.out.println("1: FIGHT!!! (if you want)");
        System.out.println("2: leave to another room");
        System.out.println("3: check your status");
        System.out.println("4: check surounding/enemys");
      
        input = Space.nextLine();
        
        if (input.equals("1")) {
            input = "";
            System.out.println("who fighting");
            input = Space.nextLine();
            Ichose = Integer.parseInt(input);
            Enemy CEnemy = enemyArray.get(Ichose -1);
            Battles.battle(thePlayer,CEnemy);
        }
        if (input.equals("2")) {
            /* pulls up avalible options to other rooms */



        }
        if (input.equals("3")) {
            /* function for cecking status*/
        }
        if (input.equals("4")) {
            /*function that shows the stats of a enemy in the room your in */
        }
        
        }
    }
    public ArrayList<Enemy> enemyCreation (int amount, ArrayList<Enemy> enemyArray) {
        
       
        // Enemy[] eList = new Enemy[];

        for(int i = 1; i < amount; i++) {
            Enemy e = new Enemy();
            enemyArray.add(e);
        }
        return enemyArray;
    }
    
}

import java.util.Random;
import java.util.Scanner;
public class Room {
    Random rnd = new Random();
    boolean done = false;
    Scanner Space = new Scanner(System.in);
    String input;
    int amount;
    
    public Room (Player thePlayer) {
        Weapon gun; 
        Enemy[] enemyArray;
        amount = rnd.nextInt(1,5);
        enemyCreation(amount);
        
        System.out.println(amount);
        while (!done) {
        System.out.println("what arth you doin");
        System.out.println("1: FIGHT!!! (if you want)");
        System.out.println("2: leave to another room");
        System.out.println("3: check your status");
        System.out.println("4: check surounding/enemys");
      
        input = Space.nextLine();
        
        if (input.equals("1")) {
            Battles b = new Battles();

            b.battle(thePlayer,enemyArray[1]);
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
    public Enemy enemyCreation (int amount) {
        
        
        // Enemy[] eList = new Enemy[];

        for(int i = 1; i <= amount; i++) {
            Enemy e = new Enemy();
            e.name("dog");
        }
    }
    
}

import java.util.Random;
import java.util.Scanner;
public class Room {
    Random rnd = new Random();
    boolean dead = false;
    Scanner Space = new Scanner(System.in);
    String input;
    int amount;
    
    public Room (Player thePlayer) {
        Weapon gun; 
        Enemy e = new Enemy();
        amount = rnd.nextInt(1,5);

        
        System.out.println(amount);
        while (!dead) {
        System.out.println("what arth you doin");
        System.out.println("1: FIGHT!!! (if you want)");
        System.out.println("2: leave to another room");
        System.out.println("3: check your status");
        System.out.println("4: check surounding/enemys");
      
        input = Space.nextLine();
        
        if (input.equals("1")) {
            Battles b = new Battles();

            b.battle(thePlayer,e);
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
    
    
}

import java.util.Random;
import java.util.Scanner;
public class Room {
    Random rnd = new Random();
    boolean dead = false;
    Scanner Space = new Scanner(System.in);
    String input;
    public Room () {
        while (!dead) {
        System.out.println("what arth you doin");
        System.out.println("1: do something smart");
        System.out.println("2: do something really Dumb");
        input = Space.nextLine();
        
        if (input.equals("1")) {
            
        }
        if (input.equals("2")) {
            dead = true;
            System.out.println("you died");
        }
        }
    }
    
    
}

public class Room extends level{
    Random rnd = new Random();
    boolean dead = false;
    Scanner Space = new Scanner(System.in);
    String input; 
    public Room () {
        rnd.next(0,tier);
        
        while (!dead) {
            System.out.println("The hell you doin");
            System.out.println("1: do something smart");
            System.out.println("2: do something really Dumb");
            input = Space.nextLine();

            
        }
    }

}
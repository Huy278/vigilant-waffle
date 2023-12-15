public class Food extends Item{
    double nutrition;
    //constructor(Huy)
    public Food(String name, double nutrition){
        super(name);
        this.nutrition=nutrition;
    }
    //prints characteristics
    public String toString(){
        return name+" Nutrition: "+nutrition;
    }
}

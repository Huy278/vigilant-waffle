public class Armor extends Item{
    double defense;
    //constructor(Huy)
    public Armor(String name, double defense){
        super(name);
        this.defense=defense;
    }
    //prints characteristics(Huy)
    public String toString(){
        return name+" Defence: "+defense;
    }
}

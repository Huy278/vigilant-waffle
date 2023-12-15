import java.util.ArrayList;
import java.util.Random;
public class allWeapons {
    static ArrayList<Weapon> weaponArray;
    //the whole weapon array is used to store and then clone weapon objects and is not used directly or shown in the game just like the enemy one.(Huy)
    //constructor(Huy)
    public allWeapons(){
        weaponArray = new ArrayList();
    }
    //adds weapon to the weapon array
    public void addWeapon(String wName, double wDamage, int wTier){
        weaponArray.add(new Weapon(wName,wDamage,wTier));
    }
    //Gets a random weapon that is of the tier that is put in
    public static Weapon randomTieredWeapon(int inTier){
        Random rnd = new Random();
        Weapon outWeapon = new Weapon();
        if(inTier==1||inTier==2||inTier==3||inTier==4||inTier==5||inTier==6){
            while(outWeapon.getTier()!=inTier){
                outWeapon = weaponArray.get(rnd.nextInt(weaponArray.size()));
            }
        }
        return outWeapon;
    }
}

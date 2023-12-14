import java.util.ArrayList;
import java.util.Random;
public class allWeapons {
    static ArrayList<Weapon> weaponArray;
    public allWeapons(){
    }
    public void addWeapons(){
        weaponArray = new ArrayList();
        weaponArray.add(new Weapon("Gun",20.0,1));
        weaponArray.add(new Weapon("Awesome-cannon",24.0,2));
    }
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

import java.util.ArrayList;
import java.util.Random;
public class allWeapons {
    static ArrayList<Weapon> weaponArray;
    public allWeapons(){
        weaponArray = new ArrayList();
    }
    public void addWeapon(String wName, double wDamage, int wTier){
        weaponArray.add(new Weapon(wName,wDamage,wTier));
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

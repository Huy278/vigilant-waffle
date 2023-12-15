import java.util.ArrayList;
import java.util.Random;
public class allEnemies {
    private static ArrayList<Enemy> enemyArray;
    //the whole enemy array is used to store and then clone enemy objects and is not used directly or shown in the game.
    //constructor(Huy)
    public allEnemies(){
        enemyArray=new ArrayList();
    }
    //adds enemy to the enemy array
    public void addEnemy(String eName, double eHealth, double eDmgMult, int eSouls, int eTier){
        enemyArray.add(new Enemy(eName,eHealth,eDmgMult,eSouls,eTier));
    }
    //outputs a random enemy with a random weapon based on the tier that is inputted (Huy)
    public static Enemy randomTieredEnemy(int inTier){
        Random rnd = new Random();
        Enemy outEnemy = new Enemy();
        if(inTier==1||inTier==2||inTier==3||inTier==4||inTier==5||inTier==6){
             while(outEnemy.getTier()!=inTier){
                outEnemy = enemyArray.get(rnd.nextInt(enemyArray.size()));
             }
        }
        return outEnemy;
    }
}
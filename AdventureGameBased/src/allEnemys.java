
import java.util.ArrayList;
import java.util.Random;
public class allEnemys {


    static ArrayList<Enemy> enemyArray;
    public allEnemys(){
        }
    public void addWeapons(){
        enemyArray = new ArrayList();
        enemyArray.add(new Enemy());
        enemyArray.add(new Enemy());
        }
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
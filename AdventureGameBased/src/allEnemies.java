import java.util.ArrayList;
import java.util.Random;
public class allEnemies {
    private static ArrayList<Enemy> enemyArray;
    public allEnemies(){
        enemyArray=new ArrayList();
    }
    public void addEnemy(String eName, double eHealth, double eDmgMult, int eSouls, int eTier){
        enemyArray.add(new Enemy(eName,eHealth,eDmgMult,eSouls,eTier));
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
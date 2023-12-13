public class Battles {
    
    public static boolean battle(Player thePlayer, Enemy theEnemy){
		boolean win=true;
		while(theEnemy.getHealth()>0&&thePlayer.getHealth()>0){
			System.out.println(theEnemy+"\n"+thePlayer);
			if(decisionMaking("Attack with: "+thePlayer.getPlayerWeapon1(),"Don't attack","Handstand","Stand still")==1){
				theEnemy.takingDamage(thePlayer.getPlayerWeapon1().getDamage());
			}
			if(theEnemy.getHealth()>0){
				thePlayer.takingDamage(theEnemy.dealingDamage());
			}
		}
		if (theEnemy.getHealth()<=0){
			clearScreen();
			System.out.println(theEnemy+"\n"+thePlayer+"\n\nEnemy \""+theEnemy.getName()+"\" died, You win");
			return win;
		}
		else {
			win=false;
			System.out.println(theEnemy+"\n"+thePlayer+"\n\n"+thePlayer.getName()+" died, You lose");
			return win;
		}
        
	}
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnect {
    // Properties of the MySQLConnection Class
	Connection connection = null;
	Statement statement = null;
    public MySQLConnect(String db) {
    	
        String url = "jdbc:mysql://localhost:3306/"+db;

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "Keefe2012");
            statement = connection.createStatement();

       }
       catch (Exception e) {
            System.out.println(e);
        }    
    }
   
    public ResultSet select(String sql) {
        ResultSet resultSet = null;
        
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultSet;
    }
    //note: create table is a absolute text wall, it has (hopefully) been closed for your convienience.
    public void createTable() {
    	try {
			statement.executeUpdate("use adventure; ");
			statement.executeUpdate("drop table if exists Weapon, Enemy, Boss, Food, Armor; ");
			statement.executeUpdate("create table Weapon (id int not null auto_increment primary key, name varchar(200),damage double, tier int); ");
			statement.executeUpdate("create table Enemy (id int not null auto_increment primary key, name varchar(200),health double, dmgMult double, coins int, tier int); ");
			statement.executeUpdate("create table Boss (id int not null auto_increment primary key, name varchar(200),health double, dmgMult double, coins int, tier int); ");
			statement.executeUpdate("create table Food(id int not null auto_increment primary key, name varchar(200), health double, tier int); ");
			statement.executeUpdate("create table Armor (id int not null auto_increment primary key, name varchar(200), defence int, tier int); ");
			
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"shadow scythe\", 88.0, 4); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"gold cannon\", 13.0, 2); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"blood ball\", 9.0, 1); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"death laser\", 93.0, 4); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"red bolt\", 39.0, 3); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"endless pole\", 16.0, 2); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"rocket pistol\", 22.0, 2); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"dark prism\", 77.0, 4); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"rain orb\", 66.0, 3); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"hell star\", 27.0, 2); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"razor disc\", 88.0, 4); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"holy chain\", 300.0, 6); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"heavenly dagger\", 500.0, 6); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"ice bow\", 11.0, 1); ");
			statement.executeUpdate( "insert into Weapon (name, damage, tier) values(\"bone sword\", 44.0, 3); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"vortex dart\",74.0, 4); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"flaming kunai\", 80.0, 4); ");
			statement.executeUpdate( "insert into Weapon (name, damage, tier) values(\"storm breaker\", 83.0, 4); ");
			statement.executeUpdate( "insert into Weapon (name, damage, tier) values(\"detached darkness\", 7.0, 1); ");
			statement.executeUpdate( "insert into Weapon (name, damage, tier) values(\"mega potato\", 3.0, 1); ");
			statement.executeUpdate( "insert into Weapon (name, damage, tier) values(\"magic shard\", 25.0, 2);");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"multiversal trident\", 100.0, 5); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"soul shooter\", 150.0, 5); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"cosmic chainsaw\", 200.0, 5); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"moon zephyr\", 18.0, 2); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"basic paper\", 1.0, 1); ");
			statement.executeUpdate( "insert into Weapon (name, damage, tier) values(\"radio nunchuck\", 35.0, 3); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"time hammer\",250.0, 6); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"atomic knife\", 105.0, 5); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"wave clock\", 48.0, 3); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"invincble matter\", 350.0, 6); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"nuclear sphere\", 180, 5); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"angelic machete\", 230.0, 5); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"flashing axe\", 53.0, 3); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"supreme sai\", 330.0, 6); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"body launcher\", 59.0, 3); ");
			statement.executeUpdate("insert into Weapon (name, damage, tier) values(\"demon warhead\", 170.0, 5); ");
			
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"freaky dwarf\", 200, 13.0, 150, 1); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"malnourished troll\", 205, 14.0, 200, 1); ");
			statement.executeUpdate( "insert into Enemy (name,health,dmgMult, coins, tier) values(\"scorpion guy\", 210, 15.0, 250, 2); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"murderous spirit\", 215, 16.0, 300, 2); ");
			statement.executeUpdate( "insert into Enemy (name,health,dmgMult, coins, tier) values(\"metal dragon\", 220, 17.0, 350, 3); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"frost soldier\", 225, 18.0, 400, 3); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"rainbow ghoul\", 230, 19.0, 450, 3); ");
			statement.executeUpdate( "insert into Enemy (name,health,dmgMult, coins, tier) values(\"cloaked fox\", 235, 20.0, 500, 4); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"zombie ox\", 240, 21.0, 550, 4); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"robtic bear\", 245, 22.0, 600, 4); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"mutated gorilla\", 250, 23.0, 650, 4); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"android\", 300,24.0, 700, 5); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"batcoon\", 350,25.0, 750, 5); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"manowl\", 400,26.0, 800, 5); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"ball boy\", 450,27.0, 850, 5); ");
			statement.executeUpdate("insert into Enemy (name,health,dmgMult, coins, tier) values(\"poison king\", 500,28.0, 900, 6); ");
			statement.executeUpdate( "insert into Enemy (name,health,dmgMult, coins, tier) values(\"infinity bug\", 550,29.0, 950, 6); ");
			statement.executeUpdate( "insert into Enemy (name,health,dmgMult, coins, tier) values(\"broken man\", 600,30.0, 1000, 6); ");
			
			statement.executeUpdate("insert into Boss (name,health,dmgMult, coins, tier) values(\"humankind\", 900,40.0, 1800, 1);");
			statement.executeUpdate("insert into Boss (name,health,dmgMult, coins, tier) values(\"extraterrestrial\", 950,50.0, 2100, 2); ");
			statement.executeUpdate("insert into Boss (name,health,dmgMult, coins, tier) values(\"sea king\", 1000,60.0, 2400, 3); ");
			statement.executeUpdate("insert into Boss (name,health,dmgMult, coins, tier) values(\"space emperor\", 1050, 70.0, 2700, 4); ");
			statement.executeUpdate("insert into Boss (name,health,dmgMult, coins, tier) values(\"death reaper\", 1100, 80.0, 3000, 5); ");
			statement.executeUpdate("insert into Boss (name,health,dmgMult, coins, tier) values(\"infinty god\", 1150, 90.0, 3300, 6); ");

			statement.executeUpdate( "insert into Food (name, health, tier) values(\"mystical rare steak\", 40, 3); ");
			statement.executeUpdate("insert into Food (name, health, tier) values(\"monstrous turkey bacon\", 80, 5); ");
			statement.executeUpdate("insert into Food (name, health, tier) values(\"sand tree biscuit\", 10, 1); ");
			statement.executeUpdate("insert into Food (name, health, tier) values(\"scrumptious horn berries\", 85, 5); ");
			statement.executeUpdate("insert into Food (name, health, tier) values(\"ultra smokey pasta\", 95, 6); ");
			statement.executeUpdate("insert into Food (name, health, tier) values(\"divine chicken wings\", 100, 6); ");
			statement.executeUpdate( "insert into Food (name, health, tier) values(\"celestial seafood sandwhich\", 65, 4); ");
			statement.executeUpdate("insert into Food (name, health, tier) values(\"luminous glowing nuts\", 75, 4); ");
			statement.executeUpdate("insert into Food (name, health, tier) values(\"decent cotton candy\", 25, 2); ");
			statement.executeUpdate("insert into Food (name, health, tier) values(\"godlike chocolate croissants\", 100,6); ");

			statement.executeUpdate( "insert into Armor (name, defence, tier) values(\"pinnacle immortal armor\", 10, 6); ");
			statement.executeUpdate("insert into Armor (name, defence, tier) values(\"weak immortal armor\", 8, 5); ");
			statement.executeUpdate("insert into Armor (name, defence, tier) values(\"fundamental demi armor\", 6, 3); ");
			statement.executeUpdate("insert into Armor (name, defence, tier) values(\"pinnacle mortal armor\", 4, 2); ");
			statement.executeUpdate("insert into Armor (name, defence, tier) values(\"weak mortal armor\", 2, 1); ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public Object[][] unpackEnemyDatabase(){
    	ResultSet results;
    	int height = 0;
    	try {
    	results=statement.executeQuery("select count(id) from Enemy;");
    	
    	while (results.next()) {
			height = results.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Object[][] arr = new Object[height][5];
    	int i = 0;
    	try {
    		results=statement.executeQuery("select * from Enemy;");
			while (results.next()) {
					arr[i][0] = results.getString(2);
					arr[i][1] = results.getDouble(3);
					arr[i][2] = results.getDouble(4);
					arr[i][3] = results.getInt(5);
					arr[i][4] = results.getInt(6);
					i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return arr;
    }
    
    public Object[][] unpackBossDatabase(){
    	ResultSet results;
    	int height = 0;
    	try {
    	results=statement.executeQuery("select count(id) from Boss;");
    	
		
    	while (results.next()) {
			height = results.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Object[][] arr = new Object[height][5];
    	int i = 0;
    	try {
    		results=statement.executeQuery("select * from Boss;");
			while (results.next()) {
					arr[i][0] = results.getString(2);
					arr[i][1] = results.getInt(3);
					arr[i][2] = results.getDouble(4);
					arr[i][3] = results.getInt(5);
					arr[i][4] = results.getInt(6);
					i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return arr;
    }
    
    public Object[][] unpackWeaponDatabase(){
    	ResultSet results;
    	int height = 0;
    	try {
    	results=statement.executeQuery("select count(id) from Weapon;");
    	
		
    	while (results.next()) {
			height = results.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Object[][] arr = new Object[height][3];
    	int i = 0;
    	try {
    		results=statement.executeQuery("select * from Weapon;");
			while (results.next()) {
					arr[i][0] = results.getString(2);
					arr[i][1] = results.getDouble(3);
					arr[i][2] = results.getInt(4);
					i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return arr;
    }
    
    public Object[][] unpackFoodDatabase(){
    	ResultSet results;
    	int height = 0;
    	try {
    	results=statement.executeQuery("select count(id) from Food;");
    	
		
    	while (results.next()) {
			height = results.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Object[][] arr = new Object[height][3];
    	int i = 0;
    	try {
    		results=statement.executeQuery("select * from Food;");
			while (results.next()) {
					arr[i][0] = results.getString(2);
					arr[i][1] = results.getInt(3);
					arr[i][2] = results.getInt(4);
					i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return arr;
    }
    
    public Object[][] unpackArmorDatabase(){
    	ResultSet results;
    	int height = 0;
    	try {
    	results=statement.executeQuery("select count(id) from Armor;");
    	
		
    	while (results.next()) {
			height = results.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Object[][] arr = new Object[height][3];
    	int i = 0;
    	try {
    		results=statement.executeQuery("select * from Armor;");
			while (results.next()) {
					arr[i][0] = results.getString(2);
					arr[i][1] = results.getInt(3);
					arr[i][2] = results.getInt(4);
					i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return arr;
    }
}




  
/**
 * 
 */

/**
 * @author Lahiru Rajamanthri
 *
 */
public class Animal {
	
	private static int health = 0;
	private static int food = 0;
	private static int stamina = 0;
	private static int mood = 0;
	private static String name = "";
	
	public Animal(String name, int food, int health, int stamina, int mood) {
		Animal.name = name;
		Animal.health = health;
		Animal.food = food;
		Animal.stamina = stamina;
		Animal.mood = mood;
	}
	
	// animal getters
	public static String getName() {return name;}
	public static int getHealth() {return health;}
	public static int getFood() {return food;}
	public static int getStamina() {return stamina;}
	public static int getMood() {return mood;}
	
	// animal setters
	public void setName(String n) {name = n;}
	public void setHealth(int  h) {health = h;}
	public void setFood(int  f) {food = f;}
	public void setStamina(int  s) {stamina = s;}
	public void setMood(int  m) {mood = m;}

}
}

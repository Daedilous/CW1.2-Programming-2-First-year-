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
	
	public Animal(int food, int health, int stamina, int mood) {
		This.health = health;
		This.food = food;
		This.stamina = stamina;
		This.mood = mood;
	}
	
	// animal getters
	public static int getHealth() {return health;}
	public static int getFood() {return food;}
	public static int getStamina() {return stamina;}
	public static int getMood() {return mood;}
	
	// animal setters
	public void setHealth(int  h) {health = h;}
	public void setFood(int  f) {food = f;}
	public void setStamina(int  s) {stamina = s;}
	public void setMood(int  m) {mood = m;}

}

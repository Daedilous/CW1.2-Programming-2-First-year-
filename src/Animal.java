  
/**
 * 
 	*@author Lahiru Rajamanthri
	 * @author Harrison Bell
	 * @author Jade Sumner
	 * @author Luke Reading
 * This class holds the stats for the pet. 
 * if health gets to 0 the pet dies.
 * if food is 0 pet cannot eat
 * 
 */
public class Animal {
	/*
	 * class integer and string values to hold the Animal's parameters
	 */
	private String name = "";
	private int health = 0;
	private int food = 0;
	private int stamina = 0;
	private int mood = 0;
	private int foodBucket = 0;
	
	public Animal(String name, int food, int health, int stamina, int mood, int foodBucket) {
		/**
		 * Constructor for Animal object
		 * @param	name	Pet's name
		 * @param 	food	Pet's food value
		 * @param 	health 	Pet's health value
		 * @param	stamina	Pet's stamina value
		 * @param	mood	Pet's mood value
		 * @param	foodBucket	Pet's food bucket value
		 */
		this.name = name;
		this.health = health;
		this.food = food;
		this.stamina = stamina;
		this.mood = mood;
		this.foodBucket = foodBucket;
	}
	
	// animal getters
	public String getName() {return this.name;}
	public int getHealth() {return this.health;}
	public int getFood() {return this.food;}
	public int getStamina() {return this.stamina;}
	public int getMood() {return this.mood;}
	public int getFoodBucket() {return this.foodBucket;}
	
	// animal setters
	public void setName(String n) {this.name = n;}
	public void setHealth(int  h) {this.health = h;}
	public void setFood(int  f) {this.food = f;}
	public void setStamina(int  s) {this.stamina = s;}
	public void setMood(int  m) {this.mood = m;}
	public void setFoodBucket(int fb) {this.foodBucket = fb;}
}

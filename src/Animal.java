
/**
 * @author Lahiru Rajamanthri
 *
 */
public class Animal {
	
	private int health = 0;
	private int food = 0;
	private int stamina = 0;
	private int mood = 0;
	
	
	public Animal(int food, int health, int stamina, int mood) {
		this.health = health;
		this.food = food;
		this.stamina = stamina;
		this.mood = mood;
	}
	
	// animal getters
	public int getHealth() {return this.health;}
	public int getFood() {return this.food;}
	public int getStamina() {return this.stamina;}
	public int getMood() {return this.mood;}
	
	// animal setters
	public void setHealth(int  h) {this.health = h;}
	public void setFood(int  f) {this.food = f;}
	public void setStamina(int  s) {this.stamina = s;}
	public void setMood(int  m) {this.mood = m;}
	
	// animal assessment
	public String assessment() {
		String assessment = "";
		if(this.health <= 50) {
			assessment += "I need care. ";
		}else if(this.food <= 50) {
			assessment += "I need food. ";
		}else if(this.stamina <= 50) {
			assessment += "I need rest. ";
		}else if(this.mood <= 50) {
			assessment += "I want to play";
		}else {
			assessment = "Your pet is healthy";
		}
		return assessment;
	}

}

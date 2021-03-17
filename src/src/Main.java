import java.util.Random;

/**
 * 
 */

/**
 * @author Lahiru Rajamanthri
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int randomHealth = randomStat();
		int randomFood = randomStat();
		int randomStamina = randomStat();
		int randomMood = randomStat();
		
		Animal p = new Animal(randomFood, randomHealth, randomStamina, randomMood);
		System.out.println( "Heath = " + Animal.getHealth());
		System.out.println("Food = " + Animal.getFood());
		System.out.println("Stamina = " + Animal.getStamina());
		System.out.println("Mood = " + Animal.getMood());
		System.out.println("animal is being fed");
		p.setFood(increaseFood());
		System.out.println("animal fed = " + Animal.getFood());
		System.out.println("Health increased by + 5 = " + increaseHealth());
	}
	private static int randomStat() {
		Random rand = new Random();
		int upperbound = 99;
		int stat = rand.nextInt(upperbound + 1);
		return stat;
		
	}
	private static int increaseHealth() {
		return Animal.getHealth() + 5;
	}
	private static int increaseFood() {
		return Animal.getFood() + 5;
	}
	private static int increaseStamina() {
		return Animal.getStamina() + 5;
	}
	private static int increaseMood() {
		return Animal.getMood() + 5;
	}
	

}

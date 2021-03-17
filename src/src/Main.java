import java.util.Random;
import java.util.Scanner;
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
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter pet name:");
		String name = reader.nextLine();
		reader.close();
		
		Animal p = new Animal(name, randomFood, randomHealth, randomStamina, randomMood);
		System.out.println( "Animal name = " + p.getName());
		System.out.println( "Heath = " + p.getHealth());
		System.out.println("Food = " + p.getFood());
		System.out.println("Stamina = " + p.getStamina());
		System.out.println("Mood = " + p.getMood());

		
		System.out.println("Health increased by + 5 = " + increaseHealth(p));
		System.out.println("Food increased by + 5 = " + increaseFood(p));
		System.out.println("Stamina increased by + 5 = " + increaseStamina(p));
		System.out.println("Mood increased by + 5 = " + increaseMood(p));
		
	}
	private static int randomStat() {
		Random rand = new Random();
		int upperbound = 99;
		int stat = rand.nextInt(upperbound + 1);
		return stat;
		
	}
	private static int increaseHealth(Animal p) {
		
		return p.getHealth() + 5;
	}
	private static int increaseFood(Animal p) {
		return p.getFood() + 5;
	}
	private static int increaseStamina(Animal p) {
		return p.getStamina() + 5;
	}
	private static int increaseMood(Animal p) {
		return p.getMood() + 5;
	}
	

}


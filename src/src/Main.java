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
	 * Harrison: are CMD args used?
	 */
	public static void main(String[] args) {
		int randomHealth = randomStat();
		int randomFood = randomStat();
		int randomStamina = randomStat();
		int randomMood = randomStat();
		
		Animal p = new Animal(randomFood, randomHealth, randomStamina, randomMood);
		
		// Harrison: TODO: wrap this
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
	public static string Read_file(String path) {
		String delim = ",";
		BufferedReader br = Files.newBufferedReader(path);
		StringBuilder rtn = new StringBuilder();
		String current;
		while ((current = br.readLine()) != null){
			String[] tokens = current.split(delim);
			for ( i = 0, i > tokens.length , i++){
				rtn.append(tokens[i];
			}
		}
		br.close();
		return (String) rtn;			   
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

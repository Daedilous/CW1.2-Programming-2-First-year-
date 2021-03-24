import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Process_Model {
	public static int setRandomStat() {
		Random rand = new Random();
		int upperbound = 99;
		int randomstat = rand.nextInt(upperbound);
		int stat  = randomstat + 1;
		return stat;
	}
	public static int increaseHealth(Animal p) {
		int newHealth = p.getHealth() + 5;
		p.setHealth(newHealth);
		return newHealth;
	}
	public static int increaseFood(Animal p) {
		int newFood = p.getFood() + 20;
		p.setFood(newFood);
		return newFood;
	}
	public static int increaseStamina(Animal p) {
		int newStamina = p.getStamina() + 5;
		p.setStamina(newStamina);
		return newStamina;
	}
	public static int increaseMood(Animal p) {
		int newMood = p.getMood() + 5;
		p.setMood(newMood);
		return newMood;
	}
	private static void drainFood(Animal p) {
		int drainFood = p.getFood() - 1;
		p.setFood(drainFood);
	}
	private static void drainHealth(Animal p) {
		int drainHealth = p.getHealth() - 1;
		p.setHealth(drainHealth);
	}
	public static void foodDraining(Animal p) {
		Timer t = new Timer();
		t.purge();
		TimerTask tt = new TimerTask() {
		    public void run() {
		    	if(p.getFood() <= 0) {
		    		
		    		System.out.println("ALERT 0 food");
		    		p.setFood(0);
		    		healthDraining(p);
		    		
		    		t.cancel();
		    		
		    	}
		    		drainFood(p);	
		    	}
		        
		 	};t.schedule(tt, 0, 500);
	}
	public static void healthDraining(Animal p) {
		Timer ti = new Timer();
		ti.purge();
	    TimerTask dh = new TimerTask() {
	    	public void run() {
	    		if((p.getHealth() -1) <= 0) {
	    			System.out.println("ur pet died lel");
	    			ti.cancel();
	    		}else if(p.getFood() >= 0) {
	    			foodDraining(p);
	    			ti.cancel();
	    		}
	    		
	    		drainHealth(p);
	    		
	    	}
	    };ti.schedule(dh, 0, 500);
		
	}

}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

	/** 
	 * @author Lahiru
	 * @author Harrison Bell (Commenting/layout)
	 * 
	 * Process_model (Class) provides utility for the UI (process_View) Class.
	 * 
	 * */

public class Process_Model {
	public static int setRandomStat() {

		Random rand = new Random();
		int upperbound = 99;
		int randomstat = rand.nextInt(upperbound);
		int stat  = randomstat + 1;
		return stat;
	}
	
	
	/** stat changes */
	
	
	public static int increaseHealth(Animal p) { //increases pets health by 5
		
		int newHealth = p.getHealth() + 5;
		p.setHealth(newHealth);
		return newHealth;
	}
	 
	public static int increaseFood(Animal p) { //increases amount of food available by 20
		
		int newFood = p.getFood() + 20;
		p.setFood(newFood);
		return newFood;
	}
	
	public static int increaseStamina(Animal p) { // increases stamina after sleeping by 5
		
		
		
		int newStamina = p.getStamina() + 5;
		p.setStamina(newStamina);
		return newStamina;
	}
	
	public static int increaseMood(Animal p) { //increases mood by 5
		
		
		
		int newMood = p.getMood() + 5;
		p.setMood(newMood);
		return newMood;
	}
	
	private static void drainFood(Animal p) { //decreases food by 1
		
		
		
		int drainFood = p.getFood() - 1;
		p.setFood(drainFood);
	}
	
	private static void drainHealth(Animal p) {// decreases health by 1
		
		int drainHealth = p.getHealth() - 1;
		p.setHealth(drainHealth);
	}

	private static void drainMood(Animal p) { // decreases mood by 1
		
		int drainMood = p.getMood() - 1;
		p.setMood(drainMood);
	}
   
	/** repeat on timer (regular/ threaded) stat changes */
	
	public static void foodDraining(Animal p) {// does the same as HealthDraining() but dosent handle death| TODO: can this be removed (Harrison)
		
		//gradually decreases food if the animal has no food health is decreased instead
		
		Timer t = new Timer();
		t.purge();
		TimerTask tt = new TimerTask() {
		    public void run() {
		    	
		    	if(p.getFood() >= 1) {
		    		drainFood(p);
		    	}else {
		    		healthDraining(p);
		    		t.cancel();
		    	}	
		    	
		    	
		    	Process_View.btnSleep.addActionListener(new ActionListener() {         // "sleep" button cancels the process/"thread"
		    		public void actionPerformed(ActionEvent e) {		
	    				t.cancel();
	    			}
	    		});
		    }   
		 };t.schedule(tt, 0, 500);
	}
	
	public static void healthDraining(Animal p) { // drains health ( if food is not availiable) every 500ms 
		Timer ti = new Timer();
		ti.purge();
	    TimerTask dh = new TimerTask() {
	    	public void run() {			// runs this function in a seperate thread every 500 ms
	    		
	    				
	    		if((p.getHealth()) >= 1 && p.getFood() <= 0) {
	    			drainHealth(p);				
	    		}else if(p.getFood() >= 1) {
	    			foodDraining(p);			// drains food if food is availiable
	    			ti.cancel();
	    		}else {
	    			Process_View.lblImage.setIcon(new ImageIcon("Death.png"));		// this handles death ( no health left )
	    			Process_View.btnFeed.setEnabled(false);
	    			Process_View.btnPlay.setEnabled(false);
	    			Process_View.btnSleep.setEnabled(false);
	    			Process_View.btnRest.setEnabled(false);
	    			System.out.println("Your pet died lel");
	    			File deadSound = new  File("deadsound.wav");
	    			PlaySound(deadSound);
	    			ti.cancel();
	    		}
	    		Process_View.btnSleep.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {		// button cancels the health draining
	    				ti.cancel();
	    			}
	    		});
	    		
	    	}
	    };ti.schedule(dh, 0, 500);
		
	}

	public static void moodChange(Animal p) { // decreases mood every 500 ms
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
		    public void run() {
		    	if (p.getHealth() < 30 && p.getMood() > 0) {
		    		//sad state
					drainMood(p);
				}
		     }
		 	};t.schedule(tt, 0, 500);	
	}
	
	/** manages stats for the animal object  */
	
	public static String[] statsArray(String file) { // reads stats from file 
		try {
			String[] stats = new String[6];
			
			Scanner s = new Scanner(new File(file));
			for(int i = 0; i < 6; i++) {
				stats[i] = s.next();
			}
			return stats;
		}
		catch (FileNotFoundException e) {
		}
		return null;
	}
	
	public static void showStats(Animal p) { // grabs stats (Health, Food, Stamina, Food and FoodBucket) from the animal object and updates the current stat label in the UI
		if(p.getHealth() > 100) {
			p.setHealth(100);
			Process_View.healthLabel.setText("Heath = " + p.getHealth());
		}else {
			Process_View.healthLabel.setText("Heath = " + p.getHealth()); 
		} 
		if(p.getFood() > 100) {
			p.setFood(100);
			Process_View.foodLabel.setText("\nFood = " + p.getFood());;
		}else {
			Process_View.foodLabel.setText("\nFood = " + p.getFood());
		}
		if(p.getStamina() > 100) {
			p.setStamina(100);
			Process_View.staminaLabel.setText("\nStamina = " + p.getStamina());
		}else {
			Process_View.staminaLabel.setText("\nStamina = " + p.getStamina());
		}
		if(p.getMood() > 100) {
			p.setMood(100);
			Process_View.moodLabel.setText("\nMood = " + p.getMood());
		}else {
			Process_View.moodLabel.setText("\nMood = " + p.getMood());
		}
		if(p.getFoodBucket() > 100) {
			p.setFoodBucket(100);
			Process_View.lblFoodBucket.setText("\nFood bucket = " + p.getFoodBucket());
		}else {
			Process_View.lblFoodBucket.setText("\nFood bucket = " + p.getFoodBucket());
		}
		
				
	}
	
	public static void statsTimer(Animal p) {// calls showStats() above every 500 ms
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
		    public void run() {
		    	showStats(p);
		    	
		    	}
		 	};t.schedule(tt, 0, 500);
		
	}
	
	/** wrapped utility functions */
	
	private static void PlaySound(File sound) { // wrapped function for playing sound files
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e) {
		
		}
	}
	
	public static void showVisuals(Animal p) { // updates the image in the UI for the animal every 5000ms (checking for mood states)
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
		    public void run() {
		    	boolean deadState = false;
		    	if(p.getHealth() == 0) {
		    		Process_View.lblImage.setIcon(new ImageIcon("Death.png"));
		    		deadState = true;
		    		t.cancel();
		    	}
		    	if((30 < p.getMood() && p.getMood() < 70) && deadState == false){
					//normal state
					Process_View.lblImage.setIcon(new ImageIcon("Normal.gif"));
				}else if((p.getMood() > 70) && deadState == false){
					//happy state
					Process_View.lblImage.setIcon(new ImageIcon("Happy.gif"));
				}else if ((p.getMood() < 30) && deadState == false) {
					Process_View.lblImage.setIcon(new ImageIcon("Sad.gif"));
				}
		    	
		    	}
		 	};t.schedule(tt, 0, 5000);
		
	}
	
	public static void showAlerts(Animal p) { // dunno (Harrison)
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
		    public void run() {
		    	if (p.getFood() < 30) {
		    		new java.util.Timer().schedule( 
					        new java.util.TimerTask() {
					            @Override
					            public void run() {
					            	if (p.getHealth() == 0 && p.getFood() == 0) {
							    		//sad state
										t.cancel();
					            	}else {
					            		Process_View.lblImage.setIcon(new ImageIcon("Hungry.gif"));
					            	}
					            }
					        }, 
					        1000 
					);
				}
		    	}
		 	};t.schedule(tt, 0, 10000);
	}
	
	public static void showSleeping() { // Udates the UI for the Sleep state
	
		// needs a timer added otherwise it sleeps forever
			Process_View.lblImage.setIcon(new ImageIcon("Sleeping.gif"));
			Process_View.btnFeed.setEnabled(false);
			Process_View.btnPlay.setEnabled(false);
			Process_View.btnSleep.setEnabled(false);
			Process_View.btnRest.setEnabled(false);		
	}
	
	public static boolean checkName(String name) { // animal name input string validation
		boolean state = true;
		if (name.length() == 0) {
			JOptionPane.showMessageDialog(null, "Please enter a name.");
			
			state = false;
		}else if(name.length() > 0){
			String illegals = "";
			char[] chSearch = {'<','>', ':', '"', '/', '\\','|','?','*'};     // would be more time and space efficient using Regular Expressions (Harrison)
			char[] chName = name.toCharArray();
			for (int i = 0; i < chName.length; i++) {							// searching the string for ilegal chars
				for (int j = 0; j< chSearch.length; j++) {
					if(chName[i] == chSearch[j]) {
						illegals += chName[i];
					}
				}
			}
			if (illegals != "") {												// invalid string handling
				JOptionPane.showMessageDialog(null, "Illegal characters found. Do not use these: '" + illegals + "' characters for your pet name.");
				state = false;
			}
			else {
				state = true;
			}
		}
		return state;
	}
}
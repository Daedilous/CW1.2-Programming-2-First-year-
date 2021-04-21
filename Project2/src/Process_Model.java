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


public class Process_Model {
	public static int setRandomStat() {

		Random rand = new Random();
		int upperbound = 99;
		int randomstat = rand.nextInt(upperbound);
		int stat  = randomstat + 1;
		return stat;
	}
	
	//increases pets health
	public static int increaseHealth(Animal p) { 

		int newHealth = p.getHealth() + 5;
		p.setHealth(newHealth);
		return newHealth;
	}
	//increases amount of food available 
	public static int increaseFood(Animal p) {
		int newFood = p.getFood() + 20;
		p.setFood(newFood);
		return newFood;
	}
	// increases stamina after sleeping
	public static int increaseStamina(Animal p) {
		int newStamina = p.getStamina() + 5;
		p.setStamina(newStamina);
		return newStamina;
	}
	//increases mood/boredom
	public static int increaseMood(Animal p) {
		int newMood = p.getMood() + 5;
		p.setMood(newMood);
		return newMood;
	}
	//decreases food after eating
	private static void drainFood(Animal p) {
		int drainFood = p.getFood() - 1;
		p.setFood(drainFood);
	}
	// decreases health after not looking after
	private static void drainHealth(Animal p) {
		int drainHealth = p.getHealth() - 1;
		p.setHealth(drainHealth);
	}
	//decreases mood (Gradually)
	private static void drainMood(Animal p) {
		int drainMood = p.getMood() - 1;
		p.setMood(drainMood);
	}
   	// not sure
	public static void foodDraining(Animal p) {
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
		    	Process_View.btnSleep.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {		
	    				t.cancel();
	    			}
	    		});
		    }   
		 };t.schedule(tt, 0, 500);
	}
	// not sure
	public static void healthDraining(Animal p) {
		Timer ti = new Timer();
		ti.purge();
	    TimerTask dh = new TimerTask() {
	    	public void run() {
	    		if((p.getHealth()) >= 1 && p.getFood() <= 0) {
	    			drainHealth(p);
	    		}else if(p.getFood() >= 1) {
	    			foodDraining(p);
	    			ti.cancel();
	    		}else {
	    			Process_View.lblImage.setIcon(new ImageIcon("Death.png"));
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
	    			public void actionPerformed(ActionEvent e) {		
	    				ti.cancel();
	    			}
	    		});
	    		
	    	}
	    };ti.schedule(dh, 0, 500);
		
	}
	// not sure
	public static void moodChange(Animal p) {
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
	public static String[] statsArray(String file) {
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
	// creates labels so the user is aware. these are retrieved from class animal
	public static void showStats(Animal p) {
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
	
	public static void statsTimer(Animal p) {
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
		    public void run() {
		    	showStats(p);
		    	
		    	}
		 	};t.schedule(tt, 0, 500);
		
	}
	private static void PlaySound(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e) {
		
		}
	}
	public static void showVisuals(Animal p) {
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
	public static void showAlerts(Animal p) {
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
	public static void showSleeping() {
	
			Process_View.lblImage.setIcon(new ImageIcon("Sleeping.gif"));
			Process_View.btnFeed.setEnabled(false);
			Process_View.btnPlay.setEnabled(false);
			Process_View.btnSleep.setEnabled(false);
			Process_View.btnRest.setEnabled(false);		
	}
	
	public static boolean checkName(String name) {
		boolean state = true;
		if (name.length() == 0) {
			JOptionPane.showMessageDialog(null, "Please enter a name.");
			
			state = false;
		}else if(name.length() > 0){
			String illegals = "";
			char[] chSearch = {'<','>', ':', '"', '/', '\\','|','?','*'};
			char[] chName = name.toCharArray();
			for (int i = 0; i < chName.length; i++) {
				for (int j = 0; j< chSearch.length; j++) {
					if(chName[i] == chSearch[j]) {
						illegals += chName[i];
					}
				}
			}
			if (illegals != "") {
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
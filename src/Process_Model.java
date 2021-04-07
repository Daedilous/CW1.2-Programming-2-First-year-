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
import javax.swing.JOptionPane;


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
		    
		        
		 };t.schedule(tt, 0, 2000);
	}
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
	    };ti.schedule(dh, 0, 2000);
		
	}
	public static String[] statsArray(String file) {
		try {
			String[] stats = new String[5];
			
			Scanner s = new Scanner(new File(file));
			for(int i = 0; i < 5; i++) {
				stats[i] = s.next();
			}
			return stats;
		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Please ensure you have typed the correct pet name");
		}
		return null;
	}
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
		Process_View.staminaLabel.setText("\nStamina = " + p.getStamina());
		Process_View.moodLabel.setText("\nMood = " + p.getMood());
				
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
	

}

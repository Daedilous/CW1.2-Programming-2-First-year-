
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;


public class Process_Controller {
	private Process_View theView;
	private Process_Model theModel;

	public Process_Controller(Process_View theView, Process_Model theModel) {
		this.theView = theView;
		this.theModel = theModel;
		this.theView.initialStats(new initialStatsListener());
		this.theView.addFoodListener(new addFoodListener());
	}
	
	int randomHealth = Process_Model.setRandomStat();
	int randomFood = Process_Model.setRandomStat();
	int randomStamina = Process_Model.setRandomStat();
	int randomMood = Process_Model.setRandomStat();
		
	Animal p = new Animal(randomFood, randomHealth, randomStamina, randomMood);
	

	class initialStatsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = "";
			name = theView.getName();
			theView.setPetName(name);
			
			Process_Model.foodDraining(p);	
			
			Timer t = new Timer();
			TimerTask tt = new TimerTask() {
			    public void run() {
			    	theView.showStats(p);
			    	}
			 	};t.schedule(tt, 0, 500);
			
				
			System.out.println( "Heath = " + p.getHealth());
			System.out.println("Food = " + p.getFood());
			System.out.println("Stamina = " + p.getStamina());
			System.out.println("Mood = " + p.getMood());
			}
		
	}
	class addFoodListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Process_Model.increaseFood(p);
			Process_Model.increaseHealth(p);
		}
	}
}

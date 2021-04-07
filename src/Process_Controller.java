
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		this.theView.addSleepListener(new addSleepListener());
		this.theView.addExistingPetListener(new addExistingPetListener());
	}
	
	Animal p = new Animal("", 0, 0, 0, 0);
	
	class initialStatsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = "";
			name = theView.getName();
			p.setName(name);
			p.setHealth(Process_Model.setRandomStat());
			p.setFood(Process_Model.setRandomStat());
			p.setStamina(Process_Model.setRandomStat());
			p.setMood(Process_Model.setRandomStat());
			File file = new File(name+".txt");
			theView.setPetName(name);
			Process_Model.foodDraining(p);
			Process_Model.statsTimer(p);
			
			
			System.out.println("Pet name = " + p.getName());
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
	class addSleepListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			File file = new File(p.getName() + ".txt");
			try {
				FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(p.getName());
				pw.println(p.getHealth());
				pw.println(p.getFood());
				pw.println(p.getStamina());
				pw.println(p.getMood());
				pw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	class addExistingPetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = theView.getExistingPetName();
			String[] stats = Process_Model.statsArray(name + ".txt");
			p.setName(stats[0]);
			theView.setExistingPetName(stats[0]);
			p.setHealth(Integer.parseInt(stats[1]));
			p.setFood(Integer.parseInt(stats[2]));
			p.setStamina(Integer.parseInt(stats[3]));
			p.setMood(Integer.parseInt(stats[4]));
			
			Process_Model.foodDraining(p);	
			Process_Model.statsTimer(p);
			
			
		}
		
	}
	
	
}

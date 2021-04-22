/** 
	 * @author Lahiru Rajamanthri
	 * @author Harrison Bell
	 * @author Jade Sumner
	 * @author Luke Reading
	 * Process_Controller (Class) calls methods and initiates the game 
	 * by allowing Process_View/Process_Model/Animal  to communicate with each other.
	 * 
	 *
	 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Process_Controller {
	private Process_View theView;
	private Process_Model theModel;

	public Process_Controller(Process_View theView, Process_Model theModel) {
		/**
		 * Constructor to inherit methods from Process_View and Process_Model
		 */
		this.theView = theView;
		this.theModel = theModel;
		this.theView.initialStats(new initialStatsListener());
		this.theView.addFoodListener(new addFoodListener());
		this.theView.addSleepListener(new addSleepListener());
		this.theView.addExistingPetListener(new addExistingPetListener());
		this.theView.addRestListener(new addRestListener());
	}

	Animal p = new Animal("", 0, 0, 0, 0, 0);

	class initialStatsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = "";
			if (Process_Model.checkName(theView.getName()) == true) {
				name = theView.getName();
				if (new File(name+".txt").exists() == true) {
					JOptionPane.showMessageDialog(null, "Pet aalready exist, please enter a new pet name.");;
				}else {
					p.setName(name);
					p.setHealth(Process_Model.setRandomStat());
					p.setFood(Process_Model.setRandomStat());
					p.setStamina(Process_Model.setRandomStat());
					p.setMood(Process_Model.setRandomStat());
					p.setFoodBucket(0);
					System.out.print(p.getFoodBucket());
					theView.setPetName(name);
					Process_Model.foodDraining(p);
					Process_Model.statsTimer(p);
					Process_Model.showVisuals(p);
					Process_Model.showAlerts(p);
					Process_Model.moodChange(p);
					theView.switchPanels(theView.GamePnl);
				}
			}
		}

	}

	class addFoodListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (p.getFoodBucket() != 0) {
				p.setFoodBucket(p.getFoodBucket() - 1);
				Process_Model.increaseFood(p);
				Process_Model.increaseHealth(p);
				Process_View.lblImage.setIcon(new ImageIcon("Eating.gif"));
			}else {
				JOptionPane.showMessageDialog(null, "Your food bucket is empty, play with the pet to earn food");
			}
		}
	}
	
	class addRestListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Process_Model.showSleeping();
		}
		
	}

	class addSleepListener implements ActionListener {
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
				pw.println(p.getFoodBucket());
				pw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	class addExistingPetListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = theView.getExistingPetName();
			if (new File(name+".txt").exists() == true) {
				String[] stats = Process_Model.statsArray(name + ".txt");
				p.setName(stats[0]);
				theView.setPetName(stats[0]);
				p.setHealth(Integer.parseInt(stats[1]));
				p.setFood(Integer.parseInt(stats[2]));
				p.setStamina(Integer.parseInt(stats[3]));
				p.setMood(Integer.parseInt(stats[4]));
				p.setFoodBucket(Integer.parseInt(stats[5]));

				Process_Model.foodDraining(p);
				Process_Model.statsTimer(p);
				Process_Model.showVisuals(p);
				Process_Model.showAlerts(p);
				Process_Model.moodChange(p);
				theView.switchPanels(theView.GamePnl);
			} else {
				JOptionPane.showMessageDialog(null, "Pet not found, please enter a valid pet name.");
			}

		}
	}
}

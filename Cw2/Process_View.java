import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.print.DocFlavor.URL;
import javax.swing.*;

public class Process_View extends JFrame {
	private JLayeredPane layeredPane;
	public JPanel startPnl, newPetpnl, GamePnl, returnPnl;
	private JLabel namelabel = new JLabel("Enter pet name: ");
	private JTextField name = new JTextField(10);
	private JButton confirmName = new JButton("Confirm");
	private JTextField petName = new JTextField(10);
	private JTextField txtfieldExistingName = new JTextField(10);
	public static JLabel lblImage;
	static JLabel healthLabel, foodLabel, staminaLabel, moodLabel, lblFoodBucket;
	private JLabel lblEnterExistingPet, lblWelcome, lblPet_Name, lblStats;
	public static JButton btnFeed, btnPlay, btnRest, btnSleep;
	private JButton btnNewPet;
	private JButton btnWakeUp;
	private JButton btnExistingPet;
	        
	/**
	 * builds the GUI frames and panels
	 */
	
	
	Process_View(){
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(1, 1, 350, 400);
		
		//functions to create different object of panel.
		startpnl();
		newPetPnl();
		gamepnl();
		returnpnl();
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Good Question");
		this.setBounds(100, 100, 350, 400);
		this.setLayout(null);
		this.add(layeredPane);
		
		
	}
	private void startpnl() {
		//Panel 0 (Initial GUI menu)

				startPnl = new JPanel();
				startPnl.setBounds(10, 10, 350, 400);
				layeredPane.add(startPnl);
				startPnl.setLayout(null);
				
				
				lblWelcome = new JLabel("Welcome To Game Name");
				lblWelcome.setBounds(88, 60, 123, 21);
				startPnl.add(lblWelcome);
				
				btnNewPet = new JButton("Create new pet");
				btnNewPet.setBounds(88, 180, 130, 20);
				
				btnNewPet.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switchPanels(newPetpnl);
					}
				});
				startPnl.add(btnNewPet);
				
				btnWakeUp = new JButton("Wake up pet");
				btnWakeUp.setBounds(88, 210, 130, 20);
				btnWakeUp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switchPanels(returnPnl);
					}
				});
				startPnl.add(btnWakeUp);
	}
	
	private void newPetPnl() {
		//Panel for new pets (Entering new pet name)

				newPetpnl = new JPanel();
				newPetpnl.setBounds(10, 10, 350, 400);
				newPetpnl.setLayout(null);
				newPetpnl.setVisible(false);
				
				namelabel.setBounds(10, 14, 123, 21);
				newPetpnl.add(namelabel);
				
				name.setBounds(128, 12, 96, 19);
				newPetpnl.add(name);
				name.setColumns(10);
				
				confirmName.setBounds(234, 11, 85, 21);
				newPetpnl.add(confirmName);
				layeredPane.add(newPetpnl);
				
		
	}
	
	private void gamepnl() {
		//Panel (Displaying pet and its stats)
				GamePnl = new JPanel();
				GamePnl.setBounds(0, 0, 350, 400);
				GamePnl.setBackground(Color.white);
				layeredPane.add(GamePnl);
				GamePnl.setVisible(false);
				
				petName.setBounds(102, 29, 96, 19);
				petName.setColumns(10);
				GamePnl.add(petName);
				
				lblPet_Name = new JLabel("Pet Name:");
				lblPet_Name.setBounds(34, 26, 88, 25);
				GamePnl.add(lblPet_Name);
				
				GamePnl.setLayout(null);
				lblStats = new JLabel("           Stats:");
				lblStats.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblStats.setBounds(195, 68, 125, 25);
				GamePnl.add(lblStats);
				
				healthLabel = new JLabel("health");
				healthLabel.setBounds(213, 121, 88, 25);
				GamePnl.add(healthLabel);
				
				foodLabel = new JLabel("food");
				foodLabel.setBounds(213, 152, 88, 25);
				GamePnl.add(foodLabel);
				
				staminaLabel = new JLabel("Stamina");
				staminaLabel.setBounds(213, 186, 88, 25);
				GamePnl.add(staminaLabel);
				
				moodLabel = new JLabel("Mood");
				moodLabel.setBounds(213, 93, 88, 25);
				GamePnl.add(moodLabel);
				
				lblFoodBucket = new JLabel("Food bucket");
				lblFoodBucket.setBounds(112, 64, 110, 25);
				GamePnl.add(lblFoodBucket);
				
				lblImage = new JLabel("PET IMAGE");
				lblImage.setIcon(new ImageIcon("SleepingV4.gif"));
				lblImage.setBounds(102, 86, 110, 140);
				GamePnl.add(lblImage);
				
				
				btnFeed = new JButton("Feed");
				btnFeed.setBounds(7, 97, 85, 21);
				GamePnl.add(btnFeed);
				
				btnPlay = new JButton("Play");
				btnPlay.setBounds(7, 128, 85, 21);
				GamePnl.add(btnPlay);
				
				btnRest = new JButton("Rest");
				btnRest.setBounds(7, 159, 85, 21);
				GamePnl.add(btnRest);
				
				btnSleep = new JButton("Sleep");
				btnSleep.setBounds(7, 190, 85, 21);
				btnSleep.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switchPanels(startPnl);
						
						JOptionPane.showMessageDialog(null, "Your pet is in sleeping state" + "\nthe pet's current stats are saved");
					}
				});
				GamePnl.add(btnSleep);
				
				JButton btnActivityLogs = new JButton("Activity Logs");
				btnActivityLogs.setBounds(100, 230, 110, 21);
				GamePnl.add(btnActivityLogs);
		
	}
	
	private void returnpnl() {
		//Panel 3 (Entering existing pet name)
				returnPnl = new JPanel();
				returnPnl.setLayout(null);
				returnPnl.setBounds(20, 10, 323, 243);
				layeredPane.add(returnPnl);
				returnPnl.setVisible(false);
				
				btnExistingPet = new JButton("Confirm");
				btnExistingPet.setBounds(80, 210, 130, 20);
				returnPnl.add(btnExistingPet);
				
				
				txtfieldExistingName.setBounds(80, 180, 130, 20);
				returnPnl.add(txtfieldExistingName);
				
				lblEnterExistingPet = new JLabel("Enter existing pet name");
				lblEnterExistingPet.setBounds(88, 60, 123, 21);
				returnPnl.add(lblEnterExistingPet);
		
	}
	
	public String getName() {
		
		return name.getText();
	}
	
	public String getPetName() {
		return petName.getText();
	}
	
	public void setPetName(String name) {
		petName.setText(name);
	}
	
	public String getExistingPetName() {
		return txtfieldExistingName.getText();
	}
	
	public void setExistingPetName(String name) {
		petName.setText(name);
	}
	
	
	void initialStats(ActionListener listenForConfirmName) {
		confirmName.addActionListener(listenForConfirmName);
	}
	
	
	void addFoodListener(ActionListener listenForAddFood) {
		btnFeed.addActionListener(listenForAddFood);
	}
	
	void addSleepListener(ActionListener listenForSleep) {
		btnSleep.addActionListener(listenForSleep);
	}
	
	void addRestListener(ActionListener listenForRest) {
		btnRest.addActionListener(listenForRest);
	}
	
	void addExistingPetListener(ActionListener listenForExistingPet) {
		btnExistingPet.addActionListener(listenForExistingPet);
	}
	
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	//removes and adds a new panel
	
	public void switchPanels(JPanel panel)
	{  
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		panel.setVisible(true);
		
	}
}

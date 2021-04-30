import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Process_View extends JFrame {
	private JLayeredPane layeredPane;
	private JPanel panel0, panel1, panel2, panel3;
	private JLabel namelabel = new JLabel("Enter pet name: ");
	private JTextField name = new JTextField(10);
	private JButton confirmName = new JButton("Confirm");
	private JTextField petName = new JTextField(10);
	private JTextField txtfieldExistingName = new JTextField(10);
	private JLabel lblNewLabel_2;
	static JLabel healthLabel, foodLabel, staminaLabel, moodLabel;
	private JLabel lblEnterExistingPet, lblWelcome, lblPet_Name, lblStats;
	private JButton btnFeed, btnPlay, btnRest;
	static JButton btnSleep;
	private JButton btnNewPet;
	private JButton btnWakeUp;
	private JButton btnExistingPet;
	
	
	
	Process_View(){
		
		
		
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 10, 300, 240);
		
		//Panel 0 (Initial GUI menu)
		
		panel0 = new JPanel();
		panel0.setBounds(10, 10, 330, 233);
		layeredPane.add(panel0);
		panel0.setLayout(null);
		
		
		lblWelcome = new JLabel("Welcome To Game Name");
		lblWelcome.setBounds(88, 60, 123, 21);
		panel0.add(lblWelcome);
		
		btnNewPet = new JButton("Create new pet");
		btnNewPet.setBounds(88, 180, 130, 20);
		
		btnNewPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel1);
			}
		});
		panel0.add(btnNewPet);
		
		btnWakeUp = new JButton("Wake up pet");
		btnWakeUp.setBounds(88, 210, 130, 20);
		btnWakeUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel3);
			}
		});
		panel0.add(btnWakeUp);
		
		//Panel 1 (Entering new pet name)
		panel1 = new JPanel();
		panel1.setBounds(10, 10, 330, 233);
		panel1.setLayout(null);
		panel1.setVisible(false);
		
		namelabel.setBounds(10, 14, 123, 21);
		panel1.add(namelabel);
		
		name.setBounds(128, 12, 96, 19);
		panel1.add(name);
		name.setColumns(10);
		
		confirmName.setBounds(234, 11, 85, 21);
		confirmName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel2);
			}
		});
		panel1.add(confirmName);
		
		
		layeredPane.add(panel1);
		
		
		//Panel 2 (Displaying pet and its stats)
		panel2 = new JPanel();
		panel2.setBounds(10, 10, 330, 233);
		layeredPane.add(panel2);
		panel2.setVisible(false);
		
		petName.setBounds(102, 29, 96, 19);
		petName.setColumns(10);
		panel2.add(petName);
		
		lblPet_Name = new JLabel("Pet Name:");
		lblPet_Name.setBounds(34, 26, 88, 25);
		panel2.add(lblPet_Name);
		
		panel2.setLayout(null);
		lblStats = new JLabel("           Stats:");
		lblStats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStats.setBounds(195, 68, 125, 25);
		panel2.add(lblStats);
		
		healthLabel = new JLabel("health");
		healthLabel.setBounds(213, 121, 88, 25);
		panel2.add(healthLabel);
		
		foodLabel = new JLabel("food");
		foodLabel.setBounds(213, 152, 88, 25);
		panel2.add(foodLabel);
		
		staminaLabel = new JLabel("Stamina");
		staminaLabel.setBounds(213, 186, 88, 25);
		panel2.add(staminaLabel);
		
		moodLabel = new JLabel("Mood");
		moodLabel.setBounds(213, 93, 88, 25);
		panel2.add(moodLabel);
		
		lblNewLabel_2 = new JLabel("PET IMAGE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBackground(Color.RED);
		lblNewLabel_2.setBounds(102, 86, 110, 137);
		panel2.add(lblNewLabel_2);
		
		btnFeed = new JButton("Feed");
		btnFeed.setBounds(7, 97, 85, 21);
		panel2.add(btnFeed);
		
		btnPlay = new JButton("Play");
		btnPlay.setBounds(7, 128, 85, 21);
		panel2.add(btnPlay);
		
		btnRest = new JButton("Rest");
		btnRest.setBounds(7, 159, 85, 21);
		panel2.add(btnRest);
		
		btnSleep = new JButton("Sleep");
		btnSleep.setBounds(7, 190, 85, 21);
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel0);
				
				JOptionPane.showMessageDialog(null, "Your pet is in sleeping state" + "\nthe pet's current stats are saved");
			}
		});
		panel2.add(btnSleep);
		
		//Panel 3 (Entering existing pet name)
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(20, 10, 323, 243);
		layeredPane.add(panel3);
		panel3.setVisible(false);
		
		btnExistingPet = new JButton("Confirm");
		btnExistingPet.setBounds(80, 210, 130, 20);
		btnExistingPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel2);
			}
		});
		panel3.add(btnExistingPet);
		
		
		txtfieldExistingName.setBounds(80, 180, 130, 20);
		panel3.add(txtfieldExistingName);
		
		lblEnterExistingPet = new JLabel("Enter existing pet name");
		lblEnterExistingPet.setBounds(88, 60, 123, 21);
		panel3.add(lblEnterExistingPet);
		
		
		
		
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Good Question");
		this.setBounds(100, 100, 350, 400);
		this.setLayout(null);
		this.add(layeredPane);
		
		
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
	void addExistingPetListener(ActionListener listenForExistingPet) {
		btnExistingPet.addActionListener(listenForExistingPet);
	}
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	public void switchPanels(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		panel.setVisible(true);
	}
}

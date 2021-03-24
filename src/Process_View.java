import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Process_View extends JFrame {
	private JLayeredPane layeredPane;
	private JPanel panel1, panel2;
	private JLabel namelabel = new JLabel("Enter pet name: ");
	private JTextField name = new JTextField(10);
	private JLabel lblNewLabel_1;
	private JButton confirmName = new JButton("Confirm");
	private JTextField petName = new JTextField(10);
	private JLabel lblNewLabel_2, lblNewLabel_3, healthLabel, foodLabel, staminaLabel, moodLabel;
	private JButton btnNewButton_1, btnNewButton_2, btnNewButton_3, btnNewButton_4;
	
	
	
	Process_View(){
		
		petName.setOpaque(true);
		petName.setBounds(0, 10, 50, 50);
		petName.setLocation(30, 30);
		
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 10, 416, 243);
		
		panel1 = new JPanel();
		panel1.setBounds(10, 10, 330, 233);
		
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
		
		panel2 = new JPanel();
		panel2.setBounds(10, 10, 330, 233);
		layeredPane.add(panel2);
		
		petName.setBounds(102, 29, 96, 19);
		petName.setColumns(10);
		panel2.add(petName);
		
		lblNewLabel_1 = new JLabel("Pet Name:");
		lblNewLabel_1.setBounds(34, 26, 88, 25);
		panel2.add(lblNewLabel_1);
		
		panel2.setLayout(null);
		lblNewLabel_3 = new JLabel("           Stats:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(195, 68, 125, 25);
		panel2.add(lblNewLabel_3);
		
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
		
		btnNewButton_1 = new JButton("Feed");
		btnNewButton_1.setBounds(7, 97, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel2.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Play");
		btnNewButton_2.setBounds(7, 128, 85, 21);
		panel2.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Rest");
		btnNewButton_3.setBounds(7, 159, 85, 21);
		panel2.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Sleep");
		btnNewButton_4.setBounds(7, 190, 85, 21);
		panel2.add(btnNewButton_4);
		
		
		
		
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 286);
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
	public void showStats(Animal p) {
		if(p.getHealth() > 100) {
			p.setHealth(100);
			healthLabel.setText("Heath = " + p.getHealth());
		}else {
			healthLabel.setText("Heath = " + p.getHealth()); 
		} 
		if(p.getFood() > 100) {
			p.setFood(100);
			foodLabel.setText("\nFood = " + p.getFood());;
		}else {
			foodLabel.setText("\nFood = " + p.getFood());
		}
		staminaLabel.setText("\nStamina = " + p.getStamina());
		moodLabel.setText("\nMood = " + p.getMood());
				
	}
	
	void initialStats(ActionListener listenForConfirmName) {
		confirmName.addActionListener(listenForConfirmName);
	}
	
	void addFoodListener(ActionListener listenForAddFood) {
		btnNewButton_1.addActionListener(listenForAddFood);
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
	}
}

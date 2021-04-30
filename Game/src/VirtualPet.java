import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class VirtualPet {

	private JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	private JLayeredPane layeredPane;
	private JButton btnNewButton;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_3;
	private JTextField txtfieldExistingName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VirtualPet window = new VirtualPet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void switchPanels(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Create the application.
	 */
	public VirtualPet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 758, 607);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(20, 10, 416, 243);
		frame.getContentPane().add(layeredPane);
		
		JPanel panel0 = new JPanel();
		panel0.setBounds(0, 0, 323, 243);
		layeredPane.add(panel0);
		panel0.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(118, 122, 85, 21);
		panel0.add(btnStart);
		
		JLabel welcomelbl = new JLabel("Welcome To Game Name");
		welcomelbl.setBounds(103, 63, 123, 21);
		panel0.add(welcomelbl);
		
		panel2 = new JPanel();
		panel2.setBounds(20, 10, 330, 233);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 29, 96, 19);
		textField_1.setColumns(10);
		panel2.add(textField_1);
		
		lblNewLabel_1 = new JLabel("Pet Name:");
		lblNewLabel_1.setBounds(34, 26, 88, 25);
		panel2.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("PET IMAGE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBackground(Color.RED);
		lblNewLabel_2.setBounds(102, 86, 110, 137);
		panel2.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Feed");
		btnNewButton_1.setBounds(7, 97, 85, 21);
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
		
		lblNewLabel_3 = new JLabel("           Stats:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(195, 68, 125, 25);
		panel2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("           Stats");
		lblNewLabel_3_1.setBounds(213, 121, 88, 25);
		panel2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("           Stats");
		lblNewLabel_3_2.setBounds(213, 152, 88, 25);
		panel2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("           Stats");
		lblNewLabel_3_2_1.setBounds(213, 186, 88, 25);
		panel2.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("           Stats");
		lblNewLabel_3_2_2.setBounds(213, 93, 88, 25);
		panel2.add(lblNewLabel_3_2_2);
		
		panel1 = new JPanel();
		panel1.setBounds(20, 10, 323, 243);
		frame.getContentPane().add(panel1);
		
		btnNewButton = new JButton("Confirm");
		btnNewButton.setBounds(234, 11, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel2);
			}
		});
		panel1.setLayout(null);
		panel1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(128, 12, 96, 19);
		panel1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Pet name:");
		lblNewLabel.setBounds(10, 14, 123, 21);
		panel1.add(lblNewLabel);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(20, 10, 323, 243);
		frame.getContentPane().add(panel3);
		
		JButton btnExistingPet = new JButton("Confirm");
		btnExistingPet.setBounds(105, 140, 85, 21);
		panel3.add(btnExistingPet);
		
		txtfieldExistingName = new JTextField();
		txtfieldExistingName.setColumns(10);
		txtfieldExistingName.setBounds(108, 95, 96, 19);
		panel3.add(txtfieldExistingName);
		
		JLabel lblEnterExistingPet = new JLabel("Enter existing pet name");
		lblEnterExistingPet.setBounds(98, 64, 123, 21);
		panel3.add(lblEnterExistingPet);
	}
}

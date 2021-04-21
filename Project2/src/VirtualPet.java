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
import javax.swing.ImageIcon;

public class VirtualPet {

	private JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	private JLayeredPane layeredPane;
	private JButton confirmBtn;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel petNamelbl;
	private JLabel lblNewLabel_2;
	private JButton FeedBtn;
	private JButton Playbtn;
	private JButton Restbtn;
	private JButton Sleepbtn;
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
		
		panel1 = new JPanel();
		panel1.setBounds(20, 10, 323, 243);
		frame.getContentPane().add(panel1);
		
		confirmBtn = new JButton("Confirm");
		confirmBtn.setBounds(234, 11, 85, 21);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel2);
			}
		});
		panel1.setLayout(null);
		panel1.add(confirmBtn);
		
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
		
		panel2 = new JPanel();
		panel2.setBounds(34, 289, 323, 243);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 29, 96, 19);
		textField_1.setColumns(10);
		panel2.add(textField_1);
		
		petNamelbl = new JLabel("Pet Name:");
		petNamelbl.setBounds(34, 26, 88, 25);
		panel2.add(petNamelbl);
		
		lblNewLabel_2 = new JLabel("PET IMAGE");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\lahir\\eclipse-workspace\\Project2\\resized.gif")); // used locaolised files names
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBackground(Color.RED);
		lblNewLabel_2.setBounds(112, 92, 110, 137);
		panel2.add(lblNewLabel_2);
		// this might be removed^^^
		
		FeedBtn = new JButton("Feed");
		FeedBtn.setBounds(7, 97, 85, 21);
		panel2.add(FeedBtn);
		
		Playbtn = new JButton("Play");
		Playbtn.setBounds(7, 128, 85, 21);
		panel2.add(Playbtn);
		
		Restbtn = new JButton("Rest");
		Restbtn.setBounds(7, 159, 85, 21);
		panel2.add(Restbtn);
		
		Sleepbtn = new JButton("Sleep");
		Sleepbtn.setBounds(7, 190, 85, 21);
		panel2.add(Sleepbtn);
		
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
		
		JButton btnNewButton_4_1 = new JButton("Actibity Logs");
		btnNewButton_4_1.setBounds(112, 212, 110, 21);
		panel2.add(btnNewButton_4_1);
		
		JLabel lblNewLabel_3_3 = new JLabel("           Stats:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(193, 62, 125, 25);
		panel2.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_2_2_1 = new JLabel("         Food bucket");
		lblNewLabel_3_2_2_1.setBounds(112, 64, 88, 25);
		panel2.add(lblNewLabel_3_2_2_1);
	}
}

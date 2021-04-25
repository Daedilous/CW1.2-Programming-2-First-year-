

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;


public class Minigame_View extends JFrame{
	
	private   JLayeredPane layeredPane;
	
	private int Score, Lives;
	
	private JPanel startPnl;

	public static JPanel boardPnl;

	private JPanel endPnl;
	public static JLabel lblWelcome, lblLives, lblScore, lblFood, lblPlayer, lblSimon, imgPlayer, imgSimon;
	
	private JButton startbtn;

	public static JButton gamestbtn;

	private JButton upbtn;

	private JButton downbtn;

	private JButton leftbtn;

	private JButton rightbtn;
	
	public Minigame_View() {
		initUI();
	}
	
	private void initUI() {
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(1, 1, 350, 400);
		
		startpnl();
		Boardpnl();
		endpnl();
		
		
   
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("MiniGame");
		this.setBounds(100, 100, 350, 400);
		this.setLayout(null);
		this.add(layeredPane);
	}
	
	
	
	private void startpnl() {
		
		// first panel, explains game | start and return button
		
		startPnl = new JPanel();
		startPnl.setBounds(0, 0, 350, 400);
		layeredPane.add(startPnl);
		startPnl.setLayout(null);
		startPnl.setVisible(true);
		startPnl.grabFocus();
		
		
		lblWelcome = new JLabel("Welcome To The Minigame :) ");
		lblWelcome.setBounds(70, 60, 200, 21);
		startPnl.add(lblWelcome);
		
		startbtn = new JButton("Start Game!");
		startbtn.setBounds(88, 180, 130, 20);
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("start pressed view");
				
				switchPanels(boardPnl);
			}
		});
		startPnl.add(startbtn);
		
	}
	
	private void Boardpnl() {
		
		// main panel for the mini-game
		
		this.Lives = 3;
		this.Score = 0;
		
		boardPnl = new JPanel();
		boardPnl.setBounds(0, 0, 350, 400);
		boardPnl.setLayout(null);
		boardPnl.setBackground(Color.white);
		layeredPane.add(boardPnl);
		boardPnl.setVisible(false);
		
		lblLives = new JLabel("Lives: " + String.valueOf(this.Lives));
		lblLives.setBounds(10, 10, 123, 21);
		boardPnl.add(lblLives);
		
		lblScore = new JLabel("Score: " + String.valueOf(this.Score));
		lblScore.setBounds(250, 10, 123, 21);
		boardPnl.add(lblScore);
		
		lblSimon = new JLabel("Simon Says: ");
		lblSimon.setBounds(100, 40, 110, 140);
		boardPnl.add(lblSimon);
		
		imgSimon = new JLabel();
		imgSimon.setIcon(new ImageIcon("src/BLANK.png"));
		imgSimon.setBounds(100, 50, 110, 140);
		boardPnl.add(imgSimon);
		
		lblPlayer = new JLabel();
		lblPlayer.setBounds(100, 140, 110, 140);
		boardPnl.add(lblPlayer);
		
		imgPlayer = new JLabel("Player: ");
		imgPlayer.setIcon(new ImageIcon("src/BLANK.png"));
		imgPlayer.setBounds(100, 150, 110, 140);
		boardPnl.add(imgPlayer);
		
		
		
		
		
		gamestbtn = new JButton("start game");
		gamestbtn.setBounds(100, 50, 100, 20);
		boardPnl.add(gamestbtn);
		
		
		upbtn = new JButton("UP!");
		upbtn.setBounds(70, 300, 100, 20);
		
		upbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Minigame_View.imgPlayer.setIcon(new ImageIcon("src/up.png"));
			}
		});
		boardPnl.add(upbtn);
		
		
		
		downbtn = new JButton("DOWN!");
		downbtn.setBounds(180, 300, 100, 20);
		
		downbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Minigame_View.imgPlayer.setIcon(new ImageIcon("src/down.png"));
			}
		});
		boardPnl.add(downbtn);
		
		
		
		leftbtn = new JButton("LEFT!");
		leftbtn.setBounds(70, 330, 100, 20);
		
		leftbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Minigame_View.imgPlayer.setIcon(new ImageIcon("src/left.png"));
			}
		});
		boardPnl.add(leftbtn);
		
		
		
		rightbtn = new JButton("RIGHT!");
		rightbtn.setBounds(180, 330, 100, 20);
		
		rightbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Minigame_View.imgPlayer.setIcon(new ImageIcon("src/right.png"));
			}
		});
		boardPnl.add(rightbtn);
	}
	
	protected void DecreaseLives() {
		this.Lives--;
		
	}

	private void endpnl() {
		
		// last panel shows score and food rewarded
		
		endPnl = new JPanel();
		endPnl.setBounds(0, 0, 350, 400);
		endPnl.setLayout(null);
		layeredPane.add(endPnl);
		endPnl.setVisible(false);
		
		lblScore = new JLabel("Your final Score: " + String.valueOf(this.Score));
		lblScore.setBounds(10, 10, 123, 21);
		endPnl.add(lblScore);
		
		lblFood = new JLabel("Your final Score: " + String.valueOf(this.Score));
		lblFood.setBounds(10, 35, 123, 21);
		endPnl.add(lblFood);
		
	}
	
	void addStartListener(ActionListener listenForStart) {
		gamestbtn.addActionListener(listenForStart);
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

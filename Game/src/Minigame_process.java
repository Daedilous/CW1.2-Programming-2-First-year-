import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class Minigame_process extends Thread{
	
	public static String Target_state;
	public static String Player_state;
	public static Minigame_player player;



	public static Minigame_View theView;
	
	public Minigame_process(Minigame_View View) {
		
		this.theView = View;
		this.player = new Minigame_player(0,3);
		//View.addStartListener(new addStartListener());
		System.out.println("yo!");
		
	}
	public static String GetTarget()
	{
	return Target_state;	
	}
	public static String Getplayer()
	{
		return Player_state;
	}
	
	public static void setSimon() { // changes the image shown in the Board JPanel to the correct simon says.
		
		Minigame_process.Target_state = Minigame_process.getPath();
		System.out.println(Minigame_process.Target_state);
		Minigame_View.imgSimon.setIcon(new ImageIcon("src/" + Target_state));
		
	}

	public static void setPlayer(String Minigame_player) {
		Minigame_process.Player_state = Minigame_player;
		Minigame_View.imgPlayer.setIcon(new ImageIcon("src/" + Minigame_player));
	}
	
	public static String getPath() {  // returns random action path used to the simon says element 
	
		int a = 0;
		StringBuilder path = new StringBuilder();
		while(path.isEmpty() == false) {
			path.delete(0, 5);
		}
		Random random = new Random();
		a = random.nextInt(4);
		switch(a) {
			case 0: path.append("up");
			break;
			case 1: path.append("down");
			break;
			case 2: path.append("left");
			break;
			case 3: path.append("right");
			break;


		}
		path.append(".png");
		return path.toString();
	}


	

	class addStartListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Minigame_View.gamestbtn.setVisible(false);
			
			
			
			
		}
		
	}
	
}
	


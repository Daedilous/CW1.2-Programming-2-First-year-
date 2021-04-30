import javax.swing.JOptionPane;
import java.util.Timer;

public class game_logic implements Runnable {

	@Override
	public void run() {
			try {
				Minigame_process.setSimon();
				Thread.sleep(10000);	
			} catch (InterruptedException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			if(Minigame_process.Player_state==null)
			{Minigame_process.player.setLives(Minigame_process.player.getLives() - 1);
			Minigame_process.setPlayer("wrong.gif");}
			else if(Minigame_process.Player_state.equals(Minigame_process.Target_state)) {
				Minigame_process.player.setScore(Minigame_process.player.getScore() + 1);
				Minigame_process.setPlayer("correct.gif");
			}else {
				Minigame_process.player.setLives(Minigame_process.player.getLives() - 1);
				Minigame_process.setPlayer("wrong.gif");			

		}
			
		
	}
	
	

}

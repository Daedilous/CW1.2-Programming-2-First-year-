import javax.swing.JOptionPane;

public class game_logic implements Runnable {

	@Override
	public void run() {
		System.out.println("yo yo yo!");
		System.out.println(String.valueOf("lives: " + Minigame_process.player.getLives()));
		
		
		
		while(Minigame_process.player.getLives() > 0) {
	
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
				
			if(Minigame_process.Player_state == Minigame_process.Target_state) {
				Minigame_process.player.setScore(Minigame_process.player.getScore() + 1);
				Minigame_process.setPlayer("correct.gif");
			}else {
				Minigame_process.player.setLives(Minigame_process.player.getLives() - 1);
				Minigame_process.setPlayer("wrong.gif");
			}
		
		}
		
	}

}

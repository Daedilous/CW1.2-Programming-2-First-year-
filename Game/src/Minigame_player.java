
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Minigame_player {
	/**
	 * this class creates the player
	 * it has the attributes of the current score and lives
	 */
	private int Lives, Score;
	private String move;
	
	public Minigame_player(int Scores, int Lives) { // overloaded constructor to set instance variables at instantiation.
		this.Lives = Lives;
		this.Score = Scores;
	}
		
	public  int getLives() {return this.Lives;}
	public int getScore() {return this.Score;}
	public void setLives(int lives) {
		this.Lives = lives;
		Minigame_View.DecreaseLives(lives);
		if(this.Lives==0) {
			//switchPanels(endPnl);
			}
	
		} // need to update the label. 
	public void setScore(int score) {
		this.Score = score;
		Minigame_View.IncreaseScore(score);
		} // need to update the label.
}

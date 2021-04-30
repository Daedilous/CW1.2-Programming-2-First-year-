
public class Minigame_Run {

	public static void main(String[] args) {
		
		
		Minigame_View UI = new Minigame_View();
		Minigame_process Game = new Minigame_process(UI);
		Game.run();
		UI.setVisible(true);
		game_logic i = new game_logic();
		contgame(Game,UI,i);
		
	}
	public static void contgame(Minigame_process Game,Minigame_View UI,game_logic i) {
		
		
		i.run();	
		UI.simonpanel(Game.GetTarget());
		if(Minigame_process.player.getLives() != 0) {
			contgame(Game,UI,i);
		}
		else {
			int fnlscore =Minigame_process.player.getScore();
			UI.endGame(fnlscore);
			
		}
	}
	
		
	

}

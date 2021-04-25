
public class Minigame_Run {

	public static void main(String[] args) {
		
		
		Minigame_View UI = new Minigame_View();
		Minigame_process Game = new Minigame_process(UI);
		UI.setVisible(true);
	}

}

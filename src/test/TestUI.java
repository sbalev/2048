package test;

import game.Game;
import player.MonkeyPlayer;
import player.Player;
import player.PsychorigidPlayer;

public class TestUI {

	public static void main(String[] args) {
		Player p = new MonkeyPlayer();
		Game g = new Game(p);
		g.playWithUI();
		System.out.println("Final score : " + g.getScore());
	}

}

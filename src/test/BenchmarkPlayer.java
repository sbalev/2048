package test;

import game.Game;

import java.util.Random;

import player.Player;
import player.PsychorigidPlayer;

public class BenchmarkPlayer {
	public static final int GAME_COUNT = 1000000;
	public static void main(String[] args) {
		Random rnd = new Random(2048);
		int bestScore = -1;
		long sumScore = 0;
		for (int g = 1; g <= GAME_COUNT; g++) {
			Player player = new PsychorigidPlayer();
			Game game = new Game(player);
			game.setSeed(rnd.nextLong());
			game.play();
			int score = game.getScore();
			//System.out.printf("Game %4d Score %8d%n", g, score);
			sumScore += score;
			if (score > bestScore)
				bestScore = score;
		}
		System.out.printf("average %d best %d", sumScore / GAME_COUNT, bestScore);
	}
}

package game;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import player.Player;
import ui.GameFrame;

public class Game {
	protected Grid grid;
	protected Grid copy;
	protected Player player;
	protected Random rnd;
	protected GameFrame frame;

	public Game(Player player) {
		grid = new Grid();
		copy = new Grid();
		this.player = player;
		rnd = new Random();
	}

	public void setSeed(long seed) {
		rnd.setSeed(seed);
	}

	public void play() {
		addRandomTile();
		addRandomTile();
		while (!grid.gameOver()) {
			grid.getCopy(copy);
			Direction dir = player.selectDirection(copy);
			if (grid.move(dir))
				addRandomTile();
		}
	}
	
	public void playWithUI() {
		addRandomTile();
		addRandomTile();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				prepareFrame();
			}
		});
		while (!grid.gameOver()) {
			grid.getCopy(copy);
			Direction dir = player.selectDirection(copy);
			if (grid.move(dir)) {
				addRandomTile();
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						frame.update(grid);
					}
				});
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getScore() {
		return grid.getScore();
	}

	protected void addRandomTile() {
		grid.addValue(rnd.nextDouble() < 0.9 ? 2 : 4,
				rnd.nextInt(grid.getEmptyCount()));
	}
	
	protected void prepareFrame() {
		frame = new GameFrame(grid.getSize());
		frame.addComponents();
		frame.update(grid);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}

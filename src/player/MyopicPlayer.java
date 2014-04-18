package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.Direction;
import game.Grid;

public class MyopicPlayer implements Player {
	private Random rnd;
	private Grid copy;
	private List<Direction> candidates;
	
	public MyopicPlayer() {
		rnd = new Random();
		copy = new Grid();
		candidates = new ArrayList<Direction>();
	}

	public Direction selectDirection(Grid grid) {
		int bestScore = -1;
		for (Direction dir : Direction.values()) {
			grid.getCopy(copy);
			if (copy.move(dir)) {
				int score = copy.getScore();
				if (score > bestScore) {
					bestScore = score;
					candidates.clear();
				}
				if (score == bestScore)
					candidates.add(dir);
			}
		}
		return candidates.get(rnd.nextInt(candidates.size()));
	}

}

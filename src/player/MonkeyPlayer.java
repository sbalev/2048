package player;

import java.util.Random;

import game.Direction;
import game.Grid;

public class MonkeyPlayer implements Player {
	Random rnd;
	
	public MonkeyPlayer() {
		rnd = new Random();
	}

	public Direction selectDirection(Grid grid) {
		return Direction.values()[rnd.nextInt(Direction.values().length)];
	}

}

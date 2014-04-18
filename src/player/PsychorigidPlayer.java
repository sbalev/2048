package player;

import game.Direction;
import game.Grid;

public class PsychorigidPlayer implements Player {
	private static final Direction[] PREFERRED_ORDER = {Direction.LEFT, Direction.DOWN, Direction.UP, Direction.RIGHT};
	public Direction selectDirection(Grid grid) {
		for (Direction dir: PREFERRED_ORDER)
			if (grid.move(dir))
				return dir;
		return null;
	}
}

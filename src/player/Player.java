package player;

import game.Direction;
import game.Grid;

public interface Player {
	Direction selectDirection(Grid grid);
}

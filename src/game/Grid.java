package game;

public class Grid {
	private static final int SIZE = 4;

	private int[][] values;
	private boolean[][] merged;
	private int emptyCount;
	private int score;

	public Grid() {
		values = new int[SIZE][SIZE];
		merged = new boolean[SIZE][SIZE];
		emptyCount = SIZE * SIZE;
		score = 0;
	}

	public int getSize() {
		return SIZE;
	}

	public int getValue(int x, int y) {
		return values[y][x];
	}

	public int getEmptyCount() {
		return emptyCount;
	}

	public int getScore() {
		return score;
	}

	public boolean move(Direction dir) {
		for (int y = 0; y < SIZE; y++)
			for (int x = 0; x < SIZE; x++)
				merged[y][x] = false;
		boolean moved = false;
		switch (dir) {
		case UP:
			for (int x = 0; x < SIZE; x++)
				for (int y = 0; y < SIZE; y++)
					moved = moveValue(x, y, dir) || moved;
			break;
		case DOWN:
			for (int x = 0; x < SIZE; x++)
				for (int y = SIZE - 1; y >= 0; y--)
					moved = moveValue(x, y, dir) || moved;
			break;
		case LEFT:
			for (int y = 0; y < SIZE; y++)
				for (int x = 0; x < SIZE; x++)
					moved = moveValue(x, y, dir) || moved;
			break;
		case RIGHT:
			for (int y = 0; y < SIZE; y++)
				for (int x = SIZE - 1; x >= 0; x--)
					moved = moveValue(x, y, dir) || moved;
			break;
		}
		return moved;
	}

	private boolean moveValue(int x, int y, Direction dir) {
		if (values[y][x] == 0)
			return false;
		int nx = x + dir.getX();
		int ny = y + dir.getY();
		if (nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE)
			return false;
		if (values[ny][nx] == 0) {
			values[ny][nx] = values[y][x];
			values[y][x] = 0;
			moveValue(nx, ny, dir);
			return true;
		}
		if (values[y][x] == values[ny][nx] && !merged[ny][nx]) {
			values[ny][nx] *= 2;
			values[y][x] = 0;
			merged[ny][nx] = true;
			emptyCount++;
			score += values[ny][nx];
			return true;
		}
		return false;
	}

	public void addValue(int value, int position) {
		if (value != 2 && value != 4)
			throw new IllegalArgumentException("value must be 2 or 4");
		int i = 0;
		for (int y = 0; y < SIZE; y++)
			for (int x = 0; x < SIZE; x++)
				if (values[y][x] == 0) {
					if (i == position) {
						values[y][x] = value;
						emptyCount--;
						return;
					}
					i++;
				}
	}

	public boolean gameOver() {
		if (emptyCount > 0)
			return false;
		for (int y = 0; y < SIZE; y++)
			for (int x = 1; x < SIZE; x++)
				if (values[y][x] == values[y][x - 1])
					return false;
		for (int x = 0; x < SIZE; x++)
			for (int y = 1; y < SIZE; y++)
				if (values[y][x] == values[y - 1][x])
					return false;
		return true;
	}
	
	public void getCopy(Grid copy) {
		for (int y = 0; y < SIZE; y++)
			for (int x = 0; x < SIZE; x++)
				copy.values[y][x] = values[y][x];
		copy.emptyCount = emptyCount;
		copy.score = score;
	}

	@Override
	public String toString() {
		String s = "";
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++)
				s += String.format("%5d", values[y][x]);
			s += "\n";
		}
		return s;
	}
}

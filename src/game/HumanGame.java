package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

public class HumanGame extends Game {
	public HumanGame() {
		super(null);
	}

	@Override
	public void play() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void playWithUI() {
		addRandomTile();
		addRandomTile();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				prepareFrame();
				setKeyListener();
			}
		});

	}
	
	private void setKeyListener() {
		frame.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent e) {
		        int code = e.getKeyCode();
		        switch (code) {
		        case KeyEvent.VK_UP:
		        case KeyEvent.VK_KP_UP:
		        	move(Direction.UP);
		        	break;
		        case KeyEvent.VK_DOWN:
		        case KeyEvent.VK_KP_DOWN:
		        	move(Direction.DOWN);
		        	break;
		        case KeyEvent.VK_LEFT:
		        case KeyEvent.VK_KP_LEFT:
		        	move(Direction.LEFT);
		        	break;
		        case KeyEvent.VK_RIGHT:
		        case KeyEvent.VK_KP_RIGHT:
		        	move(Direction.RIGHT);
		        	break;
		        }
		    }
		});
	}
	
	private void move(Direction dir) {
		if (!grid.gameOver() && grid.move(dir)) {
			addRandomTile();
			frame.update(grid);
		}
	}
}
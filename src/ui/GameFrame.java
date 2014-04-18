package ui;

import game.Grid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private int size;
	private Cell[][] cells;
	private JLabel scoreLabel;

	public GameFrame(int size) {
		super("2048");
		this.size = size;
	}

	public void addComponents() {
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(size, size);
		layout.setHgap(10);
		layout.setVgap(10);
		panel.setLayout(layout);
		panel.setBackground(new Color(0xbb, 0xad, 0xa0));
		cells = new Cell[size][size];
		for (int y = 0; y < size; y++)
			for (int x = 0; x < size; x++) {
				cells[y][x] = new Cell();
				cells[y][x].setValue(0);
				panel.add(cells[y][x]);
			}
		scoreLabel = new JLabel("Score: 0");
		getContentPane().add(scoreLabel, BorderLayout.NORTH);
		getContentPane().add(new JSeparator(), BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
	}

	public void update(Grid grid) {
		for (int y = 0; y < size; y++)
			for (int x = 0; x < size; x++)
				cells[y][x].setValue(grid.getValue(x, y));
		scoreLabel.setText("Score: " + grid.getScore());
	}
}

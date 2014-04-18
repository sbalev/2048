package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Cell extends JLabel {
	private static final long serialVersionUID = 1L;
	private static final Dimension PREFERRED_SIZE = new Dimension(100, 100);
	private static final Color[] BG = {
		new Color(0xcc, 0xc0, 0xb3),
		null,
		new Color(0xee, 0xe4, 0xda),
		new Color(0xed, 0xe0, 0xc8),
		new Color(0xf2, 0xb1, 0x79),
		new Color(0xf5, 0x95, 0x63),
		new Color(0xf6, 0x7c, 0x5f),
		new Color(0xf6, 0x5e, 0x3b),
		new Color(0xed, 0xcf, 0x72),
		new Color(0xed, 0xcc, 0x61),
		new Color(0xed, 0xc8, 0x50),
		new Color(0xed, 0xc5, 0x3f),
		new Color(0xed, 0xc2, 0x2e),
		new Color(0x3c, 0x3a, 0x32),
	};
	private static final Color[] FG = {
		new Color(0xcc, 0xc0, 0xb3),
		null,
		new Color(0x77, 0x6e, 0x65),
		new Color(0x77, 0x6e, 0x65),
		new Color(0xf9, 0xf6, 0xf2),
	};
	
	public Cell() {
		super();
		setPreferredSize(PREFERRED_SIZE);
		setOpaque(true);
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font(getFont().getName(), Font.BOLD, 30));
	}
	
	public void setValue(int value) {
		setText("" + value);
		int i = 0;
		while (value > 0) {
			value >>= 1;
			i++;
		}
		setBackground(BG[Math.min(i, BG.length - 1)]);
		setForeground(FG[Math.min(i, FG.length - 1)]);
	}
}

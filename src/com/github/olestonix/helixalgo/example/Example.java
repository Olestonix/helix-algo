package com.github.olestonix.helixalgo.example;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.github.olestonix.helixalgo.Helix;
import com.github.olestonix.helixalgo.HelixDirection;

public final class Example {

	private static JFrame frame;
	private static Helix helix;
	private static final int LENGTH = 5, TIMES = 2022;
	private static final long FRECUENCY_IN_MILLIS = 15;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		frame = new JFrame("HelixAlgo Example");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize((int) getDimension().getWidth(), (int) getDimension().getHeight());
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		
		int
		startX = (int) getDimension().getWidth() / 2 - 1,
		startY = (int) getDimension().getHeight() / 2 - 1;
		
		Graphics graphics = panel.getGraphics();
		
		helix = new Helix(HelixDirection.CLOCKWISE, LENGTH, startX, startY) {
			
			@Override
			public void draw(int x, int y) {
				graphics.drawRect(x, y, helix.getLength(), helix.getLength());
			}
		};
		
		for (int t = 0; t <= TIMES; t++) {
			Thread.currentThread().sleep(FRECUENCY_IN_MILLIS);
			helix.add();
		}
	}
	
	private static Dimension getDimension() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		return dimension;
	}
}
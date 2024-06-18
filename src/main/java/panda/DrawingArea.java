package panda;

import panda.graphicstate.State;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.Serial;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	@Serial
	private static final long serialVersionUID = 1L;
	private final Scene scene;
	
	public DrawingArea() {
		super();
		Dimension screenSize = super.getToolkit().getScreenSize();
		scene = new Scene(screenSize);
	}

	public Scene getScene() {
		return scene;
	}
 
	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		super.setBackground(new Color(194, 218, 184));
		Drawing.set(pen);
		scene.draw();
	}
}
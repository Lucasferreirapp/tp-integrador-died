package Ventanas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class Grafico extends JComponent{

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g.create();
		dibujarElementos(g2d);
	}
	
	private void dibujarElementos(Graphics2D g2d) {
		Ellipse2D.Double elipse = new Ellipse2D.Double(100, 100, 100, 30);
		g2d.setColor(Color.BLUE);
		g2d.fill(elipse);
	}
	
}

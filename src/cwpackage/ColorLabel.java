package cwpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

public class ColorLabel extends JLabel {
	
	int borderWidth;
	Color color, borderCol;
	
	public ColorLabel (int width, int height, Color color, int borderWidth, Color borderCol)
	{
		this.borderWidth = borderWidth;
		this.color = color;
		this.borderCol = borderCol;
		
		setMinimumSize(new Dimension(width, height));
		setPreferredSize(new Dimension(width, height));
	}
	
	
	protected void paintComponent(Graphics g) {
		if (borderCol != null) {
			g.setColor(borderCol);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		if (color != null) {
			g.setColor(color);
			g.fillRect(borderWidth, borderWidth, getWidth() - borderWidth * 2, getHeight() - borderWidth * 2);
		}
		
	}
}

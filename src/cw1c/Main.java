package cw1c;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main implements ActionListener {
	
	JFrame guiFrame = new JFrame();
	ColorLabel[] arrayLabels = new ColorLabel[64];
	Random rand = new Random();
	int width, height;
	
	public Main(int width, int height) {
		
		this.width = width;
		this.height = height;
	}
	
	public void createGUI() {
		
		int i;
		JPanel colorPanel = new JPanel();
		JButton colorChangeButton = new JButton("Press me to change colours!");
		
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Label demo");
		colorPanel.setLayout(new GridLayout(width,height));
		colorChangeButton.addActionListener(this);
		
		for (i = 0; i < (width * height); i++) {
			float r = rand.nextFloat(), g = rand.nextFloat(), b = rand.nextFloat();
			arrayLabels[i] = new ColorLabel(40, 40, new Color(r, g, b));
			colorPanel.add(arrayLabels[i]);
		}
		
		
		guiFrame.getContentPane().setLayout(new BorderLayout());
		guiFrame.getContentPane().add(colorPanel, BorderLayout.NORTH);
		guiFrame.getContentPane().add(colorChangeButton, BorderLayout.SOUTH);
		guiFrame.pack();
		guiFrame.setVisible(true);
	}
	
	public static void main (String args[]) {
		Main mainObject = new Main(8,8);
		mainObject.createGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int i;
		
		for (i = 0; i < (width * height); i++) {
			float r = rand.nextFloat(), g = rand.nextFloat(), b = rand.nextFloat();
			arrayLabels[i].setDrawColor(new Color(r, g, b));
		}
		
		guiFrame.repaint();
		
	}

}

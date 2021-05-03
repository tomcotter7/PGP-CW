package cwpackage;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new GridLayout(2,2));
		
		ColorLabel label1 = new ColorLabel(30, 30, Color.blue, 2, Color.black);
		ColorLabel label2 = new ColorLabel(30, 30, Color.blue, 2, Color.black);
		ColorLabel label3 = new ColorLabel(20, 20, Color.pink, 2, Color.black);
		ColorLabel label4 = new ColorLabel(15, 15, Color.red, 25, Color.darkGray);
		frame.getContentPane().add(label1);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(label3);
		frame.getContentPane().add(label4);
		
		frame.setTitle("Hello World");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
} 

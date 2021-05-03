package cwpackage;

import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel {
	
	public MyLabel() {
		
		super("My label");
		setFont(new Font("Ariel", Font.BOLD, 30));
	}
	
	public MyLabel(String str) {
		
		super(str);
		setFont(new Font("Ariel", Font.BOLD, 30));
	}
}

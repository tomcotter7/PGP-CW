package cw2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class BoardSquareButton extends JButton {
	
	private static final long serialVersionUID = 6041062458744613191L;
	private int xCo, yCo;
	private Boolean mine, investigated, potential;
	
	public BoardSquareButton(int width, int height, int x, int y) {
		
		setPreferredSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
		setFont(new Font("Ariel", Font.BOLD, 30));
		setxCo(x);
		setyCo(y);
		initialise();
		
	}
	
	public void initialise() {
		setText("?");
		setBackground(Color.gray);
		setInvestigated(false);
		setMine(false);
		setPotential(false);
	}

	public void updatePotential() {
		
		if (getPotential()) {
			setColor(Color.gray);
			setPotential(false);
		} else {
			setColor(Color.red);
			setPotential(true);
		}
	}
	
	public Boolean getInvestigated() {
		return investigated;
	}

	public void setInvestigated(Boolean investigated) {
		this.investigated = investigated;
	}

	public Boolean getPotential() {
		return potential;
	}

	public void setPotential(Boolean potential) {
		this.potential = potential;
	}

	public Boolean getMine() {
		return mine;
	}

	public void setMine(Boolean mine) {
		this.mine = mine;
	}

	public int getxCo() {
		return xCo;
	}

	public void setxCo(int xCo) {
		this.xCo = xCo;
	}

	public int getyCo() {
		return yCo;
	}

	public void setyCo(int yCo) {
		this.yCo = yCo;
	}

	

	public void setColor(Color color) {
		setBackground(color);
	}

}

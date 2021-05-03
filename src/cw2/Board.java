package cw2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	
	private int width, height, numSquares;
	ArrayList<BoardSquareButton> squareButtons;
	Random rand = new Random();
	
	public Board(int width, int height) {
	
		setWidth(width);
		setHeight(height);
		setNumSquare(width * height);
		squareButtons = new ArrayList<BoardSquareButton>();
	}
	
	public BoardSquareButton getButton(int x, int y) {
		
		int i;
		
		for (i = 0; i < getNumSquare(); i++) {
			if (squareButtons.get(i).getxCo() == x && squareButtons.get(i).getyCo() == y) {
				return squareButtons.get(i);
			}
		}
		
		return null;
	}

	public void storeButton(int x, int y, BoardSquareButton button) {
		
		button.setxCo(x);
		button.setyCo(y);
		squareButtons.add(button);
		
	}
	
	public void initialiseAll() {
		
		int i;
		
		for (i = 0; i < getNumSquare(); i++) {
			squareButtons.get(i).initialise();
		}
	}
	
	public void createMines(int n) {
		
		int i;
		BoardSquareButton temp;
		
		for(i = 0; i < n; i++) {
			temp = getButton(rand.nextInt(getWidth()), rand.nextInt(getHeight()));
			if (temp.getMine() == false) {
				temp.setMine(true);
			} else {
				i--;
			}
		}
	}
	
	public void finished() {
		
		int i, surroundingMines;
		BoardSquareButton temp;
		
		for (i = 0; i < getNumSquare(); i++) {
			temp = squareButtons.get(i);
			temp.setColor(Color.green);
			if (temp.getMine()) {
				temp.setText("M");
				if (temp.getPotential() == false) {
					temp.setColor(Color.red);
				} else {
					temp.setColor(Color.orange);
				}
			} else {
				// set text to countSurrounding(x,y).
				surroundingMines = countSurrounding(temp.getxCo(), temp.getyCo());
				temp.setText(Integer.toString(surroundingMines));
			}
		}
	}
	
	public int countSurrounding(int x, int y) {
		
		int i, j, mines = 0;
		
		for (i = x - 1; i <= x + 1; i++) {
			for (j = y - 1; j <= y + 1; j++) {
				if (i >= 0 && j >= 0 && i <= getWidth()-1 && j <= getHeight()-1) {
					if(getButton(i, j).getMine()) {
						mines++;
					}
				}
			}
		}
		
		return mines;
	}
	
	public Boolean hasWon() {
		
		int i;
		Boolean won = true;
		BoardSquareButton temp;
		
		for (i = 0; i < getNumSquare(); i++) {
			temp = squareButtons.get(i);
			if (temp.getInvestigated() == false && temp.getMine() == false) {
				won = false;
			}
		}
		
		return won;
	}
	
	public void revealSquare(BoardSquareButton button) {
		
		int x = button.getxCo(), y = button.getyCo();
		int surroundingMines = countSurrounding(x,y);
		int i,j;
		BoardSquareButton temp;
		
		button.setColor(Color.green);
		button.setInvestigated(true);
		
		if (surroundingMines > 0) {
			button.setText(Integer.toString(surroundingMines));
		} else {
			button.setText("0");
			for (i = x - 1; i <= x + 1; i++) {
				for (j = y - 1; j <= y + 1; j++) {
					if (i >= 0 && j >= 0 && i <= getWidth()-1 && j <= getHeight()-1) {
						temp = getButton(i,j);
						if (temp.getInvestigated() == false && temp.getPotential() == false) {
							revealSquare(getButton(i, j));
						}
					}
				}
			}
		}
			
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getNumSquare() {
		return numSquares;
	}

	public void setNumSquare(int numSquares) {
		this.numSquares = numSquares;
	}
	

}

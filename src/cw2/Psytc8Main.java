package cw2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Psytc8Main extends MyMouseHandler {
	
	final static int WIDTH = 10, HEIGHT = 10, NUM_MINES = 50;
	static Psytc8Main mineSweeper;
	int num_mines;
	JFrame guiBoard = new JFrame();
	Board board;
	
	public Psytc8Main(int width, int height, int num_mines) {
		
		int i,j;
		this.num_mines = num_mines;
		board = new Board(width, height);
		BoardSquareButton temp;
		JPanel buttonPanel = new JPanel();
		
		guiBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiBoard.setTitle("MineSweeper");
		buttonPanel.setLayout(new GridLayout(width,height));
		
		for (i = 0; i < width; i++) {
			for (j = 0; j < height; j++) {
				temp = new BoardSquareButton(60,60,i,j);
				temp.addMouseListener(this);
				board.storeButton(i, j, temp);
				buttonPanel.add(temp,i,j);
			}
		}
		
		board.createMines(this.num_mines);
		
		guiBoard.getContentPane().setLayout(new FlowLayout());
		guiBoard.getContentPane().add(buttonPanel);
		guiBoard.pack();
		guiBoard.setVisible(true);
	}
	
	public static void main(String args[]) {
		
		mineSweeper = new Psytc8Main(WIDTH, HEIGHT, NUM_MINES);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		cw2.BoardSquareButton buttonClicked = (BoardSquareButton) e.getSource();
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (buttonClicked.getMine()) {
				board.finished();
				guiBoard.repaint();
				JOptionPane.showMessageDialog(guiBoard, "You lost!");
				board.initialiseAll();
				board.createMines(this.num_mines);
			} else {
				board.revealSquare(buttonClicked);
			}
		} else {
			buttonClicked.updatePotential();
		}
		
		guiBoard.repaint();
		
		if (board.hasWon()) {
			JOptionPane.showMessageDialog(guiBoard, "Congratulations, you won!");
			board.finished();
			guiBoard.repaint();
			board.initialiseAll();
			board.createMines(this.num_mines);
			guiBoard.repaint();
		}
		
		
	}
}

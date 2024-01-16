import edu.du.dudraw.DUDraw;

public class TicTacToe {

    //TODO: Declare the enumerated type called Contents here
		
	//TODO: Declare Cell inner class here

	// Array of Cells for the Tic Tac Toe Board 
	private Cell[][] board;

	// Message that changes based on turn and game end condition
	private String message;

	// Boolean to determine turns
	private boolean Xturn;

	public TicTacToe() {
		DUDraw.setCanvasSize(600, 700);
		DUDraw.setXscale(0, 3);
		DUDraw.setYscale(0, 3.5);

		//TODO: Initialize the board array

		this.message = "It's X's turn";
		this.Xturn = true;
	}

	public void draw() {
		DUDraw.clear(DUDraw.WHITE);
		DUDraw.setPenColor(DUDraw.BLACK);
		DUDraw.line(1, 0, 1, 3);
		DUDraw.line(2, 0, 2, 3);
		DUDraw.line(0, 1, 3, 1);
		DUDraw.line(0, 2, 3, 2);
		DUDraw.text(1.5, 3.25, this.message);

		//TODO: Draw the board

	}

	public void playGame() {
		DUDraw.enableDoubleBuffering();
		do {
			//TODO: Draw the board

			//TODO: Check mouse pressed event
			// If the mouse has been pressed, populate the corresponding
			// cell with the proper value.
			// Also, change this.message to state the correct turn
			// and toggle this.Xturn

			DUDraw.show();
			DUDraw.pause(100);

			// Check game end conditions
		} while (!gameWon() && !allFilled());
		if (gameWon()) {
			message = Xturn ? "Game over, O wins!" : "Game over, X wins!";
		} else {
			message = "Game over, it's a tie!";
		}
		draw();
		DUDraw.show();
	}

	// Check if someone has won the game
	public boolean gameWon() {
		// Returns true if a row, column or diagonal contains all O's or X's
		// Note: you may want to make use of the wins() method below.
		
		//TODO: check each row
		
		//TODO: check each column
		
		//TODO: check diagonals

		return false;

	}

	// Check if three squares are the same (and not empty) 
	private boolean wins(Contents c1, Contents c2, Contents c3) {
		if (c1 == Contents.EMPTY)
			return false;
		return c1 == c2 && c1 == c3;
	}

	private boolean allFilled() {

		//TODO: Method returns true if all cells are filled
		return true;
	}
	
}
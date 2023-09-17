import java.util.*;

class Main {
  // Runs the program
	public static void main(String[] args) {
		// Creates input console
		Scanner console = new Scanner(System.in);
		// Gets the players
		Player[] playerArray = getPlayers(console);
		// Sets up needed variables
		int active = 1;
		int x = -1;
		int y = -1; 
		boolean winner = false;
		Grid matrix = new Grid();
    // Draws the initial grid
    matrix.draw();
		// Runs the first 9 moves
		for (int index = 0; index < 9; index++) {
			// Gets active player and needed coordinates
			active = (index % 2) + 1;
			x = getXCoord(active, console);
			y = getYCoord(active, console);
			// Checks if move is valid and handles it
			if (matrix.isValidMove(x, y)) {
        matrix.addPlayerMove(x, y, playerArray[active - 1]);
				matrix.draw();
				// If there is a winner
				if (matrix.threeInARow()) {
					// Declares that there is a winner and breaks
					winner = true;
					break;
				}
			}
			// Asks for different move
			else {
				System.out.println("Invalid move. Enter another move.");
				// resets index
				index--;
			}
		}
    
		// Checks if there is a winner and handles the case
		checkWinner(winner, active, console, args, playerArray);
	}

	// Checks for winner
	// Asks to play again
	public static void checkWinner(boolean winner, int active, Scanner console, String[] args, Player[] playerArray ) {
		// Declare winner
		if (!winner) {
			System.out.println("No winner. Tie");
		} else {
			System.out.println(playerArray[active - 1].getName() + " wins");
		}

		// Handle the play agin once the game is over
		System.out.println("Play again?");
		String next = console.next();
		if (next.equalsIgnoreCase("yes") || next.equalsIgnoreCase("y")) {
			// Restart the program if they want to play again
			main(args);
		} else {
			// Otherwise exit the program
			System.exit(0);
		}
	}

	// Gets the X value of the coordinate that the player enters
	public static int getXCoord(int active, Scanner console) {
		System.out.println("Player " + active + ", put in your row: ");
		int x = -1;
		while (!console.hasNextInt()) {
		 	console.next();
      		System.out.print("Try again: ");
		} 
    	x = console.nextInt();
		return x;
	}

	// Similar to the getXCoord, this method gets the Y coordinte entered by the
	// player
	public static int getYCoord(int active, Scanner console) {
		System.out.println("Player " + active + ", put in your column: ");
		int y = -1;
		while (!console.hasNextInt()) {
			console.next();
      		System.out.print("Try again: ");
		}
    	y = console.nextInt();
		return y;
	}

	// This method creates the player array and the player objects
	// for main to use
	public static Player[] getPlayers(Scanner console) {
		// Gets the Player Name and letter the first player
		// wants to use
		System.out.println("Player 1 enter name: ");
		String name1 = console.next();
		System.out.println("Player 1 enter letter: ");
		// Makes it uppercase for the grid to use
		String letter1 = console.next().toUpperCase().substring(0, 1);

		// Gets the Player Name and letter the second player
		// wants to use
		System.out.println("Player 2 enter name: ");
		String name2 = console.next();
		System.out.println("Player 2 enter letter: ");
		// Makes it uppercase for the grid to use
		String letter2 = console.next().toUpperCase().substring(0, 1);

		// Creates the player objects, puts them in the array and
		// returns the array
		Player player1 = new Player(name1, letter1.charAt(0));
		Player player2 = new Player(name2, letter2.charAt(0));
		Player[] arr = { player1, player2 };

		return arr;
	}
}
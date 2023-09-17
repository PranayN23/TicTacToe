class Grid {

	private Space[][] matrix;

	// Construct a new Grid object (later to become matrix)
	public Grid() {
		matrix = new Space[3][3];
		// Populates array with spaces
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = new Space(new Player());
			}
		}
	}

	// Checks if the space the player chose is already occupied
	public boolean isValidMove(int row, int col) {
		if (row > 2 || col >  2 || row < 0 || col < 0) {
			System.out.println("Invalid input. Please re-enter a valid coordinate pair.");
			return false;
		}

		// If the name is null, that means the space
		// is blank and valid
		return (matrix[row][col].getName().equals("null name"));

	}

	// Check if either player won the game
	public boolean threeInARow() {
		// Check for horizontal 3 in a row
		for (int row = 0; row < 3; row++) {
			if (matrix[row][0].getLetter() != '_' && matrix[row][0].getLetter() == matrix[row][1].getLetter()) {
				if (matrix[row][1].getLetter() == matrix[row][2].getLetter()) {
					return true;
				}
			}
		}

		// Check for vertical 3 in a row
		for (int col = 0; col < 3; col++) {
			if (matrix[0][col].getLetter() != '_' && matrix[0][col].getLetter() == matrix[1][col].getLetter()) {
				if (matrix[1][col].getLetter() == matrix[2][col].getLetter()) {
					return true;
				}
			}
		}

		// Check for diagonal 3 in a row
		if (matrix[0][0].getLetter() != '_' && matrix[0][0].getLetter() == matrix[1][1].getLetter()) {
			if (matrix[1][1].getLetter() == matrix[2][2].getLetter()) {
				return true;
			}
		} else if (matrix[0][2].getLetter() != '_' && matrix[0][2].getLetter() == matrix[1][1].getLetter()) {
			if (matrix[1][1].getLetter() == matrix[2][0].getLetter()) {
				return true;
			}
		}

		return false;
	}

	// Replaces a blank space with the Space that the player chose
	// The player's letter of choice will be displayed rather than a space
	public void addPlayerMove(int x, int y, Player p) {
		Space s = new Space(p);
		matrix[x][y] = s;
	}

	// Displays the current matrix/board configuration
	public void draw() {
		// Header for the board
		System.out.println("__|__0__|__1__|__2__|");

		for (int row = 0; row < 3; row++) {
			// The beginning of each row has the row number and a vertical pipe
			System.out.print(row + " |");
			// For each column, print out the letter from the matrix
			for (int col = 0; col < 3; col++) {
				System.out.printf("__%c__|", matrix[row][col].getLetter());
			}
			System.out.println();
		}
	}
}
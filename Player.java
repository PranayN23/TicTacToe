class Player {
	private String name;
	private char letter;

	// Construct a new Player object with a name and either an X or an O (or custom
	// letter)
	public Player(String name, char letter) {
		if (name.length() == 0) {
			throw new IllegalArgumentException("Name cannot be blank!");
	}

		this.name = name;
		this.letter = letter;
	}

	// Constructs a new player with a blank name and letter
	public Player() {
		this("null name", '_');
	}

	// Gets the name of the player via scanner input
	public String getName() {
		return this.name;
	}

	// Gets the letter of choice from the player via input
	public char getLetter() {
		return this.letter;
	}
}
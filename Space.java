// The matrix is filled with an array of Spaces
// Space contains a Player which has a letter and a name
public class Space {
	 private Player player = new Player();

	// Construct a new Space that contains a player
	public Space(Player p) {
		this.player = p;
	}

	// Various methods to return aspects of the player that occupies this instance
	// of Space
	public char getLetter() {
		return player.getLetter();
	}

	// Gets the name of the players
	public String getName() {
		return player.getName();
	}

	// Gets the Player that is associated with this Space
	public Player getPlayer() {
		return player;
	}
}
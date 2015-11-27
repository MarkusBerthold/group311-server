
public class Turn {
	String[] players;

	// what variables define each player?
	// Include an object containing the info from each player that will be
	// manipulated in each turn

	public Turn(String[] _players) {
		this.players = _players;

		System.out.println("hey");

	}

	// the switch case model to run through each players turn. might replace the
	// integer with a string
	void doThis() {

		for (int i = 0; i < 2; i++){
			for(int j= 0; j<4; j++){

			switch (players[j]) {

			case "player 1":
				System.out.println("player 1");
				
				break;
			case "player 2":
				System.out.println("player 2");
				
				break;
			case "player 3":
				System.out.println("player 3");
				
				break;
			case "player 4":
				System.out.println("player 4");
				
				break;

			}
			}
		}
	}
}

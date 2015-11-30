import java.util.Scanner;

public class Turn {
	String[] players;
	int p1 = 5;
	int p2 = 5;
	int p3 = 5;
	int p4 = 5;
	
	static Scanner sc;
	int tmp;
	boolean canAct;

	public Turn(String[] _players, int tmp) {
		this.players = _players;
		this.tmp = tmp;
	}
	
	

	void initialTurn() {
		if (tmp < 4) {
			switch (tmp) {

			case 1:
				System.out.println("player 1");

				

				break;
			case 2:
				System.out.println("player 2");

				tmp = -1;
				this.initialTurn();
				
				break;
			case 3:
				System.out.println("player 3");

				tmp = -1;

				this.initialTurn();

				break;
			case 4:
				System.out.println("player 4");

				tmp = -1;

				this.initialTurn();

				break;

			}
		} else if (tmp >= 4) {
			this.normalTurn();
		}
	}

	// the switch case model to run through each players turn. might replace the
	// integer with a string
	void normalTurn() {

		while (p1 > 2 && p2 > 2 && p3 > 2 && p4 > 2) {

			for (int j = 0; j < 4; j++) {

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

		// last turn

		for (int j = 0; j < 4; j++) {

			switch (players[j]) {

			case "player 1":
				System.out.println("player 1 last turn");

				break;
			case "player 2":
				System.out.println("player 2 last turn");

				break;
			case "player 3":
				System.out.println("player 3 last turn");

				break;
			case "player 4":
				System.out.println("player 4 last turn");

				break;

			}

		}
	}

}

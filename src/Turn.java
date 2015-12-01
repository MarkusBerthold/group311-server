import java.util.Scanner;

public class Turn {
	String[] playerArray;
	int p1 = 5;
	int p2 = 5;
	int p3 = 5;
	int p4 = 5;
	
	static Scanner sc;
	int tmp;
	Players playerInput;
	

	public Turn(String[] _players, int tmp, Players playerInput) {
		this.playerArray = _players;
		this.tmp = tmp;
		this.playerInput= playerInput;
	}
	
	
//The initial turn function deals the mission cards to each player and 4 train cards
	// change constructor to take 4 players objects
	void initialTurn(Players p1, Players p2, Players p3, Players p4) {
		
		for(int i= 0; i<4; i++){
		
		
			switch (i) {

			case 0:
				System.out.println("player 1");
				//addTrainsToHand(p1)
				//addMissionsToHand(p1)
				
				break;
			case 1:
				System.out.println("player 2");
				//addTrainsToHand(p2)
				//addMissionsToHand(p2)

				break;
			case 2:
				System.out.println("player 3");
				//addTrainsToHand(p3)
				//addMissionsToHand(p3)

				break;
			case 3:
				System.out.println("player 4");
				//addTrainsToHand(p4)
				//addMissionsToHand(p4)
				
				
				break;

			}
		} 
	}

	// the switch case model to run through each players turn.
	//takes a players object as an input
	
	void normalTurn(Players p) {

		//checks if the players amount of trains are above 2
		// while (p1 > 2 && p2 > 2 && p3 > 2 && p4 > 2) {

				switch (tmp) {

				case 1:
					System.out.println("choose to draw cards");

					break;
				case 2:
					System.out.println("player 3");

					break;
				case 3:
					System.out.println("player 4");

					break;

				}

			
		//}

		// last turn

		for (int j = 0; j < 4; j++) {

			switch (playerArray[j]) {

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

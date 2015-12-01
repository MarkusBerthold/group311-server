
public class Turn {
	String[] playerArray;
	int p1 = 5;
	int p2 = 5;
	int p3 = 5;
	int p4 = 5;
	
	
	public Turn(String[] _players) {
		this.playerArray = _players;
		
		
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
	
	void normalTurn(Players p, int input) {

		//checks if the players amount of trains are above 2
		//if(p.amountOfTrains > 2){

				switch (input) {

				case 1:
					System.out.println("choose to draw cards");
					//draw 2 cards, either from open stack or the stack

					break;
				case 2:
					System.out.println("Choose to draw an extra mission");
					// 

					break;
				case 3:
					System.out.println("choose to play trains");

					break;

				}
		//}

			
		

		// last turn

		

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

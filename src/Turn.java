import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Turn {

	int finalTurnCounter;

	int currentPlayer = 0;

	PrintStream ps;
	InputStreamReader isr;
	BufferedReader inFromClient;

	// on the initial turn each player is dealt 4 train cards and 2 mission
	// cards

	void initialTurn() throws IOException {

		// to do this we run a for loop to go through a switch case to deal the
		// cards to each player
		for (int i = 0; i < 4; i++) {

			switch (i) {

			case 0:
				System.out.println("player 1");
				// update the stack sizes for player 1 to the board and send it

				// when the objects have been instantiated, the stack containing
				// the cards that goes
				// to the players hand must override the hand stack in the
				// Players class

				//pArray[0].getHandOfTrainCards();
				// pArray[0].setHandOfTrainCards(SomeTrainStack);

				//pArray[0].getHandOfMissions();
				// pArray[0].setHandOfMissions(SomeMissionStack);

				break;
			case 1:
				System.out.println("player 2");
				// update the stack sizes for player 2 to the board and send it

				//pArray[1].getHandOfTrainCards();
				// pArray[1].setHandOfTrainCards(SomeTrainStack);

				//pArray[1].getHandOfMissions();
				// pArray[1].setHandOfMissions(SomeMissionStack);

				break;
			case 2:
				System.out.println("player 3");
				// update the stack sizes for player 3 to the board and send it

				//pArray[2].getHandOfTrainCards();
				// pArray[2].setHandOfTrainCards(SomeTrainStack);

				//pArray[2].getHandOfMissions();
				// pArray[2].setHandOfMissions(SomeMissionStack);

				break;
			case 3:
				System.out.println("player 4");
				// update the stack sizes for player 4 to the board and send it

				//pArray[3].getHandOfTrainCards();
				// pArray[3].setHandOfTrainCards(SomeTrainStack);

				//pArray[3].getHandOfMissions();
				// pArray[3].setHandOfMissions(SomeMissionStack);

				//

				break;

			}
		}
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// the switch case model to run through each players turn.
	// takes a players object as an input

	void normalTurn(Players[] pArray, int whoseTurn) throws IOException {

		switch (whoseTurn) {

		// within the switch case are 4 cases that will initiate their own
		// switch cases
		// these determine what kind of action the player will perform and apply
		// the action to the selected player
		case 1:
			System.out.println("Player 1's turn");
			ps = new PrintStream(pArray[0].sock.getOutputStream(), true);
			ps.println("canAct");


			break;

		// same as above but for player 2

		case 2:
			System.out.println("Player 2's turn");
			ps = new PrintStream(pArray[1].sock.getOutputStream(), true);
			ps.println("canAct");

			break;

		// same for player 3

		case 3:
			System.out.println("Player 3's turn");
			ps = new PrintStream(pArray[2].sock.getOutputStream(), true);
			ps.println("canAct");

			break;

		// same for player 4
		case 4:
			System.out.println("Player 4's turn");
			ps = new PrintStream(pArray[3].sock.getOutputStream(), true);
			ps.println("canAct");

			break;
		}

		// last turn
		// the finalTurnCounter variable will update so that the final switch
		// case will start
		// with the player that plays AFTER a player has less than 2 trains left
		// after his turn
		// that is why there must be 8 cases. If player 4 is the first to go
		// below 2 trains
		// then he will have 1 last turn, which will be case 8 here

		switch (finalTurnCounter) {

		case 1:
			System.out.println("player 1 last turn");

			break;
		case 2:
			System.out.println("player 2 last turn");

			break;
		case 3:
			System.out.println("player 3 last turn");

			break;
		case 4:
			System.out.println("player 4 last turn");

			break;

		case 5:
			System.out.println("player 1 last turn");

			break;
		case 6:
			System.out.println("player 2 last turn");

			break;
		case 7:
			System.out.println("player 3 last turn");

			break;
		case 8:
			System.out.println("player 4 last turn");

			break;

		}

	}

	public int endTurn() {

		currentPlayer++;

		if (currentPlayer > 4) {
			currentPlayer = 1;
		}

		return currentPlayer;
	}

}
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Turn {

	int finalTurnCounter;

	String currentPlayer;
	Players[] pArray;

	public ArrayList<Socket> connectionArray;
	
InputStreamReader isr;
BufferedReader inFromClient;

	public Turn(ArrayList<Socket> connectionArray, Players[] playerArray) {

		this.connectionArray = connectionArray;
		this.pArray = playerArray;
	}

	//on the initial turn each player is dealt 4 train cards and 2 mission cards

	void initialTurn() {

		//to do this we run a for loop to go through a switch case to deal the cards to each player
		for (int i = 0; i < 4; i++) {

			switch (i) {

			case 0:
				System.out.println("player 1");
				// update the stack sizes for player 1 to the board and send it
				
				//when the objects have been instantiated, the stack containing the cards that goes
				//to the players hand must override the hand stack in the Players class
				
				pArray[0].getHandOfTrainCards();
				// to all clients

				break;
			case 1:
				System.out.println("player 2");
				// update the stack sizes for player 2 to the board and send it
				pArray[1].getHandOfTrainCards();
				// to all clients

				break;
			case 2:
				System.out.println("player 3");
				// update the stack sizes for player 3 to the board and send it
				pArray[2].getHandOfTrainCards();
				// to all clients

				break;
			case 3:
				System.out.println("player 4");
				// update the stack sizes for player 4 to the board and send it
				pArray[3].getHandOfTrainCards();
				// to all clients

				break;

			}
		}
	}

	// the switch case model to run through each players turn.
	// takes a players object as an input

	void normalTurn(Players p) throws IOException {
		
		int inputNum= 0;
		
		// get input from client to determine which player is going to act
		
		if(inFromClient.readLine().contains("Player1")){
			currentPlayer= "player1";
			
		} else if(inFromClient.readLine().contains("Player2")){
			currentPlayer= "player2";
			
		} else if(inFromClient.readLine().contains("Player3")){
			currentPlayer= "player3";
			
		}else if(inFromClient.readLine().contains("Player4")){
			currentPlayer= "player4";
		}
		
		// get input from client for what type of action he will be doing
		
		if(inFromClient.readLine().contains("1")){
			inputNum= 1;
			
		} else if(inFromClient.readLine().contains("2")){
			inputNum= 2;
			
		} else if(inFromClient.readLine().contains("3")){
			inputNum= 3;
			
		}else if(inFromClient.readLine().contains("4")){
			inputNum= 4;
		}
		
// this switch case keeps track of which player is going to act. it takes the string from the bufferedReader input
		switch (currentPlayer) {

		//within the switch case are 4 cases that will initiate their own switch cases 
		// these determine what kind of action the player will perform and apply the action to the selected player
		case "Player1":
			switch (inputNum) {

			//first action case: the player wants to draw some train cards
			case 1:
				System.out.println("choose to draw cards");
				int cardsDrawn = 0;
				// draw 2 cards, either from open stack or the stack
				// currentPlayer.addCardToHandStack()

				if (cardsDrawn == 2) {

					
				}
				break;
				
				//second action: the player wants to pick up mission cards
			case 2:
				System.out.println("Choose to draw an extra mission");
				//

				
				break;
				
				//third case: the player wants to play some trains and train cards
			case 3:
				System.out.println("choose to play trains");

				
				break;

			}
			break;
			
			//same as above but for player 2
			
		case "Player2":
			switch (inputNum) {

			case 1:
				System.out.println("choose to draw cards");
				int cardsDrawn = 0;
				// draw 2 cards, either from open stack or the stack
				// currentPlayer.addCardToHandStack()

				if (cardsDrawn == 2) {

					
				}
				break;
			case 2:
				System.out.println("Choose to draw an extra mission");
				//

				
				break;
			case 3:
				System.out.println("choose to play trains");

				
				break;

			}
			
			//same for player 3
			
		case "Player3":
			switch (inputNum) {

			case 1:
				System.out.println("choose to draw cards");
				int cardsDrawn = 0;
				// draw 2 cards, either from open stack or the stack
				// currentPlayer.addCardToHandStack()

				if (cardsDrawn == 2) {

					
				}
				break;
			case 2:
				System.out.println("Choose to draw an extra mission");
				//

			
				break;
			case 3:
				System.out.println("choose to play trains");

		
				break;

			}
			
			//same for player 4
		case "Player4":
			switch (inputNum) {

			case 1:
				System.out.println("choose to draw cards");
				int cardsDrawn = 0;
				// draw 2 cards, either from open stack or the stack
				// currentPlayer.addCardToHandStack()

				if (cardsDrawn == 2) {

					
				}
				break;
			case 2:
				System.out.println("Choose to draw an extra mission");
				//

				
				break;
			case 3:
				System.out.println("choose to play trains");

			
				break;

			}
		}

		// last turn

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

		}

	}

}

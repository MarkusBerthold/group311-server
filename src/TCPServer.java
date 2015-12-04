import java.io.BufferedReader;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import java.net.*;
import java.util.ArrayList;

import org.newdawn.slick.SlickException;

public class TCPServer implements Runnable {

	Socket csocket;
	int missionCardStackCounter= 22;
	int currentPlayer = 1;
	
	static String msg;
	static boolean hasBeenSent = false;
	

	TCPServer(Socket csocket) {
		this.csocket = csocket;
	}

	public static ServerSocket socket;
	public static ArrayList<Socket> connectionArray = new ArrayList<Socket>();
	public static boolean gameHasBeenInitiated = false;

	static Players[] pArray;
	static Board board;
	
	static int whoseTurnItIs;

	//static PrintStream ps;
	static BufferedReader inFromClient;
	static InputStreamReader isr;
	
	static int globalAmountOfTrainCards = 75;

	public static void main(String[] args) throws IOException, SlickException {

		board = new Board(4);

		socket = new ServerSocket(2222);

		while (true) {
			Socket sock = socket.accept();
			new Thread(new TCPServer(sock)).start();
		}
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());

		try {

			while (true) {

				System.out.println("Server is running and a new input arrived");

				if (!connectionArray.contains(csocket)) {
					connectionArray.add(csocket);
					System.out.println(connectionArray.size());
					System.out.println("Added a player: " + csocket);
					System.out.println("Client's InetAddress: " + csocket.getInetAddress());

				}
				if (connectionArray.size() == 4 && !gameHasBeenInitiated) {

					gameHasBeenInitiated = true;

					Players p1 = new Players(1, board.colors[1]);
					p1.setSock(connectionArray.get(0));

					Players p2 = new Players(2, board.colors[2]);
					p2.setSock(connectionArray.get(1));

					Players p3 = new Players(3, board.colors[3]);
					p3.setSock(connectionArray.get(2));

					Players p4 = new Players(4, board.colors[4]);
					p4.setSock(connectionArray.get(3));

				/*	pArray = new Players[4];
					pArray[0] = p1;
					pArray[1] = p2;
					pArray[2] = p3;
					pArray[3] = p4; */
					
					
					
					
					
					PrintStream ps1 = new PrintStream(connectionArray.get(0).getOutputStream(), true);
					ps1.println("1");
					for (int i =0; i<4; i++)
					{
						String temp = new Gson().toJson(board.player1TrainHandStack.get(i));
						ps1.println(temp);
					}
					for (int i = 0; i < 2; i++) {
						String temp = new Gson().toJson(new MissionCard(
								new Town(board.player1MissionHandStack.get(i).getTownA().getName(),
										board.player1MissionHandStack.get(i).getTownA().getAmountOfConnections(),
										board.player1MissionHandStack.get(i).getTownA().getxPos(),
										board.player1MissionHandStack.get(i).getTownA().getyPos()), 
								new Town(board.player1MissionHandStack.get(i).getTownB().getName(),
										board.player1MissionHandStack.get(i).getTownB().getAmountOfConnections(),
										board.player1MissionHandStack.get(i).getTownB().getxPos(),
										board.player1MissionHandStack.get(i).getTownB().getyPos()), 
										board.player1MissionHandStack.get(i).getPoints()));
								//System.out.println(board.player1MissionHandStack.size());
						ps1.println(temp);
					}
					String temp1 = new Gson().toJson(new Players(p1.playerNum, p1.getPlColor()));
					ps1.println(temp1);
					
					
					PrintStream ps2 = new PrintStream(connectionArray.get(1).getOutputStream(), true);
					ps2.println("2");
					for (int i =0; i<4; i++)
					{
						String temp = new Gson().toJson(board.player2TrainHandStack.get(i));
						ps2.println(temp);
					}
					for (int i = 0; i < 2; i++) {
						String temp = new Gson().toJson(new MissionCard(
								new Town(board.player2MissionHandStack.get(i).getTownA().getName(),
										board.player2MissionHandStack.get(i).getTownA().getAmountOfConnections(),
										board.player2MissionHandStack.get(i).getTownA().getxPos(),
										board.player2MissionHandStack.get(i).getTownA().getyPos()), 
								new Town(board.player2MissionHandStack.get(i).getTownB().getName(),
										board.player2MissionHandStack.get(i).getTownB().getAmountOfConnections(),
										board.player2MissionHandStack.get(i).getTownB().getxPos(),
										board.player2MissionHandStack.get(i).getTownB().getyPos()), 
										board.player2MissionHandStack.get(i).getPoints()));
								
						ps2.println(temp);
					}
					String temp2 = new Gson().toJson(new Players(p2.playerNum, p2.getPlColor()));
					ps2.println(temp2);
					
					PrintStream ps3 = new PrintStream(connectionArray.get(2).getOutputStream(), true);
					ps3.println("3");
					for (int i =0; i<4; i++)
					{
						String temp = new Gson().toJson(board.player3TrainHandStack.get(i));
						ps3.println(temp);
					}
					for (int i = 0; i < 2; i++) {
						String temp = new Gson().toJson(new MissionCard(
								new Town(board.player3MissionHandStack.get(i).getTownA().getName(),
										board.player3MissionHandStack.get(i).getTownA().getAmountOfConnections(),
										board.player3MissionHandStack.get(i).getTownA().getxPos(),
										board.player3MissionHandStack.get(i).getTownA().getyPos()), 
								new Town(board.player3MissionHandStack.get(i).getTownB().getName(),
										board.player3MissionHandStack.get(i).getTownB().getAmountOfConnections(),
										board.player3MissionHandStack.get(i).getTownB().getxPos(),
										board.player3MissionHandStack.get(i).getTownB().getyPos()), 
										board.player3MissionHandStack.get(i).getPoints()));
								
						ps3.println(temp);
					}
					String temp3 = new Gson().toJson(new Players(p3.playerNum, p3.getPlColor()));
					ps3.println(temp3);
					
					PrintStream ps4 = new PrintStream(connectionArray.get(3).getOutputStream(), true);
					ps4.println("4");
					for (int i =0; i<4; i++)
					{
						String temp = new Gson().toJson(board.player4TrainHandStack.get(i));
						ps4.println(temp);
					} 
					for (int i = 0; i < 2; i++) {
						String temp = new Gson().toJson(new MissionCard(
								new Town(board.player4MissionHandStack.get(i).getTownA().getName(),
										board.player4MissionHandStack.get(i).getTownA().getAmountOfConnections(),
										board.player4MissionHandStack.get(i).getTownA().getxPos(),
										board.player4MissionHandStack.get(i).getTownA().getyPos()), 
								new Town(board.player4MissionHandStack.get(i).getTownB().getName(),
										board.player4MissionHandStack.get(i).getTownB().getAmountOfConnections(),
										board.player4MissionHandStack.get(i).getTownB().getxPos(),
										board.player4MissionHandStack.get(i).getTownB().getyPos()), 
										board.player4MissionHandStack.get(i).getPoints()));
								
						ps4.println(temp);
					}
					String temp4 = new Gson().toJson(new Players(p4.playerNum, p4.getPlColor()));
					ps4.println(temp4);
					
					for (int i = 0; i < connectionArray.size(); i++) {
						PrintStream ps = new PrintStream(connectionArray.get(i).getOutputStream(), true);
						for (int j = 0; j < 5; j++) {
							String temp = new Gson().toJson(board.displayedTrainStack.get(j));
							ps.println(temp);
							//System.out.println(board.displayedTrainStack.get(j).getColor().getColorName());
						}
					}
					for (int i = 0; i < connectionArray.size(); i++) {
						PrintStream ps = new PrintStream(connectionArray.get(i).getOutputStream(), true);
						for (int j = 0; j < 75; j++) {
							String temp = new Gson().toJson(board.arrayOfTrainCards.get(j));
							ps.println(temp);
						}
					}
					for (int i = 0; i < connectionArray.size(); i++) {
						PrintStream ps = new PrintStream(connectionArray.get(i).getOutputStream(), true);
						for (int j = 0; j < 22; j++) {
							String temp = new Gson().toJson(new MissionCard(
							new Town(board.arrayOfMissionCards.get(j).getTownA().getName(),
									board.arrayOfMissionCards.get(j).getTownA().getAmountOfConnections(),
									board.arrayOfMissionCards.get(j).getTownA().getxPos(),
									board.arrayOfMissionCards.get(j).getTownA().getyPos()), 
							new Town(board.arrayOfMissionCards.get(j).getTownB().getName(),
									board.arrayOfMissionCards.get(j).getTownB().getAmountOfConnections(),
									board.arrayOfMissionCards.get(j).getTownB().getxPos(),
									board.arrayOfMissionCards.get(j).getTownB().getyPos()), 
									board.arrayOfMissionCards.get(j).getPoints()));
							ps.println(temp);
						}
					}
					
					
					ps1.println("CanAct");
					
					
					
					//String playerHand1 = serializer.toJson(board.player1TrainHandStack);

					
					// ps1.println("CanAct" + "\n");

					//ps1.println(playerHand1);

					
					
					
					
					
					/* turn.normalTurn(pArray, 1); */

					System.out.println("Game is ready");
				}

				InputStreamReader isr = new InputStreamReader(csocket.getInputStream());

				BufferedReader inFromClient = new BufferedReader(isr);

				
				
				
				 msg = inFromClient.readLine();
				
				String[] iAmMsg = new String[20];
				if (msg.contains("state1")) {
					
					/*whoseTurnItIs++;
					
					if (whoseTurnItIs > 4) {
						whoseTurnItIs = 1;
					} */
					
						
					System.out.println("reached state 1!");
					System.out.println(board.arrayOfMissionCards.size());
					
					for (int i=0; i<board.arrayOfMissionCards.size();i++){
					board.arrayOfMissionCards.remove(0);
					}
					
					
					
					for(int i= 0; i< 20; i++){
						
					
						String msg1 = inFromClient.readLine();
						MissionCard c= new Gson().fromJson(msg1, MissionCard.class);
						board.arrayOfMissionCards.add(c);
						
												
						System.out.println(board.arrayOfMissionCards.get(i).getTownA().getName());
					}
					
					int tmpHand= board.player1MissionHandStack.size();
					
					for(int i= 0; i< board.player1MissionHandStack.size(); i++){
						
						board.player1MissionHandStack.remove(0);
					}
					for(int i= 0; i<tmpHand +2; i++ ){
	
						String msg1 = inFromClient.readLine();
						MissionCard c= new Gson().fromJson(msg1, MissionCard.class);
						board.player1MissionHandStack.add(c);
	
	
					}
					
				/*	if (whoseTurnItIs == 1) {
						PrintStream ps1 = new PrintStream(connectionArray.get(0).getOutputStream(), true);
						ps1.println("CanAct");
					}
					if (whoseTurnItIs == 2) {
						PrintStream ps2 = new PrintStream(connectionArray.get(1).getOutputStream(), true);
						ps2.println("CanAct");
					}
					if (whoseTurnItIs == 3) {
						PrintStream ps3 = new PrintStream(connectionArray.get(2).getOutputStream(), true);
						ps3.println("CanAct");
					}
					if (whoseTurnItIs == 4) {
						PrintStream ps4 = new PrintStream(connectionArray.get(3).getOutputStream(), true);
						ps4.println("CanAct");
					} */
					
					// listen to whatever
					System.out.println(whoseTurnItIs);
					System.out.println("Changed to state1");

				} else if (msg.contains("state2")) {
					
				/*	whoseTurnItIs++;
					
					if (whoseTurnItIs > 4) {
						whoseTurnItIs = 1;
					} */
					
					globalAmountOfTrainCards -=2;
					
					for (int i = 0; i < board.arrayOfTrainCards.size(); i++) {
						board.arrayOfTrainCards.remove(0);
						
					}
					board.arrayOfTrainCards.clear();
					
					
					for (int i = 0; i < globalAmountOfTrainCards; i++) {
						String msg1 = inFromClient.readLine();
						Card c = new Gson().fromJson(msg1, Card.class);
						board.arrayOfTrainCards.add(c);
					}
					int tmpPlayerhand = board.player1TrainHandStack.size()+2;
					
					board.player1TrainHandStack.clear();
					for (int i = 0; i < tmpPlayerhand; i++) {
						String msg1 = inFromClient.readLine();
						Card c = new Gson().fromJson(msg1, Card.class);
						board.player1TrainHandStack.add(c);
						
					}
					
					board.displayedTrainStack.clear();					
					
					for (int i=0; i<5; i++)
					{
						String msg1 = inFromClient.readLine();
						Card c = new Gson().fromJson(msg1, Card.class);
						board.displayedTrainStack.add(c);
						
					}
					
				/*	if (whoseTurnItIs == 1) {
						PrintStream ps1 = new PrintStream(connectionArray.get(0).getOutputStream(), true);
						ps1.println("CanAct");
					}
					if (whoseTurnItIs == 2) {
						PrintStream ps2 = new PrintStream(connectionArray.get(1).getOutputStream(), true);
						ps2.println("CanAct");
					}
					if (whoseTurnItIs == 3) {
						PrintStream ps3 = new PrintStream(connectionArray.get(2).getOutputStream(), true);
						ps3.println("CanAct");
					}
					if (whoseTurnItIs == 4) {
						PrintStream ps4 = new PrintStream(connectionArray.get(3).getOutputStream(), true);
						ps4.println("CanAct");
					} */
					
					
					// listen to whatever
					System.out.println(whoseTurnItIs);
					System.out.println("Changed to state2");

				} else if (msg.contains("state3")) {
					
				/*	whoseTurnItIs++;
					
					if (whoseTurnItIs > 4) {
						whoseTurnItIs = 1;
					} */
					
					

					// listen to whatever
					
					board.arrayOfTrainCards.clear();
					
					for (int i = 0; i < 100; i++) {
						String msg1 = inFromClient.readLine();
						if (msg1.contains("stop"))
						{
							break;
						} else {
						Card c = new Gson().fromJson(msg1, Card.class);
						board.arrayOfTrainCards.add(c);
						}
					}
					
					board.player1TrainHandStack.clear();
					for (int i = 0; i < 100; i++) {
						String msg1 = inFromClient.readLine();
						if (msg1.contains("stop")) {
							break;
						} else {
							Card c = new Gson().fromJson(msg1, Card.class);
							board.player1TrainHandStack.add(c);
						}
					}
					
					for (int i = 0; i < board.connections.size(); i++) {
						String msg1 = inFromClient.readLine();
						int msg2 = Integer.parseInt(msg1);
						board.connections.get(i).setTakenByPlayer(msg2);
					}
					
				/*	if (whoseTurnItIs == 1) {
						PrintStream ps1 = new PrintStream(connectionArray.get(0).getOutputStream(), true);
						ps1.println("CanAct");
					}
					if (whoseTurnItIs == 2) {
						PrintStream ps2 = new PrintStream(connectionArray.get(1).getOutputStream(), true);
						ps2.println("CanAct");
					}
					if (whoseTurnItIs == 3) {
						PrintStream ps3 = new PrintStream(connectionArray.get(2).getOutputStream(), true);
						ps3.println("CanAct");
					}
					if (whoseTurnItIs == 4) {
						PrintStream ps4 = new PrintStream(connectionArray.get(3).getOutputStream(), true);
						ps4.println("CanAct");
					} */

					System.out.println(whoseTurnItIs);
					System.out.println("Changed to state3");
					
					
				} else {
					System.out.println("Activator was not 1 nor 2 nor states");
					System.out.println("The wrongly incoming message was ----------" + inFromClient.readLine());
				}

			}
		} 
				catch (

		Exception e)

		{
			e.printStackTrace();
		} finally

		{
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

import java.io.BufferedReader;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TCPServer {

	// scanner is only for testing
	static Scanner sc;
	static int testInt;

	public static ArrayList<Socket> connectionArray = new ArrayList<Socket>();
	public static int gameState = 0;

	static String[] players = new String[] { "player 1", "player 2", "player 3", "player 4" };
	static Turn turn = new Turn(players, testInt);

	public static void main(String[] args) throws IOException {

		sc = new Scanner(System.in);
		

		ServerSocket socket = new ServerSocket(2222);

		
		
		while (testInt < 5) {
			
			testInt = 1;
			turn.initialTurn();
			
			
			
		}

		try {
			while (true) {

				Socket sock = socket.accept();
				System.out.println("Server is running and a new input arrived");

<<<<<<< HEAD
				/*
				 * FOR CONNECTION CHECK, LATER for (int i = 1; i ==
				 * connectionArray.size(); i++) { if
				 * (connectionArray.get(i).getInetAddress() ==
				 * sock.getInetAddress()) { connectionArray.remove(i);
				 * 
				 * //connectionArray.add(sock); System.out.println(
				 * "Removed a player" + sock); } }
				 */

				connectionArray.add(sock);
				System.out.println("Added a player" + sock);

				System.out.println("Client connected from: " + sock.getInetAddress());

=======
				if (!connectionArray.contains(sock)) {
					connectionArray.add(sock);
					System.out.println("Added a player: " + sock);
					System.out.println("Client's InetAddress: " + sock.getInetAddress());
					
					PrintStream ps = new PrintStream(sock.getOutputStream(), true);
					for (int i = 0; i < connectionArray.size(); i++) {
						if (connectionArray.get(i) == sock) {
							
							ps.println("You are player " + (i+1) + "\n"); // Remember to add "\n" just like ";"
							ps.println("mkay" + "\n");
						}
					}
				}
				
>>>>>>> origin/master
				InputStreamReader isr = new InputStreamReader(sock.getInputStream());

				BufferedReader inFromClient = new BufferedReader(isr);

				String msg = inFromClient.readLine();

<<<<<<< HEAD
				Train t = new Gson().fromJson(msg, Train.class);
=======
				// CREATE ALL THE OTHER CLASS AS OBJECTS HERE, BUT MAKE SURE THAT THERE IS ONLY 1 PER PLAYER
				// also make sure that InFromCleint.readLine() fits whatever object is going to be changed
				//Train train = new Gson().fromJson(msg, Train.class);
				//Board board = new Gson().fromJson(msg, Board.class);
				TrainCardStack tcs = new Gson().fromJson(msg, TrainCardStack.class);
				 
				
>>>>>>> origin/master

				if (msg != null) {
<<<<<<< HEAD
					PrintStream ps = new PrintStream(sock.getOutputStream());
					ps.println("msg received"); // Will be sent to the client
=======
					
				/*	PrintStream ps = new PrintStream(sock.getOutputStream(), true);
					for (int i = 0; i <= connectionArray.size(); i++) {
						if (connectionArray.get(i) == sock) {
							
							ps.println("You are player " + i + "\n"); // Remember to add "\n" just like ";"
							ps.println("mkay" + "\n");
							
						}
					} 
					*/

					 //ps.println("msg received"); // Will be sent to the client
>>>>>>> origin/master
				}

				if (connectionArray.size() == 4) {
					gameState = 1; // 1 for initiate game
					initiateGame();

<<<<<<< HEAD
					System.out.println("Game is ready");
=======
					gameHasBeenInitiated = true;
					
					
					Players p1 = new Players(connectionArray.get(0), "player1");
					Players p2 = new Players(connectionArray.get(1), "player2");
					Players p3 = new Players(connectionArray.get(2), "player3");
					Players p4 = new Players(connectionArray.get(3), "player4");
					

					for (int i = 0; i < connectionArray.size(); i++) {
						PrintStream ps = new PrintStream(connectionArray.get(i).getOutputStream(), true);
						
						String playerJson1 = new Gson().toJson(p1);
						String playerJson2 = new Gson().toJson(p2);
						String playerJson3 = new Gson().toJson(p3);
						String playerJson4 = new Gson().toJson(p4);
						
						ps.println(playerJson1);
						ps.println(playerJson2);
						ps.println(playerJson3);
						ps.println(playerJson4);
					
					}
					
					System.out.println("Game is ready");
					
					for (int i = 0; i < connectionArray.size(); i++) {
					PrintStream ps = new PrintStream(connectionArray.get(i).getOutputStream(), true);
					ps.println("Game has begun!" + "\n");
					}
						
>>>>>>> origin/master
				}
				

				/*
				 * if (!sock.isConnected()) { System.out.println(
				 * " A player is disc"); for (int i = 1; i ==
				 * connectionArray.size(); i++) { if (connectionArray.get(i) ==
				 * sock) { connectionArray.remove(i); System.out.println(
				 * "Removed player:" + sock); } } }
				 */

				System.out.println(msg);
				
				//System.out.println(board.missionCardStack.card[5].color.getColorName());
				
				System.out.println(tcs);

<<<<<<< HEAD
				System.out.println(t.amountOfTrains);
=======
				//System.out.println(train.amountOfTrains);
>>>>>>> origin/master
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			socket.close();
<<<<<<< HEAD
		}
=======
		}	
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
		
>>>>>>> origin/master
	}

	public static void initiateGame() {
<<<<<<< HEAD

		for (int i = 1; i == connectionArray.size(); i++) {
=======
		
		for (int i = 1; i <= connectionArray.size(); i++) {
>>>>>>> origin/master
			// if (connectionArray[i].) {

			// }
		}

	}
}

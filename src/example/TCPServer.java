package example;
import java.io.BufferedReader;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;


public class TCPServer implements Runnable {

	public static ArrayList<Socket> connectionArray = new ArrayList<Socket>();

	public static int gameState = 0;
	public static boolean gameHasBeenInitiated = false;
	
	static Train ta;

	public static void main(String[] args) throws IOException {

		TCPServer tcpServer = new TCPServer();

		Thread threadOne = new Thread(tcpServer);
		Thread threadTwo = new Thread(tcpServer);
		Thread threadThree = new Thread(tcpServer);
		Thread threadFour = new Thread(tcpServer);
		Thread threadFive = new Thread(tcpServer);
		threadOne.start();
		threadTwo.start();
		threadThree.start();
		threadFour.start();
		threadFive.start();
		
		ta = new Train(null);

		ServerSocket socket = new ServerSocket(2222);

		try {
			while (true) {

				Socket sock = socket.accept();
				System.out.println("Server is running and a new input arrived");

				if (!connectionArray.contains(sock)) {
					connectionArray.add(sock);
					System.out.println("Added a player: " + sock);
					System.out.println("Client's InetAddress: " + sock.getInetAddress());

					PrintStream ps = new PrintStream(sock.getOutputStream(), true);
					for (int i = 0; i < connectionArray.size(); i++) {
						if (connectionArray.get(i) == sock) {

							//ps.println("You are player " + (i + 1) + "\n"); // Remember
																			// to
																			// add
																			// "\n"
																			// just
																			// like
																			// ";"
							//ps.println("mkay" + "\n");
						}
					}
				}

				InputStreamReader isr = new InputStreamReader(sock.getInputStream());

				BufferedReader inFromClient = new BufferedReader(isr);

				//String msg = inFromClient.readLine();
				//String msg2 = inFromClient.readLine();
				
				//System.out.println(msg);
				//System.out.println(train.amountOfTrains);
				
				if(inFromClient.readLine().contains("1")) {
					String msg3 = inFromClient.readLine();
					Train train = new Gson().fromJson(msg3, Train.class);
					System.out.println(train.amountOfTrains);
				}
				if (inFromClient.readLine().contains("2")) {
					System.out.println("state2");
					
					
					
					
				}

				// CREATE ALL THE OTHER CLASS AS OBJECTS HERE, BUT MAKE SURE
				// THAT THERE IS ONLY 1 PER PLAYER
				// also make sure that InFromCleint.readLine() fits whatever
				// object is going to be changed
				// Train train = new Gson().fromJson(msg, Train.class);
				// Board board = new Gson().fromJson(msg, Board.class);

				// TrainCardStack tcs = new Gson().fromJson(msg,
				// TrainCardStack.class);

				// What is being sent back to the client

				//System.out.println(train.amountOfTrains);
				// TrainCardStack tcs = new Gson().fromJson(msg,
				// TrainCardStack.class);

				/*
				 * PrintStream ps = new PrintStream(sock.getOutputStream(),
				 * true); for (int i = 0; i <= connectionArray.size(); i++) { if
				 * (connectionArray.get(i) == sock) {
				 * 
				 * ps.println("You are player " + i + "\n"); // Remember to add
				 * "\n" just like ";" ps.println("mkay" + "\n");
				 * 
				 * } }
				 */

				// ps.println("msg received"); // Will be sent to the client

				if (connectionArray.size() == 4 && !gameHasBeenInitiated) {
					gameState = 1; // 1 for initiate game

					initiateGame();

					gameHasBeenInitiated = true;

				//	Players p1 = new Players(connectionArray.get(0), "player1");
				//	Players p3 = new Players(connectionArray.get(2), "player3");
				//	Players p4 = new Players(connectionArray.get(3), "player4");
				//	Players p2 = new Players(connectionArray.get(1), "player2");
					
					//String playerJson1 = new Gson().toJson(p1);
					String t = new Gson().toJson(ta);
	/*				String playerJson2 = new Gson().toJson(p2);
					String playerJson3 = new Gson().toJson(p3);
					String playerJson4 = new Gson().toJson(p4); */

					for (int i = 0; i < connectionArray.size(); i++) {
						PrintStream ps = new PrintStream(connectionArray.get(i).getOutputStream(), true);

						

						ps.println(t + "\n");
/*						ps.println(playerJson2 + "\n");
						ps.println(playerJson3 + "\n");
						ps.println(playerJson4 + "\n");
*/
					} 

					System.out.println("Game is ready");

					for (int i = 0; i < connectionArray.size(); i++) {
						PrintStream ps = new PrintStream(connectionArray.get(i).getOutputStream(), true);
						//ps.println("Game has begun!" + "\n");
					}

				}

				//System.out.println(msg);

				// System.out.println(board.missionCardStack.card[5].color.getColorName());

				// System.out.println(tcs);

				// System.out.println(train.amountOfTrains);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());

	}

	public static void initiateGame() {

		for (int i = 1; i <= connectionArray.size(); i++) {
			// if (connectionArray[i].) {

			// }
		}
	}
}

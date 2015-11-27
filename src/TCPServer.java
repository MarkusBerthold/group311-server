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
		
		
		ServerSocket socket = new ServerSocket(2222);

		try {
			while (true) {

				System.out.println("Server is running");

				Socket sock = socket.accept();

				connectionArray.add(sock);
				
				
				
				
				System.out.println("Added a player: " + sock);

				System.out.println("Client's InetAddress: " + sock.getInetAddress());
				
				InputStreamReader isr = new InputStreamReader(sock.getInputStream());

				BufferedReader inFromClient = new BufferedReader(isr);

				String msg = inFromClient.readLine();

				// CREATE ALL THE OTHER CLASS AS OBJECTS HERE, BUT MAKE SURE THAT THERE IS ONLY 1 PER PLAYER
				Train train = new Gson().fromJson(msg, Train.class);
				 
				

				//What is being sent back to the client
				if (msg != null) {
					PrintStream ps = new PrintStream(sock.getOutputStream(), true);
					for (int i = 1; i <= connectionArray.size() -1; i++) {
						if (connectionArray.get(i) == sock) {
							
							ps.println("You are player " + i + "\n"); // Remember to add "\n" just like ";"
							ps.println("mkay" + "\n");
						}
					} 

					 //ps.println("msg received"); // Will be sent to the client
				}

				if (connectionArray.size() == 4 && !gameHasBeenInitiated) {
					gameState = 1; // 1 for initiate game

					initiateGame();

					gameHasBeenInitiated = true;

					System.out.println("Game is ready");
					
					PrintStream ps = new PrintStream(sock.getOutputStream(), true);
					ps.println("Game has begun!" + "\n");
						
				}

				System.out.println(msg);

				System.out.println(train.amountOfTrains);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
		
		Players p1 = new Players(connectionArray.get(1), "player1");
		Players p2 = new Players(connectionArray.get(2), "player2");
		Players p3 = new Players(connectionArray.get(3), "player3");
		Players p4 = new Players(connectionArray.get(4), "player4");
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
		
	}

	

	public static void initiateGame() {
		
		//EMIT TO ALL PLAYERS THAT THE GAME HAS BEGUN
		
		
		

		for (int i = 1; i <= connectionArray.size(); i++) {
			// if (connectionArray[i].) {

			// }
		}
	}
}

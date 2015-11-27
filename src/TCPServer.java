import java.io.BufferedReader;
import java.io.Flushable;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;

public class TCPServer {

	public static ArrayList<Socket> connectionArray = new ArrayList<Socket>();
	
	public static int gameState = 0;
	public static boolean gameHasBeenInstatiated = false;

	public static void main(String[] args) throws IOException {

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

				// CREATE ALL THE OTHER CLASS AS OBJECTS HERE
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

				if (connectionArray.size() == 4 && !gameHasBeenInstatiated) {
					gameState = 1; // 1 for initiate game

					initiateGame();

					gameHasBeenInstatiated = true;

					System.out.println("Game is ready");
				}

				System.out.println(msg);

				System.out.println(train.amountOfTrains);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}

	

	public static void initiateGame() {

		for (int i = 1; i == connectionArray.size(); i++) {
			// if (connectionArray[i].) {

			// }
		}
	}
}

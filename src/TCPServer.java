import java.io.BufferedReader;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;

public class TCPServer {

	public static ArrayList<Socket> connectionArray = new ArrayList<Socket>();
	public static int gameState = 0;
	 
	static String[] players= new String[]{"player 1", "player 2", "player 3", "player 4"};
	static Turn turn= new Turn(players);
     
	public static void main(String[] args) throws IOException {

		turn.doThis();
		 
		ServerSocket socket = new ServerSocket(2222);

		
		try {
			while (true) {

				Socket sock = socket.accept();

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

				InputStreamReader isr = new InputStreamReader(sock.getInputStream());

				BufferedReader inFromClient = new BufferedReader(isr);

				String msg = inFromClient.readLine();

				Train t = new Gson().fromJson(msg, Train.class);

				if (msg != null) {
					PrintStream ps = new PrintStream(sock.getOutputStream());
					ps.println("msg received"); // Will be sent to the client
				}

				if (connectionArray.size() == 4) {
					gameState = 1; // 1 for initiate game
					initiateGame();

					System.out.println("Game is ready");
				}

				/*
				 * if (!sock.isConnected()) { System.out.println(
				 * " A player is disc"); for (int i = 1; i ==
				 * connectionArray.size(); i++) { if (connectionArray.get(i) ==
				 * sock) { connectionArray.remove(i); System.out.println(
				 * "Removed player:" + sock); } } }
				 */

				System.out.println(msg);

				System.out.println(t.amountOfTrains);
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

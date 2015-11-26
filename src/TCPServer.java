import java.io.BufferedReader;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;

public class TCPServer {

	public static ArrayList<Socket> connectionArray = new ArrayList<Socket>();
	public static ArrayList<String> currentUsers = new ArrayList<String>();

	public static void main(String[] args) throws IOException {

		// String json = new String ("");

		// Gson serialiser = new Gson();

		// Human Emil = serialiser.fromJson(json, Human.class);

		ServerSocket socket = new ServerSocket(1330);

		try {
			while (true) {

				Socket sock = socket.accept();
				connectionArray.add(sock);

				System.out.println("Client connected from: " + sock.getLocalAddress().getHostName());

				InputStreamReader isr = new InputStreamReader(sock.getInputStream());

				BufferedReader inFromClient = new BufferedReader(isr);

				String msg = inFromClient.readLine();

				if (msg != null) {
					PrintStream ps = new PrintStream(sock.getOutputStream());
					ps.println("msg received"); // Will be sent to the client
				}
				System.out.println(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}

		// json = inFromClient.readLine(); //NullPointerException

		// serialiser.fromJson(json, Human.class);

		// System.out.println(json);

		// socket.close();

	}
}

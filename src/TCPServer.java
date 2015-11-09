import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) throws IOException {

		while (true) {
			try {

				ServerSocket socket = new ServerSocket(1233);

				Socket sock = socket.accept();

				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(sock.getInputStream()));

				System.out.println(inFromClient.readLine());

				socket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

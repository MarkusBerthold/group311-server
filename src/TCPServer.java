import java.io.BufferedReader;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;



public class TCPServer {

	public static void main(String[] args) throws IOException {
		
		String json = new String ("");
		
		Gson serialiser = new Gson();
		
		Human Emil = serialiser.fromJson(json, Human.class);
		
		while (true) {
			try {

				ServerSocket socket = new ServerSocket(1233);

				Socket sock = socket.accept();

				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(sock.getInputStream()));
	
				json = inFromClient.readLine();	//NullPointerException

				serialiser.fromJson(json, Human.class);
				
				System.out.println(json);

				socket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

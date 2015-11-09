import java.io.BufferedReader;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.*;



public class TCPServer {

	public static void main(String[] args) throws IOException {
		
		String json = "";
		
		Gson serialiser = new Gson();
		
		Human Emil = serialiser.fromJson(json, Human.class);
		
		
		
		
		
		
		while (true) {
			try {

				ServerSocket socket = new ServerSocket(1233);

				Socket sock = socket.accept();

				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(sock.getInputStream()));	
				
				json = new String(inFromClient.readLine());				
				
				g1.toJson(json);
				
				//g1.fromJson(json, );

				//System.out.println(inFromClient.readLine());
				
				System.out.println(g1);				

				socket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

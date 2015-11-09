import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.*;

import com.google.gson.Gson;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		
		Human Emil = serialiser.fromJson(json, Human.class);
		
		
		Gson g1 = new Gson();
		
		String json = "";
		
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

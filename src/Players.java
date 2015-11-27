
import java.net.*;

public class Players {
	
	public Socket sock;
	public String name;
	
	public Players(Socket sock, String name) {
		
		this.sock = sock;
		this.name = name;
		
	}

}

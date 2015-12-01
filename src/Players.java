
import java.net.*;
import java.util.ArrayList;

public class Players {
	
	public Socket sock;
	public String name;
	public int numOfTrains;
	private ArrayList<MissionCard> handOfMissions = new ArrayList<MissionCard>();
	private ArrayList<TrainCard> handOfTrainCards = new ArrayList<TrainCard>();
	
	
	
	public Players(Socket sock, String name) {
		
		this.sock = sock;
		this.name = name;
		
	}
	
	Act()
	{
		
	}

	public int getNumOfTrains() {
		return numOfTrains;
	}

	public void setNumOfTrains(int numOfTrains) {
		this.numOfTrains = numOfTrains;
	}

	public ArrayList<MissionCard> getHandOfMissions() {
		return handOfMissions;
	}

	public void setHandOfMissions(ArrayList<MissionCard> handOfMissions) {
		this.handOfMissions = handOfMissions;
	}

	public ArrayList<TrainCard> getHandOfTrainCards() {
		return handOfTrainCards;
	}

	public void setHandOfTrainCards(ArrayList<TrainCard> handOfTrainCards) {
		this.handOfTrainCards = handOfTrainCards;
	}
	
	
	
	//
	
	
	
	

}

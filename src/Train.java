
import java.awt.Color;

public class Train {
	
	 public Color trainColor;
	 public int amountOfTrains;
	
	Train(Color _trainColor){
		this.trainColor = _trainColor;
		amountOfTrains = 45;
	}

	
	public void decrease(int amount){
		amountOfTrains -= amount;
	}
}



public class Train {
	
	private Color trainColor;
	private int amountOfTrains;
	
	Train(Color _trainColor){
		this.trainColor = _trainColor;
		amountOfTrains = 45;
	}

	
	public void decrease(int amount){
		amountOfTrains -= amount;
	}
}


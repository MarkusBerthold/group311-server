

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class EndButton {

	private int xPos, yPos, width, height;
	private Rectangle rect;
	int state;

	public EndButton() {
		xPos = 910;
		yPos = 615;
		width = 100;
		height = 50;
		state = 0;
	}

	public void setVisible(Graphics g, int state) {

		if (state == 0) {
			g.setColor(new Color(255, 255, 0));
			g.fillRect(xPos, yPos, width, height);
		} else if (state == 1) {
			g.setColor(new Color(0, 255, 0));
			g.fillRect(xPos, yPos, width, height);
		}
		
		g.setColor(new Color(0, 0, 0));

		g.drawString("EndTurn", xPos + width / 5, yPos + height / 3);

	}
	public int getxPos() {
		return xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}

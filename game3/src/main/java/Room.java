import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Room {
	
	int level;
	
	public Room(int level) {
		this.level = level;
	}
	
	public void draw(Graphics g, Dimension screenSize) {
		//TODO Use an actual background image (we need background images first though lol)
		g.setColor(Color.black);
		int x = (int) (screenSize.getWidth() - screenSize.getHeight()) / 2;
		g.fillRect(x, 0, (int)screenSize.getHeight(), (int)screenSize.getHeight());
	}
}

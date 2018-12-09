import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.*;

public class Block extends RoomObject {
	private BufferedImage blockSprite;
	
	public Block(double xLoc, double yLoc, int w, int h, BufferedImage bSprite) {
		super(xLoc, yLoc, w, h);
		blockSprite = bSprite;
	}
	
	public Rectangle getRekt() { return new Rectangle((int)x, (int)y, width, height); }
	
	public void update(Graphics g) {
		paint(g);
	}
	
	@Override
	protected void paint(Graphics g) {
		g.drawImage(blockSprite, (int)getX(), (int)getY(), getWidth(), getHeight(), null);
	}
}

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.*;

public class Block {
	private int height;
	private int width;
	private double x;
	private double y;
	private BufferedImage blockSprite;
	
	public Block(double xLoc, double yLoc, int w, int h, BufferedImage bSprite) {
		height = h;
		width = w;
		x = xLoc;
		y = yLoc;
		blockSprite = bSprite;
	}
	
	public Rectangle getRekt() { return new Rectangle((int)x, (int)y, width, height); }
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void paint(Graphics g) {
		g.drawImage(blockSprite, (int)x, (int)y, width, height, null);
	}
	
	public double getX() { return x; }
	
	public double getY() { return y; }
	
	public int getWidth() { return width; }
	
	public int getHeight() { return height; }
}

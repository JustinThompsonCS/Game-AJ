import java.awt.image.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
// 
public class Player {
	private int height;
	private int width;
	private double x;
	private double y;
	private double mInc;
	private BufferedImage playerSprite;
	
	public Player(double x, double y, int width, int height, BufferedImage playerSprite) {
		this.height = height;
		this.width = width;
		this.playerSprite = playerSprite;
		this.x = x;
		this.y = y;
		mInc = 1.0;
	}
	
	public Player(double x, double y, int width, int height, BufferedImage playerSprite, double mI) {
		this.height = height;
		this.width = width;
		this.playerSprite = playerSprite;
		this.x = x;
		this.y = y;
		mInc = mI;
	}
	
	public void move(MyKeyListener kb) {
	     if (kb.isKeyDown(KeyEvent.VK_W)) y -= mInc;
	     if (kb.isKeyDown(KeyEvent.VK_S)) y += mInc;
	     if (kb.isKeyDown(KeyEvent.VK_D)) x += mInc;
	     if (kb.isKeyDown(KeyEvent.VK_A)) x -= mInc;
	}
	
	public void update(MyKeyListener kb, Graphics g) {
		move(kb);
		paint(g);
	}
	
	public void paint(Graphics g) {
		g.drawImage(playerSprite, (int)x, (int)y, width, height, null);
	}
	
	public Rectangle getRect() { return new Rectangle((int)x, (int)y, width, height); }
	
	public double getX() { return x; }
	
	public double getY() { return y; }
	
	public int getWidth() { return width; }
	
	public int getHeight() { return height; }
}

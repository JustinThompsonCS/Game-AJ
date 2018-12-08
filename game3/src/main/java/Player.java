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
	private Direction dir; // 0 = no dir, 1 = right, 2 = down, 3 = left, 4 = up
	
	public Player(double x, double y, int width, int height, BufferedImage playerSprite) {
		this.height = height;
		this.width = width;
		this.playerSprite = playerSprite;
		this.x = x;
		this.y = y;
		mInc = 1.0;
		dir = Direction.None;
	}
	
	public Player(double x, double y, int width, int height, BufferedImage playerSprite, double mI) {
		this.height = height;
		this.width = width;
		this.playerSprite = playerSprite;
		this.x = x;
		this.y = y;
		mInc = mI;
		dir = Direction.None;
	}
	
	public void move(MyKeyListener kb) {
	     if (kb.isKeyDown(KeyEvent.VK_W)) {
	    	 y -= mInc;
	    	 dir = Direction.North;
	     }
	     if (kb.isKeyDown(KeyEvent.VK_S)) {
	    	 y += mInc;
	    	 dir = Direction.South;
	     }
	     if (kb.isKeyDown(KeyEvent.VK_D)) {
	    	 x += mInc;
	    	 dir = Direction.East;
	     }
	     if (kb.isKeyDown(KeyEvent.VK_A)) {
	    	 x -= mInc;
	    	 dir = Direction.West;
	     }
	}
	
	public void update(MyKeyListener kb, Graphics g) {
		move(kb);
		paint(g);
	}
	
	public void paint(Graphics g) {
		g.drawImage(playerSprite, (int)x, (int)y, width, height, null);
	}
	
	public Rectangle getRekt() { return new Rectangle((int)x, (int)y, width, height); }
	
	public double getX() { return x; }
	
	public double getY() { return y; }
	
	public void setXY(double setX, double setY) {
		x = setX;
		y = setY;
	}
	public double getMInc() { return mInc; }
	
	public void setX(double setX) {	x = setX; }
	
	public void setY(double setY) {y = setY; }
	
	public Direction getDir() { return dir; }
	
	public int getWidth() { return width; }
	
	public int getHeight() { return height; }
}

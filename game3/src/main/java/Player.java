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
	private double speed;
	private BufferedImage playerSprite;
	private Direction dir; // 0 = no dir, 1 = right, 2 = down, 3 = left, 4 = up
	private int hp;
	
	public Player(double x, double y, int width, int height, BufferedImage playerSprite) {
		this.height = height;
		this.width = width;
		this.playerSprite = playerSprite;
		this.x = x;
		this.y = y;
		speed = 1.0;
		hp = 4;
		dir = Direction.None;
	}
	
	public Player(double x, double y, int width, int height, BufferedImage playerSprite, double spd) {
		this.height = height;
		this.width = width;
		this.playerSprite = playerSprite;
		this.x = x;
		this.y = y;
		speed = spd;
		dir = Direction.None;
	}
	
	public void move(MyKeyListener kb, Block[] blocks) {
		double tempY = y;
		double tempX = x;
	     if (kb.isKeyDown(KeyEvent.VK_W)) {
	    	 tempY -= speed;
	     }
	     if (kb.isKeyDown(KeyEvent.VK_S)) {
	    	 tempY += speed;
	     }
	     if (kb.isKeyDown(KeyEvent.VK_D)) {
	    	 tempX += speed;
	     }
	     if (kb.isKeyDown(KeyEvent.VK_A)) {
	    	 tempX -= speed;
	     }
	     
	     boolean canMoveX = true;
	     boolean canMoveY = true;
	     
	     for (Block block: blocks) {
	    	 Rectangle pR = new Rectangle((int)tempX, (int)y, width, height);
	    	 Rectangle pR1 = new Rectangle((int)x, (int)tempY, width, height);
	    	 
	    	 if (pR.intersects(block.getRekt())) {
	    		 canMoveX = false;
	    	 }
	    	 if (pR1.intersects(block.getRekt())) {
	    		 canMoveY = false;
	    	 }
	    	 if (!canMoveX && !canMoveY) {break; }
	     }
	     if (canMoveX){x = tempX;}
	     if (canMoveY){y = tempY;}
	}
	
	public void update(MyKeyListener kb, Graphics g, Block[] blocks) {
		move(kb, blocks);
		paint(g);
	}
	
	public void paint(Graphics g) {
		g.drawImage(playerSprite, (int)x, (int)y, width, height, null);
	}
	
	public Rectangle getRekt() { return new Rectangle((int)x, (int)y, width, height); }
	
	public double getX() { return x; }
	
	public double getY() { return y; }
	
	public double getSpeed() { return speed; }
	
	public Direction getDir() { return dir; }
	
	public int getWidth() { return width; }
	
	public int getHeight() { return height; }
	
	public int getHp() { return hp; }
}

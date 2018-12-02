import java.awt.image.*;
import java.awt.event.KeyEvent;
// 
public class Player {
	private int height;
	private int width;
	private double x;
	private double y;
	private double mInc;
	private BufferedImage playerSprite;
	
	public Player(int h, int w, BufferedImage sprite, double x, double y) {
		height = h;
		width = w;
		playerSprite = sprite;
		this.x = x;
		this.y = y;
		mInc = 1.0;
	}
	
	public Player(int h, int w, BufferedImage sprite, double x, double y, double mI) {
		height = h;
		width = w;
		playerSprite = sprite;
		this.x = x;
		this.y = y;
		mInc = mI;
	}
	
	public void playerMove(MyKeyListener kb) {
	     if (kb.isKeyDown(KeyEvent.VK_W)) y -= mInc;
	     if (kb.isKeyDown(KeyEvent.VK_S)) y += mInc;
	}
	
	public void update(MyKeyListener kb) {
		
	}
	
	public void paint() {
		
	}
}

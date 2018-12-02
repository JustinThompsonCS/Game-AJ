import java.awt.image.*;
import java.awt.event.KeyEvent;
// 
public class Player {
	private int height;
	private int width;
	private int x;
	private int y;
	private BufferedImage playerSprite;
	
	public Player(int h, int w, BufferedImage sprite, int x, int y) {
		height = h;
		width = w;
		playerSprite = sprite;
		this.x = x;
		this.y = y;
	}
	
	public void playerMove(MyKeyListener kb) {
	     //if (kb.isKeyDown(KeyEvent.VK_W)) 
	}
	
	public void update(MyKeyListener kb) {
		
	}
	
	public void paint() {
		
	}
}

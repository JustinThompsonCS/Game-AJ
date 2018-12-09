import java.awt.Graphics;

public class Enemy extends RoomObject {

	public Enemy(double x, double y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	protected void paint(Graphics g) {
		
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

}

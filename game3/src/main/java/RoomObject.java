import java.awt.Graphics;

public abstract class RoomObject {
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	
	public RoomObject(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update(Graphics g);
	
	protected abstract void paint(Graphics g);
	
	public double getX() { return x; }
	
	public double getY() { return y; }
	
	public int getWidth() { return width; }
	
	public int getHeight() { return height; }
	
}

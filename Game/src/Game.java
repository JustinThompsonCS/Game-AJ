import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {
	JFrame frame;
	MyKeyListener kb;
	Player player;
	double screenWidth;
	double screenHeight;
	
	public Game() {
		kb = new MyKeyListener();
		addKeyListener(kb);
		setFocusable(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screenSize.getWidth();
		screenHeight = screenSize.getHeight();
		int px = (int)(screenWidth / 2 - 25);
		int py = (int)(screenHeight / 2 - 25);
		int pWidth = 49;
		int pHeight = 49;
		try {
			BufferedImage playerImage = ImageIO.read(new File("Mario_8Bit.png"));
			player = new Player(px, py, pWidth, pHeight, playerImage);
		} catch (IOException e) {
			System.out.println("Player Image not found");
			return;
		}
		frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setSize(screenSize);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	
	public void pauseMenu() {
		//TODO
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		player.update(kb, g);
		/*
		 * All other object updates go here
		 */
		
	}
	
	public void update() {  //Updates variables and runs methods
		long startTime = System.currentTimeMillis();
		repaint();
		if (kb.isKeyDown(KeyEvent.VK_ESCAPE)) {
			//pauseMenu(); //TODO
			setVisible(false);
			frame.dispose();
		}
		long endTime = System.currentTimeMillis();
		while (endTime - startTime < 5) endTime = System.currentTimeMillis();	
	}
	
	public void start() {
		while (true) update();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}

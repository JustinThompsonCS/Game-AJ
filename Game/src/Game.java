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
	double screenWidth;
	double screenHeight;
	Dimension screenSize;
	JFrame frame;
	MyKeyListener kb;
	
	private boolean exitGame;
	private boolean paused;
	
	Player player;
	
	Map map;
	int roomX;
	int roomY;
	int level;
	
	public Game() {
		kb = new MyKeyListener();
		addKeyListener(kb);
		setFocusable(true);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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
		
		map = new Map(level);
		
		exitGame = false;
		paused = false;
		
		frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		//frame.setSize(screenSize);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	
	public void pauseMenu() {
		//TODO
		paused = true;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (!paused) {
			map.getRoom(roomX, roomY).draw(g, screenSize);
			player.update(kb, g);
		}
		else {
			//TODO Pause menu drawing methods
		}
		
		/*
		 * All other object updates go here
		 */
		
	}
	
	public void update() {  //Updates variables and runs methods
		long startTime = System.currentTimeMillis();
		repaint();
		if (kb.isKeyDown(KeyEvent.VK_ESCAPE)) {
			pauseMenu(); //TODO
			exitGame = true;
			setVisible(false);
			frame.dispose();
		}
		
		/*
		 * TODO
		 * Add logic where when player moves through a door in any of the 4 wings, he goes to the room in that location.
		 * This resets the roomX or roomY location, and also resets the player's location to be right outside that respective door. 
		 * the repaint and the update methods should handle the redrawing of it.
		 * Use the Map class to handle most of this logic. (Adding methods and variables may be necessary.)
		 * The Direction enum type could help with this (i.e. switch cases or whatever works.) //Use Direction.North / Direction.East to identify which direction. 
		 * Also, while the room is loading (if it even takes long) let me know where you want a loading screen in the code with a //TODO and a comment explaining what it is.
		 */
		
		long endTime = System.currentTimeMillis();
		while (endTime - startTime < 5) endTime = System.currentTimeMillis();	
	}
	
	public void start() {
		while (!exitGame) update();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}

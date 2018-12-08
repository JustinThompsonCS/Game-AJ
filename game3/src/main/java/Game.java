import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

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
	Block floor;
	
	Map map;
	int roomX;
	int roomY;
	int level;
	
	public Game() throws IOException, URISyntaxException {
		kb = new MyKeyListener();
		addKeyListener(kb);
		setFocusable(true);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screenSize.getWidth();
		screenHeight = screenSize.getHeight()/2;
				
		int px = (int)(screenWidth / 2 - 25);
		int py = (int)(screenHeight / 2 - 25);
		int pWidth = 49;
		int pHeight = 49;
		double pMinc = 2;
		
		try {
			URI image = new URI(this.getClass().getClassLoader().getResource("Mario_8Bit.png").toString());
			BufferedImage playerImage = ImageIO.read(new File(image));
			player = new Player(px, py, pWidth, pHeight, playerImage, pMinc);
		} catch (IOException e) {
			System.out.println("Player Image not found");
			return;
		}
	
		//Instantiating a floor object
		int fWidth = 250;
		int fHeight = 49;
		int fx = 700;
		int fy = 500;
		try {
			URI image = new URI(this.getClass().getClassLoader().getResource("floor.png").toString());
			BufferedImage floorImage = ImageIO.read(new File(image));
			floor = new Block(fx, fy, fWidth, fHeight, floorImage);
		} catch (IOException e) {
			System.out.println("floor Image not found");
			return;
		}
		
		
		
		
		map = new Map(level);
		
		exitGame = false;
		paused = false;
		
		frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		
		Dimension ss = new Dimension(screenSize.width, screenSize.height/2);
		frame.setSize(ss);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	
	public boolean isCollision(Player p, Block b) {
		Rectangle rect1 = p.getRekt();
		Rectangle rect2 = b.getRekt();
		
		Rectangle rect3 = rect1.intersection(rect2);
		
		/*
		if (rect3.x > rect1.x)
			return Direction.South;
			*/
		
		if(rect1.intersects(rect2)) {
			return true;
		}
		return false;
	}
	
	public void fixCollision() {
		if (isCollision(player, floor)) {			
			if (player.getDir() == Direction.East) { player.setX(player.getX() - player.getMInc()); }
			if (player.getDir() == Direction.West) { player.setX(player.getX() + player.getMInc()); }
			if (player.getDir() == Direction.South) { player.setY(player.getY() - player.getMInc()); }
			if (player.getDir() == Direction.North) { player.setY(player.getY() + player.getMInc()); }
		}
		
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
			floor.update(g);
			fixCollision();
			
			
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
			
			System.exit(0);
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
		Timer timer = new Timer(10, new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (exitGame) {
					System.exit(0);
				}
				
				update();
			}
		});
		
		timer.start();
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		Game game = new Game();
		game.start();
	}
	
	
	
	
}


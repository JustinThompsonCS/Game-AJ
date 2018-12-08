import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlayerTester extends JPanel {
	Player p;
	MyKeyListener kb;
	
	public PlayerTester() {
		kb = new MyKeyListener();
		addKeyListener(kb);
		setFocusable(true);
		BufferedImage img;
		try {
			img = ImageIO.read(new File("Mario_8Bit.png"));
			p = new Player(0, 0, 100, 100, img);
		} catch (IOException e) {
			System.out.println("Image not found");
			e.printStackTrace();
		}
		super.setBackground(Color.BLACK);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		p.update(kb, g);
	}
	
	public void updatePlayer() {
		long startTime = System.currentTimeMillis();
		repaint();
		long endTime = System.currentTimeMillis();
		while (endTime - startTime < 5) {
			endTime = System.currentTimeMillis();
		}
		
	}
	
	public static void main(String[] args) {
		PlayerTester p = new PlayerTester();
		int screenWidth = 1000;
		int screenHeight = 600;
		JFrame frame = new JFrame("PlayerTester");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(p);
		//frame.pack();
		frame.setSize(screenWidth, screenHeight);
		frame.setVisible(true);
		while (true)
			p.updatePlayer();
		
	}
	
}

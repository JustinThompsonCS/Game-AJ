import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;


public class MyKeyListener implements KeyListener {
	Set<Integer> keyDown;
	
	public MyKeyListener() {
		keyDown = new HashSet<>();
	}
	
	public boolean isKeyDown(int keyCode) {
		return keyDown.contains(keyCode);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyDown.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyDown.remove(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//Ignore
	}
	

}

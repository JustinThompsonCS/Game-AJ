import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyKeyListener implements KeyListener {
	Set<Integer> keyDown;
	
	static List<Integer> validKeyCodes = new ArrayList<>(Arrays.asList(KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_ESCAPE));
	
	public MyKeyListener() {
		keyDown = new HashSet<>();
	}
	
	public boolean isKeyDown(int keyCode) {
		if (!validKeyCodes.contains(keyCode)) return false;
		
		return keyDown.contains(keyCode);		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e);
		if (!validKeyCodes.contains(e.getKeyCode()))
			return;
					
		keyDown.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println(e);
		if (!validKeyCodes.contains(e.getKeyCode()))
			return;

		keyDown.remove(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println(e);
		//Ignore
	}
	
	public String toString() {
		return keyDown.toString();
	}

}

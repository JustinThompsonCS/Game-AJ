
public class Game {
	
	public void update() {  //Updates variables and runs methods
		long startTime = System.currentTimeMillis();
		/*
		 * Do update stuff
		 */
		long endTime = System.currentTimeMillis();
		while (endTime - startTime < 5) { endTime = System.currentTimeMillis(); }		
	}
	
}

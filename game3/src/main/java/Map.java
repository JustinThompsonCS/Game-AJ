
public class Map {
	private int mapWidth;
	private int mapHeight;
	Room[][] rooms;
	
	public Map(int level, Block[][] blocks) {
		mapWidth = 5;
		mapHeight = 5;
		rooms = new Room[mapWidth][mapHeight];
		for (int i = 0; i < rooms.length; i++) {
			for (int k = 0; k < rooms[0].length; k++) {
				rooms[i][k] = new Room(level, blocks); 
			}
		}
	}
	
	public Room getRoom(int x, int y) {
		return rooms[x][y];
	}

	public int getWidth() {
		return mapWidth;
	}
	
	public int getHeight() {
		return mapHeight;
	}
}

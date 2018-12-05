
public class Map {
	private int mapWidth;
	private int mapHeight;
	Room[][] rooms;
	
	public Map(int level) {
		mapWidth = 5;
		mapHeight = 5;
		rooms = new Room[mapWidth][mapHeight];
		for (int i = 0; i < rooms.length; i++) {
			for (int k = 0; k < rooms[0].length; k++) {
				rooms[i][k] = new Room(level); 
			}
		}
	}
	
	public Room getRoom(int x, int y) {
		return rooms[x][y];
	}

	public int getMapWidth() {
		return mapWidth;
	}
	
	public int getMapHeight() {
		return mapHeight;
	}
}

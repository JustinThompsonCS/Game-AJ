import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public class Room {
	RoomObject[][] objects;
	int level;
	
	public Room(int level, Block[][] b) {
		this.level = level;
		objects = b;
	}
	
	public void draw(Graphics g, Dimension screenSize) {
		//TODO Use an actual background image (we need background images first though lol)
		g.setColor(Color.black);
		int x = (int) (screenSize.getWidth() - screenSize.getHeight()) / 2;
		g.fillRect(x, 0, (int)screenSize.getHeight(), (int)screenSize.getHeight());
		for (RoomObject[] objRow: objects) 
			for (RoomObject obj: objRow)
				obj.update(g);
	}

	public Block[] getBlocks() {
		ArrayList<Block> blocks = new ArrayList<>();
		for (RoomObject[] objRow: objects)
			for (RoomObject obj: objRow)
				if (obj.getClass().equals(Block.class))
					blocks.add((Block)obj);
		Block[] blocksArr = new Block[blocks.size()];
		for (int i = 0; i < blocks.size(); i++)
			blocksArr[i] = blocks.get(i);
		return blocksArr;
	}
}

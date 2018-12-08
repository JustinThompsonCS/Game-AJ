import java.awt.Rectangle;

public class lineChecker {
	Line[] lines;
	Rectangle[] rects;
			
	public lineChecker(Rectangle[] rs) {
		rects = rs;
		
		lines = new Line[rects.length * 4];
			int k = 0;
		for(int i = 0; i < rects.length; i++) {
			for(int j = 0; j < 4; j++) {
				if(j == 0) {
					lines[k].x1 = rects[i].x;
					lines[k].y1 = rects[i].y;
					lines[k].x2 = rects[i].x + rects[i].width;
					lines[k].y2 = rects[i].y;
				}
				
				
				k++;
			}
		}
		
		
	}
	
	
	
}

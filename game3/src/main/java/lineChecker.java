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
					lines[k] = new Line(rects[i].x, rects[i].y, rects[i].x + rects[i].width, rects[i].y);
				}
				if(j == 1) {
					lines[k] = new Line(rects[i].x + rects[i].width, rects[i].y, rects[i].x + rects[i].width, rects[i].y + rects[i].height);
				}
				if(j == 2) {
					lines[k] = new Line(rects[i].x + rects[i].width, rects[i].y + rects[i].height, rects[i].x, rects[i].y + rects[i].height);
				}
				if(j == 3) {
					lines[k] = new Line(rects[i].x, rects[i].y + rects[i].height, rects[i].x, rects[i].y);
				}
				k++;
			}
			
		}
		
		
	}
	
	
	
}

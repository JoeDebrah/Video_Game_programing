package com.main;

////If all zombies are dead and main character overlaps 
////this door, assuming they are not on level six, they
////move to the next level
//
////RECTANGLES ALWAYS FOLLOW YOU, SO REDEFINE IT WITH AN IMAGELOADER OR IMAGE ICON
//
//public class Door extends Rect {
//	Image tile;
//	int tilecount;
//	public Door(int x, int y, String tilefile) {
//		
//		super(x, y, 16,16);
//		
//			tile = Toolkit.getDefaultToolkit().getImage(tilefile + ".png");		
//	}
//	
//	public void draw(Graphics g)
//	{
//		g.drawImage(tile, x, y, w, h, null);
//	}
//}
import java.awt.*;

public class GameObjects extends Rect {
	Image image;

	// Screen Dimensions specifications are below
	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	// width will store the width of the screen in the
	// setSize function in the init() method
	int width = (int) size.getWidth();
	// height will store the height of the screen in the
	// setSize function in the init() method
	int height = (int) size.getHeight();

	public GameObjects(int x, int y, int w, int h, String filename) {
		super(x, y, w, h);
		image = Toolkit.getDefaultToolkit().getImage(filename);
	}

	public boolean overlapBottomPanel() {
		return (y > height - 117);
	}

	public int stopatBottomPanel() {
		setVelocity(0, 0);
		return (y = height - 117);
	}

	public void draw(Graphics g) {

		g.drawImage(image, x - Camera.x, y - Camera.y, 31*2, 47*2,  null);

		g.drawImage(image, x - Camera.x, y - Camera.y, 31*2, 47*2, null);

		// g.drawRect(x, y, w, h);
	}

}

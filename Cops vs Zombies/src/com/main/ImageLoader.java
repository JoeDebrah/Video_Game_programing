package com.main;
import java.awt.*;
import javax.swing.JFrame;

public class ImageLoader {
	int x;
	int y;
	
	Image image;
	
	// Screen Dimensions specifications are below
	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	// width will store the width of the screen in the
	// setSize function in the init() method
	int width = (int) size.getWidth();
	// height will store the height of the screen in the
	// setSize function in the init() method
	int height = (int) size.getHeight();

	int w = width;
	int h = height;

	public ImageLoader(int x, int y, String filename) {
		this.x = x;
		this.y = y;
		this.image = Toolkit.getDefaultToolkit().getImage(filename);
		
	}
	
	public void moveLeft(double dx) {
		x -= dx;
	}

	public void moveRight(double dx) {
		x += dx;
	}
	
	public void stop() {
		x = x;
	}

	public boolean overlaps(Rect r) {
		return (x + w >= r.x) && (r.x + r.w >= x) && (r.y + r.h >= y) && (y + h >= r.y);
	}

	public void draw(Graphics g) {
		g.drawImage(image, x, y, w, h, null);
		g.drawImage(image, x, y, w, h, null);
	}

}
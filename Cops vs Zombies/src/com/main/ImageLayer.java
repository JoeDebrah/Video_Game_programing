package com.main;
import java.awt.*;

public class ImageLayer {
	Image image;

	int depth;

	static double zoom = 1;

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
	static int x;
	static int y;
	static double speed;

	public ImageLayer(int x, int y, String filename, int depth) {
		// this.speed = speed;
		this.x = x;
		this.y = y;
		this.image = Toolkit.getDefaultToolkit().getImage(filename);

		this.depth = depth;
	}

	// zooms into the background
	public void PlayerFocus(double f) {
		zoom = f;
	}

	public static void zoomIn(double dzoom) {
		zoom *= 1 + dzoom;
	}

	public static void zoomOut(double dzoom) {
		zoom /= 1 + dzoom;
	}

	public static void moveUp(int dy) {
		y -= dy;
	}

	public static void moveDown(int dy) {
		y += dy;
	}

	public static void moveLeft(double dx) {
		speed = dx;
		x -= speed;
	}

	public static void moveRight(double dx) {
		speed = dx;
		x += speed;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public void draw(Graphics g) {
		// Don't use. This is just experimental
		// g.drawImage(image, (int)((0 + i*240 - Camera.x / depth) * zoom), 0-Camera.y,
		// (int)(w*zoom), (int)(h*zoom), null);

		for (int i = 0; i < 1; i++) {

			g.drawImage(image, (int) ((0 + i * 720 - Camera.x / depth) * zoom), 0 - Camera.y, (int) (w * zoom),
					(int) (h * zoom), null);
			g.drawImage(image, (int) ((0 + i * 720 - Camera.x / depth) * zoom), 0 - Camera.y, (int) (w * zoom),
					(int) (h * zoom), null);

			// g.drawImage(image, 0 + i*720 - Camera.x / depth, 0-Camera.y, null);
		}
	}
}

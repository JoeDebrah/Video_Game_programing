package com.main;
import java.awt.*;

public class Platform extends Rect {
	Image[] tile = new Image[3];

	int tilecount;

	public Platform(int x, int y, int tilecount, String tilefile) {
		super(x, y, 16 * tilecount, 16);

		this.tilecount = tilecount;

		for (int i = 0; i < tile.length; i++)

			tile[i] = Toolkit.getDefaultToolkit().getImage(tilefile + (i + 1) + ".png");
	}

	public void draw(Graphics g) {
		g.drawImage(tile[0], x, y, 16, 16, null);

		for (int i = 1; i < tilecount - 1; i++)

			g.drawImage(tile[1], x + 16 * i, y, 16, 16, null);

		g.drawImage(tile[2], x + 16 * (tilecount - 1), y, 16, 16, null);
	}
}
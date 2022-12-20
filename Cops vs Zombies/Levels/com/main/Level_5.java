package com.main;

import java.awt.Graphics;
import java.util.Random;

public class Level_5 extends GameBase {
	boolean active = false;

	// Parallax Assets for Level 5
	ImageLoader background5a = new ImageLoader(0, 0, "background5.png");
	ImageLoader background5b = new ImageLoader(background5a.x + width, 0, "background5.png");
	ImageLoader midground5a = new ImageLoader(0, 0, "midground5.png");
	ImageLoader midground5b = new ImageLoader(midground5a.x + width, 0, "midground5.png");
	ImageLoader foreground5a = new ImageLoader(0, 0, "foreground5.png");
	ImageLoader foreground5b = new ImageLoader(foreground5a.x + width, 0, "foreground5.png");

	//needs work
	Zombie [] zombie = {
	new Zombie(((width) + (width*1) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*2) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*3) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*4) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*5) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*6) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*7) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*8) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*9) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*10) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*11) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*12) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*13) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*14) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*15) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*16) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*17) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*18) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*19) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*20) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*21) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*22) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*23) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*24) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*25) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*26) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*27) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*28) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*29) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*30) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*31) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*32) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*33) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*34) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*35) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*36) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*37) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*38) / 4), height - 200, 36*3, 58*3),
	new Zombie(((width) + (width*39) / 4), height - 200, 36*3, 58*3),
	};	
	
	public Level_5(GameBase game) {
		active = false;
	}

	public void inGameLoop() {
	}

	public void draw(Graphics g) {
		// Paint level 5 background
		background5a.draw(g);
		background5b.draw(g);
		midground5a.draw(g);
		midground5b.draw(g);
		foreground5a.draw(g);
		foreground5b.draw(g);

//draws the number of zombies based on how many zombies there are in each level
for (int i = 0; i < zombie.length; i++) {			
	zombie[i].draw(g);
}

	}

}
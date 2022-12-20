package com.main;

import java.awt.Graphics;
import java.util.Random;

public class Level_4 extends GameBase {
	boolean active = false;
	boolean reset = false;

	// Parallax Assets for Level 4
	ImageLoader background4a = new ImageLoader(0, 0, "background4.png");
	ImageLoader background4b = new ImageLoader(background4a.x + width, 0, "background4.png");
	ImageLoader midground4a = new ImageLoader(0, 0, "midground4.png");
	ImageLoader midground4b = new ImageLoader(midground4a.x + width, 0, "midground4.png");
	ImageLoader foreground4a = new ImageLoader(0, 0, "foreground4.png");
	ImageLoader foreground4b = new ImageLoader(foreground4a.x + width, 0, "foreground4.png");

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
	};	
	
	public Level_4(GameBase game) {
		active = false;
	}

	public void inGameLoop() {
	}

	public void draw(Graphics g) {
		// Paint level 4 background
		background4a.draw(g);
		background4b.draw(g);
		midground4a.draw(g);
		midground4b.draw(g);
		foreground4a.draw(g);
		foreground4b.draw(g);

	//draws the number of zombies based on how many zombies there are in each level
	for (int i = 0; i < zombie.length; i++) {			
		zombie[i].draw(g);
	}

	}

}
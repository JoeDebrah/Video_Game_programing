package com.main;
import java.awt.Graphics;

import java.util.Random;
//JANISSA'S CLASS PLEASE DONT TOUCH IF YOU HAVE QUESTIONS ASK//
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//

public class Level_1 extends GameBase{
	boolean active = false;

	// Parallax Assets for Level 1 - aka the background
	ImageLoader background1a = new ImageLoader(0, 0, "background1.png");
	ImageLoader background1b = new ImageLoader(background1a.x + width, 0, "background1.png");
	ImageLoader midground1a = new ImageLoader(0, 0, "midground1.png");
	ImageLoader midground1b = new ImageLoader(midground1a.x + width, 0, "midground1.png");
	ImageLoader foreground1a = new ImageLoader(0, 0, "foreground1.png");
	ImageLoader foreground1b = new ImageLoader(foreground1a.x + width, 0, "foreground1.png");
	
	
	//all the zombies and their placement on the map
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
};
	//meaning you need to activate and use it 
	public Level_1(GameBase game) {
		active = false;	
		}
	
	@Override
	public void inGameLoop() {	}
	
	public void draw(Graphics g) {
		
		background1a.draw(g);
		background1b.draw(g);
		midground1a.draw(g);
		midground1b.draw(g);
		foreground1a.draw(g);
		foreground1b.draw(g);
		
		
//draws the number of zombies based on how many zombies there are in each level
	for (int i = 0; i < zombie.length; i++) {			
		zombie[i].draw(g);
	}

			
	}
	
	
}


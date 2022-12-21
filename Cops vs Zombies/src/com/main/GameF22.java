package com.main;

/*
 * Yismel & Alexia 
 * new and revised bullets ...functionality soldier and bullet line 155-168 .. draw bullet line 838-843
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;

public class GameF22 extends GameBase {
	//first index of zombie
	int removeIndex = 0;
	// Health icon
	ImageIcon health = new ImageIcon("Health.png");
	Image image = health.getImage();
		
	Soldier soldier = new Soldier(width / 2, height - 280, 27*4, 51*4);	
	
	
	public void checkCollisions() {
//		//Collisions detection for soldier and zombies
//		for(int k=0; k<level1.zombie.length; k++) {
//		if(level1.zombie[k].overlaps(soldier)) {
//          Camera.moveLeft(27*4);
//		  soldier.setX(level1.zombie[k].x-soldier.h);  
//		  health_status=health_status-10; 
//		  		}	 }	  
	}
	
	//removes one zombie after he's killed
	public Zombie[] removeFirstElement(Zombie[] zombie) {
		Zombie[] newArr = new Zombie[zombie.length - 1];
        for (int i = 1; i < zombie.length; i++) {
            newArr[i-1] = zombie[i];
        }
        return newArr;
	}
	
	public void inGameLoop() {
		
		// Controls for Level 1
		if (levelCount == 1) {
			soldier.setAcceleration(0, 1);
			soldier.moveBasedOnPhysics();
		
			checkCollisions();
			
			//set the soldier to pose for gun
			  if(pressing[_S]) {
				  soldier.takeWeaponRT();
				  soldier.takeWeaponLT();
				  
				  soldier.fire();
				  }
			  else {	ArrayList bullets = soldier.getBullets();
					for(int i = 0; i < bullets.size(); i++) {
						
						Bullets m = (Bullets) bullets.get(i);
						if(m.getVisible()==true) {
						m.move();
						
				       	 
							}
						else  {for(int k=0; k<level1.zombie.length; k++) 
						if(m.overlaps(level1.zombie[k])) 
						level1.zombie[k].moveDead();
				        m.visible=false;
				        KillCount+=1;
						bullets.remove(i);	}
						
					}
			  }		  
			  
//making the zombies for the level - Janissa		
			for(int i = 0; i < level1.zombie.length; i++) {
				//creating the chase method
				level1.zombie[i].chase(soldier); //square brackets because of the array in lvl 1
//making the zombies movements be humanlike - Janissa
				level1.zombie[i].setAcceleration(0, 1);
				level1.zombie[i].moveBasedOnPhysics();
//making sure if the zombie overlaps theh soldier that the zombie will attack  - Janissa
				if(level1.zombie[i].overlaps(soldier)) {
					if (level1.zombie[i].x > soldier.x) { // the + and - is how far away need to be for the stuff in the if statement 
						level1.zombie[i].moveAttackLeft();	                	
	                }else 
	                if (level1.zombie[i].x < soldier.x) {
	                	level1.zombie[i].moveAttackRight();
	                }	 
				}
				
			//making sure the zombie doesnt fall through the map - Janissa
				// stop when he overlaps the ground/bottom the screen
				if (level1.zombie[i].overlapBottomPanel()) {
					level1.zombie[i].stopatBottomPanel();
				}
				// stop when he overlaps the top of the screen - Janissa
				if (level1.zombie[i].overlapTopPanel()) {
					level1.zombie[i].stopatTopPanel();
				}				
			}
				

			//Level complete screen
			if( soldier.overlaps(level1.door)) { 
			levelcomplete.active=true;
			levelcomplete.reset=true;
			}
			
			//Game over screen
			if(health_status==0 && running == true && levelPassed == false) { 
			gameover.active=true;
			gameover.reset=true;
			}
				
			//Resets all assets to the origin
			if(levelcomplete.reset || gameover.reset || pausemenu.reset || mainmenu.reset || gamecomplete.reset) { 
			soldier.reset();				Camera.reset();  
			levelcomplete.reset = false;	gameover.reset = false;
			pausemenu.reset = false;		mainmenu.reset = false;
			gamecomplete.reset = false;
			}
		 
			// stop when he overlaps the ground/bottom the screen
			if (soldier.overlapBottomPanel()) {
				soldier.stopatBottomPanel();
				if (pressing[UP])
					soldier.jump(20);
			}
			
			// stop when he overlaps the top of the screen
			if (soldier.overlapTopPanel()) {
				soldier.stopatTopPanel();
			}
			
			if(pressing[RT]) {
				Camera.moveRight(5);					soldier.moveRight(5); 
				level1.background1a.moveLeft(3);		level1.midground1a.moveLeft(5);		
				level1.foreground1a.moveLeft(7);		level1.background1b.moveLeft(3);
				level1.midground1b.moveLeft(5); 		level1.foreground1b.moveLeft(7);
			}
			
			//stop when he overlaps the left side of the screen 
			  if(pressing[LT] && Camera.x == 0)  { 
				Camera.stop(); 
				}	

			  else if (pressing[LT]) { 
				Camera.moveLeft(5); 		soldier.moveLeft(5);
				level1.background1a.moveRight(3);		level1.midground1a.moveRight(5);
				level1.foreground1a.moveRight(7);		level1.background1b.moveRight(3);
				level1.midground1b.moveRight(5);		level1.foreground1b.moveRight(7);
			  }	 		
			
			// Right Parallax scrolling instructions
			if (level1.background1a.x < 0 - width) { Random r = new Random();
				level1.background1a.x = width - r.nextInt(1);
			}
			if (level1.midground1a.x < 0 - width) {	Random r = new Random();
				level1.midground1a.x = width - r.nextInt(1);
			}
			if (level1.foreground1a.x < 0 - width) {	Random r = new Random();
				level1.foreground1a.x = width - r.nextInt(1);
			}
			if (level1.background1b.x < 0 - width) {	Random r = new Random();
				level1.background1b.x = width - r.nextInt(1);
			}
			if (level1.midground1b.x < 0 - width) {	Random r = new Random();
				level1.midground1b.x = width - r.nextInt(1);
			}
			if (level1.foreground1b.x < 0 - width) {	Random r = new Random();
				level1.foreground1b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (level1.background1a.x > 0 + width) {	Random r = new Random();
				level1.background1a.x = -width + r.nextInt(1);
			}
			if (level1.midground1a.x > 0 + width) {	Random r = new Random();
				level1.midground1a.x = -width + r.nextInt(1);
			}
			if (level1.foreground1a.x > 0 + width) {	Random r = new Random();
				level1.foreground1a.x = -width + r.nextInt(1);
			}
			if (level1.background1b.x > 0 + width) {		Random r = new Random();
				level1.background1b.x = -width + r.nextInt(1);
			}
			if (level1.midground1b.x > 0 + width) {			Random r = new Random();
				level1.midground1b.x = -width + r.nextInt(1);
			}
			if (level1.foreground1b.x > 0 + width) {		Random r = new Random();
				level1.foreground1b.x = -width + r.nextInt(1);
			}	
			
		}

	// Controls for Level 2
	if (levelCount == 2) {
			soldier.setAcceleration(0, 1);
			soldier.moveBasedOnPhysics();
			
checkCollisions();
			
			//set the soldier to pose for gun
			  if(pressing[_S]) {
				  soldier.takeWeaponRT();
				  soldier.takeWeaponLT();
				  
				  soldier.fire();
				  }
			  else {	ArrayList bullets = soldier.getBullets();
					for(int i = 0; i < bullets.size(); i++) {
						
						Bullets m = (Bullets) bullets.get(i);
						if(soldier.ready) {
						m.visible=true;
						m.move();}
						else  
						bullets.remove(i);	
						
						for(int k=0; k<level2.zombie.length; k++) {
						if(!(level2.zombie.length==0)) {
						if( m.overlaps(level2.zombie[removeIndex])) {
						level2.zombie[removeIndex].moveDead();
				        m.visible=false;
				        KillCount+=1;
				        Zombie[] newArr = removeFirstElement(level2.zombie);
				        System.out.println("Original length : " + level2.zombie.length);
				        System.out.println("New length : " + newArr.length);
				        level2.zombie = newArr;	}
						if(m.visible == false && m.overlaps(level2.zombie[removeIndex])) { 	}
						
						}	if(level2.zombie.length==0) {KillCount = 15;}	}
						
							
					}
			  }
			  
		//making the zombies for the level - Janissa		
			for(int i = 0; i < level2.zombie.length; i++) {
				//creating the chase method
				level2.zombie[i].chase(soldier); //square brackets because of the array in lvl 2  - Janissa
//making the zombies movements be humanlike - Janissa
				level2.zombie[i].setAcceleration(0, 1);
				level2.zombie[i].moveBasedOnPhysics();
	//making sure if the zombie overlaps theh soldier that the zombie will attack  - Janissa
				if(level2.zombie[i].overlaps(soldier)) {
					if (level2.zombie[i].x > soldier.x) { // the + and - is how far away need to be for the stuff in the if statement
						level2.zombie[i].moveAttackLeft();	                	
	                }else 
	                if (level2.zombie[i].x < soldier.x) {
	                	level2.zombie[i].moveAttackRight();
	                }
				}
			//making sure the zombie doesnt fall through the map - Janissa
				// stop when he overlaps the ground/bottom the screen
				if (level2.zombie[i].overlapBottomPanel()) {
					level2.zombie[i].stopatBottomPanel();
				}
				// stop when he overlaps the top of the screen
				if (level2.zombie[i].overlapTopPanel()) {
					level2.zombie[i].stopatTopPanel();
				}		
			}
			
			//Code to switch to the next level
			if(soldier.overlaps(level2.door)) {
				levelcomplete.active=true;
				levelcomplete.reset=true;
			}
			
			//Game over screen
			if(health_status==0 && running == true && levelPassed == false) { 
			gameover.active=true;
			gameover.reset=true;
			}
			
			//Resets all assets to the origin
			if(levelcomplete.reset || gameover.reset || pausemenu.reset || mainmenu.reset || gamecomplete.reset) { 
			soldier.reset();
			Camera.reset();
			levelcomplete.reset = false;
			gameover.reset = false;
			pausemenu.reset = false;
			mainmenu.reset = false;
			gamecomplete.reset = false;
			}

			// stop when he overlaps the ground/bottom the screen
			if (soldier.overlapBottomPanel()) {
				soldier.stopatBottomPanel();
				if (pressing[UP])
					soldier.jump(15);
			}

			// stop when he overlaps the top of the screen
			if (soldier.overlapTopPanel()) {
				soldier.stopatTopPanel();
			}

			// Keep soldier static(but still animated)
			if (pressing[DN])
				soldier.moveDown(5); // soldier.setVelocity(0, 0);
			  
			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);	soldier.moveRight(5); // soldier.setVelocity(0, 0);
				level2.background2a.moveLeft(3);	level2.midground2a.moveLeft(5);
				level2.foreground2a.moveLeft(7);	level2.background2b.moveLeft(3);
				level2.midground2b.moveLeft(5); 	level2.foreground2b.moveLeft(7);
			}
			
			//stop when he overlaps the left side of the screen 
			  if(pressing[LT] && Camera.x == 0)  { 
				Camera.stop(); 
				}
			  
			// Move Left, Keep soldier static(but still animated)
			  else if (pressing[LT]) {
				Camera.moveLeft(5); soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				level2.background2a.moveRight(3); level2.midground2a.moveRight(5);
				level2.foreground2a.moveRight(7); level2.background2b.moveRight(3);
				level2.midground2b.moveRight(5);  level2.foreground2b.moveRight(7);
			}

			// Right Parallax scrolling instructions
			if (level2.background2a.x < 0 - width) { Random r = new Random();
				level2.background2a.x = width - r.nextInt(1);
			}
			if (level2.midground2a.x < 0 - width) { Random r = new Random();
				level2.midground2a.x = width - r.nextInt(1);
			}
			if (level2.foreground2a.x < 0 - width) {	Random r = new Random();
				level2.foreground2a.x = width - r.nextInt(1);
			}
			if (level2.background2b.x < 0 - width) {	Random r = new Random();
				level2.background2b.x = width - r.nextInt(1);
			}
			if (level2.midground2b.x < 0 - width) {	Random r = new Random();
				level2.midground2b.x = width - r.nextInt(1);
			}
			if (level2.foreground2b.x < 0 - width) {	Random r = new Random();
				level2.foreground2b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (level2.background2a.x > 0 + width) {	Random r = new Random();
				level2.background2a.x = -width + r.nextInt(1);
			}
			if (level2.midground2a.x > 0 + width) {	Random r = new Random();
				level2.midground2a.x = -width + r.nextInt(1);
			}
			if (level2.foreground2a.x > 0 + width) {	Random r = new Random();
				level2.foreground2a.x = -width + r.nextInt(1);
			}
			if (level2.background2b.x > 0 + width) {	Random r = new Random();
				level2.background2b.x = -width + r.nextInt(1);
			}
			if (level2.midground2b.x > 0 + width) {	Random r = new Random();
				level2.midground2b.x = -width + r.nextInt(1);
			}
			if (level2.foreground2b.x > 0 + width) {	Random r = new Random();
				level2.foreground2b.x = -width + r.nextInt(1);
			}
		}

// Controls for Level 3
	if (levelCount == 3) {
			soldier.setAcceleration(0, 1);
			soldier.moveBasedOnPhysics();
			// soldier.setVelocity(0, 1);
			
checkCollisions();
			
			//set the soldier to pose for gun
			  if(pressing[_S]) {
				  soldier.takeWeaponRT();
				  soldier.takeWeaponLT();
				  
				  soldier.fire();
				  }
			  else {	ArrayList bullets = soldier.getBullets();
					for(int i = 0; i < bullets.size(); i++) {
						
						Bullets m = (Bullets) bullets.get(i);
						if(soldier.ready) {
						m.visible=true;
						m.move();}
						else  
						bullets.remove(i);	
						
						for(int k=0; k<level3.zombie.length; k++) {
						if(!(level3.zombie.length==0)) {
						if( m.overlaps(level3.zombie[removeIndex])) {
						level3.zombie[removeIndex].moveDead();
				        m.visible=false;
				        KillCount+=1;
				        Zombie[] newArr = removeFirstElement(level3.zombie);
				        System.out.println("Original length : " + level3.zombie.length);
				        System.out.println("New length : " + newArr.length);
				        level3.zombie = newArr;	}
						if(m.visible == false && m.overlaps(level3.zombie[removeIndex])) { 	}
						
						}	if(level3.zombie.length==0) {KillCount = 15;}	}
						
							
					}
			  }
			  
			
	//making the zombies for the level - Janissa		
			for(int i = 0; i < level3.zombie.length; i++) {
				//creating the chase method
				level3.zombie[i].chase(soldier); //square brackets because of the array in lvl 3  - Janissa
//making the zombies movements be humanlike - Janissa
				level3.zombie[i].setAcceleration(0, 1);
				level3.zombie[i].moveBasedOnPhysics();
//making sure if the zombie overlaps theh soldier that the zombie will attack  - Janissa
				if(level3.zombie[i].overlaps(soldier)) {
					if (level3.zombie[i].x > soldier.x) { // the + and - is how far away need to be for the stuff in the if statement
						level3.zombie[i].moveAttackLeft();	                	
	                }else 
	                if (level3.zombie[i].x < soldier.x) {
	                	level3.zombie[i].moveAttackRight();
	                }
				}
			//making sure the zombie doesnt fall through the map - Janissa
				// stop when he overlaps the ground/bottom the screen
				if (level3.zombie[i].overlapBottomPanel()) {
					level3.zombie[i].stopatBottomPanel();
				}
				// stop when he overlaps the top of the screen
				if (level3.zombie[i].overlapTopPanel()) {
					level3.zombie[i].stopatTopPanel();
				}
			}
			
			
			//Code to switch to the next level
			if(soldier.overlaps(level3.door)) {
				levelcomplete.active=true;
				levelcomplete.reset=true;
			}
			
			//Game over screen
			if(health_status==0 && running == true && levelPassed == false) { 
			gameover.active=true;
			gameover.reset=true;
			}
			
			//Resets all assets to the origin
			if(levelcomplete.reset || gameover.reset || pausemenu.reset || mainmenu.reset || gamecomplete.reset) { 
			soldier.reset();
			Camera.reset();
			levelcomplete.reset = false;
			gameover.reset = false;
			pausemenu.reset = false;
			mainmenu.reset = false;
			gamecomplete.reset = false;
			}

			// stop when he overlaps the ground/bottom the screen
			if (soldier.overlapBottomPanel()) {
				soldier.stopatBottomPanel();
				if (pressing[UP])
					soldier.jump(15);
			}

			// stop when he overlaps the top of the screen
			if (soldier.overlapTopPanel()) {
				soldier.stopatTopPanel();
			}

			// Keep soldier static(but still animated)
			if (pressing[DN])
				soldier.moveDown(5); // soldier.setVelocity(0, 0);

			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);	soldier.moveRight(5); // soldier.setVelocity(0, 0);
				level3.background3a.moveLeft(7); level3.midground3a.moveLeft(3);
				level3.foreground3a.moveLeft(7); level3.background3b.moveLeft(7);
				level3.midground3b.moveLeft(3);  level3.foreground3b.moveLeft(7);
			}

			//stop when he overlaps the left side of the screen 
			  if(pressing[LT] && Camera.x == 0)  { 
				Camera.stop(); 
				}
			  
			// Move Left, Keep soldier static(but still animated)
			  else if (pressing[LT]) {
				Camera.moveLeft(5);		soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				level3.background3a.moveRight(3);	level3.midground3a.moveRight(5);
				level3.foreground3a.moveRight(7);	level3.background3b.moveRight(3);
				level3.midground3b.moveRight(5);	level3.foreground3b.moveRight(7);
			}

			// Right Parallax scrolling instructions
			if (level3.background3a.x < 0 - width) {
				Random r = new Random();
				level3.background3a.x = width - r.nextInt(1);
			}
			if (level3.midground3a.x < 0 - width) {
				Random r = new Random();
				level3.midground3a.x = width - r.nextInt(1);
			}
			if (level3.foreground3a.x < 0 - width) {
				Random r = new Random();
				level3.foreground3a.x = width - r.nextInt(1);
			}
			if (level3.background3b.x < 0 - width) {
				Random r = new Random();
				level3.background3b.x = width - r.nextInt(1);
			}
			if (level3.midground3b.x < 0 - width) {
				Random r = new Random();
				level3.midground3b.x = width - r.nextInt(1);
			}
			if (level3.foreground3b.x < 0 - width) {
				Random r = new Random();
				level3.foreground3b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (level3.background3a.x > 0 + width) {
				Random r = new Random();
				level3.background3a.x = -width + r.nextInt(1);
			}
			if (level3.midground3a.x > 0 + width) {
				Random r = new Random();
				level3.midground3a.x = -width + r.nextInt(1);
			}
			if (level3.foreground3a.x > 0 + width) {
				Random r = new Random();
				level3.foreground3a.x = -width + r.nextInt(1);
			}
			if (level3.background3b.x > 0 + width) {
				Random r = new Random();
				level3.background3b.x = -width + r.nextInt(1);
			}
			if (level3.midground3b.x > 0 + width) {
				Random r = new Random();
				level3.midground3b.x = -width + r.nextInt(1);
			}
			if (level3.foreground3b.x > 0 + width) {
				Random r = new Random();
				level3.foreground3b.x = -width + r.nextInt(1);
			}
		}

		// Controls for Level 4
		if (levelCount == 4) {
			soldier.setAcceleration(0, 1);
			soldier.moveBasedOnPhysics();
			
checkCollisions();
			
			//set the soldier to pose for gun
			  if(pressing[_S]) {
				  soldier.takeWeaponRT();
				  soldier.takeWeaponLT();
				  
				  soldier.fire();
				  }
			  else {	ArrayList bullets = soldier.getBullets();
					for(int i = 0; i < bullets.size(); i++) {
						
						Bullets m = (Bullets) bullets.get(i);
						if(soldier.ready) {
						m.visible=true;
						m.move();}
						else  
						bullets.remove(i);	
						
						for(int k=0; k<level4.zombie.length; k++) {
						if(!(level4.zombie.length==0)) {
						if( m.overlaps(level4.zombie[removeIndex])) {
						level4.zombie[removeIndex].moveDead();
				        m.visible=false;
				        KillCount+=1;
				        Zombie[] newArr = removeFirstElement(level4.zombie);
				        System.out.println("Original length : " + level4.zombie.length);
				        System.out.println("New length : " + newArr.length);
				        level4.zombie = newArr;	}
						if(m.visible == false && m.overlaps(level4.zombie[removeIndex])) { 	}
						
						}	if(level4.zombie.length==0) {KillCount = 15;}	}
						
							
					}
			  }
			
		//making the zombies for the level - Janissa		
			for(int i = 0; i < level4.zombie.length; i++) {
				//creating the chase method
				level4.zombie[i].chase(soldier); //square brackets because of the array in lvl 4  - Janissa
//making the zombies movements be humanlike - Janissa
				level4.zombie[i].setAcceleration(0, 1);
				level4.zombie[i].moveBasedOnPhysics();
//making sure if the zombie overlaps theh soldier that the zombie will attack - Janissa
				if(level4.zombie[i].overlaps(soldier)) {
					if (level4.zombie[i].x > soldier.x) { // the + and - is how far away need to be for the stuff in the if statement
						level4.zombie[i].moveAttackLeft();	                	
	                }else 
	                if (level4.zombie[i].x < soldier.x) {
	                	level4.zombie[i].moveAttackRight();
	                }
				}
			//making sure the zombie doesnt fall through the map - Janissa
				// stop when he overlaps the ground/bottom the screen
				if (level4.zombie[i].overlapBottomPanel()) {
					level4.zombie[i].stopatBottomPanel();
				}
				// stop when he overlaps the top of the screen
				if (level4.zombie[i].overlapTopPanel()) {
					level4.zombie[i].stopatTopPanel();
				}
			}
			
			//Code to switch to the next level
			if( soldier.overlaps(level4.door)) {
				levelcomplete.active=true;
				levelcomplete.reset=true;
			}
			
			//Game over screen
			if(health_status==0 && running == true && levelPassed == false) { 
			gameover.active=true;
			gameover.reset=true;
			}
			
			//Resets all assets to the origin
			if(levelcomplete.reset || gameover.reset || pausemenu.reset || mainmenu.reset || gamecomplete.reset) { 
			soldier.reset();
			Camera.reset();
			levelcomplete.reset = false;
			gameover.reset = false;
			pausemenu.reset = false;
			mainmenu.reset = false;
			gamecomplete.reset = false;
			}
			

			// stop when he overlaps the ground/bottom the screen
			if (soldier.overlapBottomPanel()) {
				soldier.stopatBottomPanel();
				if (pressing[UP])
					soldier.jump(15);
			}

			// stop when he overlaps the top of the screen
			if (soldier.overlapTopPanel()) {
				soldier.stopatTopPanel();
			}

			// Keep soldier static(but still animated)
			if (pressing[DN])
				soldier.moveDown(5); // soldier.setVelocity(0, 0);

			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);		soldier.moveRight(5); // soldier.setVelocity(0, 0);
				level4.background4a.moveLeft(3);		level4.midground4a.moveLeft(5);
				level4.foreground4a.moveLeft(7);		level4.background4b.moveLeft(3);
				level4.midground4b.moveLeft(5);		level4.foreground4b.moveLeft(7);
			}

			//stop when he overlaps the left side of the screen 
			  if(pressing[LT] && Camera.x == 0)  { 
				Camera.stop(); 
				}
			  
			// Move Left, Keep soldier static(but still animated)
			  else if (pressing[LT]) {
				Camera.moveLeft(5);		soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				level4.background4a.moveRight(3);		level4.midground4a.moveRight(5);
				level4.foreground4a.moveRight(7);		level4.background4b.moveRight(3);
				level4.midground4b.moveRight(5);		level4.foreground4b.moveRight(7);
			}

			// Right Parallax scrolling instructions
			if (level4.background4a.x < 0 - width) {		Random r = new Random();
				level4.background4a.x = width - r.nextInt(1);
			}
			if (level4.midground4a.x < 0 - width) {		Random r = new Random();
				level4.midground4a.x = width - r.nextInt(1);
			}
			if (level4.foreground4a.x < 0 - width) {		Random r = new Random();
				level4.foreground4a.x = width - r.nextInt(1);
			}
			if (level4.background4b.x < 0 - width) {		Random r = new Random();
				level4.background4b.x = width - r.nextInt(1);
			}
			if (level4.midground4b.x < 0 - width) {		Random r = new Random();
				level4.midground4b.x = width - r.nextInt(1);
			}
			if (level4.foreground4b.x < 0 - width) {		Random r = new Random();
				level4.foreground4b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (level4.background4a.x > 0 + width) {		Random r = new Random();
				level4.background4a.x = -width + r.nextInt(1);
			}
			if (level4.midground4a.x > 0 + width) {		Random r = new Random();
				level4.midground4a.x = -width + r.nextInt(1);
			}
			if (level4.foreground4a.x > 0 + width) {		Random r = new Random();
				level4.foreground4a.x = -width + r.nextInt(1);
			}
			if (level4.background4b.x > 0 + width) {		Random r = new Random();
				level4.background4b.x = -width + r.nextInt(1);
			}
			if (level4.midground4b.x > 0 + width) {		Random r = new Random();
				level4.midground4b.x = -width + r.nextInt(1);
			}
			if (level4.foreground4b.x > 0 + width) {		Random r = new Random();
				level4.foreground4b.x = -width + r.nextInt(1);
			}
		}

	// Controls for Level 5
	if (levelCount == 5) {
			soldier.setAcceleration(0, 1);
			soldier.moveBasedOnPhysics();
			
			checkCollisions();
			
			//set the soldier to pose for gun
			  if(pressing[_S]) {
				  soldier.takeWeaponRT();
				  soldier.takeWeaponLT();
				  
				  soldier.fire();
				  }
			  else {	ArrayList bullets = soldier.getBullets();
					for(int i = 0; i < bullets.size(); i++) {
						
						Bullets m = (Bullets) bullets.get(i);
						if(soldier.ready) {
						m.visible=true;
						m.move();}
						else  
						bullets.remove(i);	
						
						for(int k=0; k<level5.zombie.length; k++) {
						if(!(level5.zombie.length==0)) {
						if( m.overlaps(level5.zombie[removeIndex])) {
						level5.zombie[removeIndex].moveDead();
				        m.visible=false;
				        KillCount+=1;
				        Zombie[] newArr = removeFirstElement(level5.zombie);
				        System.out.println("Original length : " + level5.zombie.length);
				        System.out.println("New length : " + newArr.length);
				        level5.zombie = newArr;	}
						if(m.visible == false && m.overlaps(level5.zombie[removeIndex])) { 	}
						
						}	if(level5.zombie.length==0) {KillCount = 15;}	}
						
							
					}
			  }
			  
		//making the zombies for the level - Janissa		
			for(int i = 0; i < level5.zombie.length; i++) {
				//creating the chase method
				level5.zombie[i].chase(soldier); //square brackets because of the array in lvl 5  - Janissa
//making the zombies movements be humanlike - Janissa
				level5.zombie[i].setAcceleration(0, 1);
				level5.zombie[i].moveBasedOnPhysics();
//making sure if the zombie overlaps theh soldier that the zombie will attack  - Janissa
				if(level5.zombie[i].overlaps(soldier)) {
					if (level5.zombie[i].x > soldier.x) { // the + and - is how far away need to be for the stuff in the if statement
						level5.zombie[i].moveAttackLeft();	                	
	                }else 
	                if (level5.zombie[i].x < soldier.x) {
	                	level5.zombie[i].moveAttackRight();
	                }
				}
			//making sure the zombie doesnt fall through the map - Janissa
				// stop when he overlaps the ground/bottom the screen
				if (level5.zombie[i].overlapBottomPanel()) {
					level5.zombie[i].stopatBottomPanel();
				}
				// stop when he overlaps the top of the screen
				if (level5.zombie[i].overlapTopPanel()) {
					level5.zombie[i].stopatTopPanel();
				}
			}
			
			
			//Code to switch to the next level
			if(soldier.overlaps(level5.door)) {
				levelcomplete.active=true;
				levelcomplete.reset=true;
			}
			
			//Game over screen
			if(health_status==0 && running == true && levelPassed == false) { 
			gameover.active=true;
			gameover.reset=true;
			}
			
			//Resets all assets to the origin
			if(levelcomplete.reset || gameover.reset || pausemenu.reset || mainmenu.reset || gamecomplete.reset) { 
			soldier.reset();
			Camera.reset();
			levelcomplete.reset = false;
			gameover.reset = false;
			pausemenu.reset = false;
			mainmenu.reset = false;
			gamecomplete.reset = false;
			}

			// stop when he overlaps the ground/bottom the screen
			if (soldier.overlapBottomPanel()) {
				soldier.stopatBottomPanel();
				if (pressing[UP])
					soldier.jump(15);
			}

			// stop when he overlaps the top of the screen
			if (soldier.overlapTopPanel()) {
				soldier.stopatTopPanel();
			}

			// Keep soldier static(but still animated)
			if (pressing[DN])
				soldier.moveDown(5); // soldier.setVelocity(0, 0);

			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);	soldier.moveRight(5); // soldier.setVelocity(0, 0);
				level5.background5a.moveLeft(3);	level5.midground5a.moveLeft(5);
				level5.foreground5a.moveLeft(7);	level5.background5b.moveLeft(3);
				level5.midground5b.moveLeft(5);		level5.foreground5b.moveLeft(7);
			}

			//stop when he overlaps the left side of the screen 
			  if(pressing[LT] && Camera.x == 0)  { 
				Camera.stop(); 
				}
			  
			// Move Left, Keep soldier static(but still animated)
			  else if (pressing[LT]) {
				Camera.moveLeft(5); 	soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				level5.background5a.moveRight(3);	level5.midground5a.moveRight(5);
				level5.foreground5a.moveRight(7);	level5.background5b.moveRight(3);
				level5.midground5b.moveRight(5);	level5.foreground5b.moveRight(7);
			}

			// Right Parallax scrolling instructions
			if (level5.background5a.x < 0 - width) {		Random r = new Random();
				level5.background5a.x = width - r.nextInt(1);
			}
			if (level5.midground5a.x < 0 - width) {		Random r = new Random();
				level5.midground5a.x = width - r.nextInt(1);
			}
			if (level5.foreground5a.x < 0 - width) {		Random r = new Random();
				level5.foreground5a.x = width - r.nextInt(1);
			}
			if (level5.background5b.x < 0 - width) {		Random r = new Random();
				level5.background5b.x = width - r.nextInt(1);
			}
			if (level5.midground5b.x < 0 - width) {		Random r = new Random();
				level5.midground5b.x = width - r.nextInt(1);
			}
			if (level5.foreground5b.x < 0 - width) {		Random r = new Random();
				level5.foreground5b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (level5.background5a.x > 0 + width) {		Random r = new Random();
				level5.background5a.x = -width + r.nextInt(1);
			}
			if (level5.midground5a.x > 0 + width) {		Random r = new Random();
				level5.midground5a.x = -width + r.nextInt(1);
			}
			if (level5.foreground5a.x > 0 + width) {		Random r = new Random();
				level5.foreground5a.x = -width + r.nextInt(1);
			}
			if (level5.background5b.x > 0 + width) {		Random r = new Random();
				level5.background5b.x = -width + r.nextInt(1);
			}
			if (level5.midground5b.x > 0 + width) {	Random r = new Random();
				level5.midground5b.x = -width + r.nextInt(1);
			}
			if (level5.foreground5b.x > 0 + width) {		Random r = new Random();
				level5.foreground5b.x = -width + r.nextInt(1);
			}
		}

		// Controls for Level 6
		if (levelCount == 6) {
			soldier.setAcceleration(0, 1);
			soldier.moveBasedOnPhysics();
			
checkCollisions();
			
			//set the soldier to pose for gun
			  if(pressing[_S]) {
				  soldier.takeWeaponRT();
				  soldier.takeWeaponLT();
				  
				  soldier.fire();
				  }
			  else {	ArrayList bullets = soldier.getBullets();
					for(int i = 0; i < bullets.size(); i++) {
						
						Bullets m = (Bullets) bullets.get(i);
						if(soldier.ready) {
						m.visible=true;
						m.move();}
						else  
						bullets.remove(i);	
						
						for(int k=0; k<level6.zombie.length; k++) {
						if(!(level6.zombie.length==0)) {
						if( m.overlaps(level6.zombie[removeIndex])) {
						level6.zombie[removeIndex].moveDead();
				        m.visible=false;
				        KillCount+=1;
				        Zombie[] newArr = removeFirstElement(level6.zombie);
				        System.out.println("Original length : " + level6.zombie.length);
				        System.out.println("New length : " + newArr.length);
				        level6.zombie = newArr;	}
						if(m.visible == false && m.overlaps(level6.zombie[removeIndex])) { 	}
						
						}	if(level6.zombie.length==0) {KillCount = 15;}	}
						
							
					}
			  } 
			  
			//making the zombies for the level - Janissa		
			for(int i = 0; i < level6.zombie.length; i++) {
				//creating the chase method
				level6.zombie[i].chase(soldier); //square brackets because of the array in lvl 6
//making the zombies movements be humanlike - Janissa
				level6.zombie[i].setAcceleration(0, 1);
				level6.zombie[i].moveBasedOnPhysics();
//making sure if the zombie overlaps theh soldier that the zombie will attack  - Janissa
				if(level6.zombie[i].overlaps(soldier)) {
					if (level6.zombie[i].x > soldier.x) { // the + and - is how far away need to be for the stuff in the if statement
						level6.zombie[i].moveAttackLeft();	                	
	                }else 
	                if (level6.zombie[i].x < soldier.x) {
	                	level6.zombie[i].moveAttackRight();
	                }
				}
			// making sure the zombie doesnt fall through the map - Janissa
				// stop when he overlaps the ground/bottom the screen
				if (level6.zombie[i].overlapBottomPanel()) {
					level6.zombie[i].stopatBottomPanel();
				}
				// stop when he overlaps the top of the screen
				if (level6.zombie[i].overlapTopPanel()) {
					level6.zombie[i].stopatTopPanel();
				}		
			}
			
			//Game complete screen
			if(  running == true && gameOver==false) { 
			if(soldier.overlaps(level6.door)) { 	
			gamecomplete.active=true;
			gamecomplete.reset=true;  }
			}
			
			//Game over screen
			if(health_status==0 && running == true && levelPassed == false) { 
			gameover.active=true;
			gameover.reset=true;
			}
			
			//Resets all assets to the origin
			if(levelcomplete.reset || gameover.reset || pausemenu.reset || mainmenu.reset || gamecomplete.reset) { 
			soldier.reset();
			Camera.reset();
			levelcomplete.reset = false;
			gameover.reset = false;
			pausemenu.reset = false;
			mainmenu.reset = false;
			gamecomplete.reset = false;
			}

			// stop when he overlaps the ground/bottom the screen
			if (soldier.overlapBottomPanel()) {
				soldier.stopatBottomPanel();
				if (pressing[UP])
					soldier.jump(15);
			}

			// stop when he overlaps the top of the screen
			if (soldier.overlapTopPanel()) {
				soldier.stopatTopPanel();
			}

			// Keep soldier static(but still animated)
			if (pressing[DN])
				soldier.moveDown(5); // soldier.setVelocity(0, 0);

			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);
				soldier.moveRight(5); // soldier.setVelocity(0, 0);
				level6.background6a.moveLeft(3);	level6.midground6a.moveLeft(5);
				level6.foreground6a.moveLeft(7);	level6.background6b.moveLeft(3);
				level6.midground6b.moveLeft(5); 	level6.foreground6b.moveLeft(7);
			}

			//stop when he overlaps the left side of the screen 
			  if(pressing[LT] && Camera.x == 0)  { 
				Camera.stop(); 
				}
			  
			// Move Left, Keep soldier static(but still animated)
			  else if (pressing[LT]) {
				Camera.moveLeft(5);
				soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				level6.background6a.moveRight(3);	level6.midground6a.moveRight(5);
				level6.foreground6a.moveRight(7);   level6.background6b.moveRight(3);
				level6.midground6b.moveRight(5);	level6.foreground6b.moveRight(7);
			}

			// Right Parallax scrolling instructions
			if (level6.background6a.x < 0 - width) { Random r = new Random();
				level6.background6a.x = width - r.nextInt(1);
			}
			if (level6.midground6a.x < 0 - width) {		Random r = new Random();
				level6.midground6a.x = width - r.nextInt(1);
			}
			if (level6.foreground6a.x < 0 - width) {	Random r = new Random();
				level6.foreground6a.x = width - r.nextInt(1);
			}
			if (level6.background6b.x < 0 - width) {		Random r = new Random();
				level6.background6b.x = width - r.nextInt(1);
			}
			if (level6.midground6b.x < 0 - width) {	Random r = new Random();
				level6.midground6b.x = width - r.nextInt(1);
			}
			if (level6.foreground6b.x < 0 - width) {		Random r = new Random();
				level6.foreground6b.x = width - r.nextInt(1);
			}

			// right Parallax scrolling instructions
			if (level6.background6a.x > 0 + width) {		Random r = new Random();
				level6.background6a.x = -width + r.nextInt(1);
			}
			if (level6.midground6a.x > 0 + width) {	Random r = new Random();
				level6.midground6a.x = -width + r.nextInt(1);
			}
			if (level6.foreground6a.x > 0 + width) {		Random r = new Random();
				level6.foreground6a.x = -width + r.nextInt(1);
			}
			if (level6.background6b.x > 0 + width) {	Random r = new Random();
				level6.background6b.x = -width + r.nextInt(1);
			}
			if (level6.midground6b.x > 0 + width) {		Random r = new Random();
				level6.midground6b.x = -width + r.nextInt(1);
			}
			if (level6.foreground6b.x > 0 + width) {		Random r = new Random();
				level6.foreground6b.x = -width + r.nextInt(1);
			}
		}

		
	}
	
	

	public void paint(Graphics g) {	
		
		if(levelCount==1) {level1.draw(g); }		
	
		if(levelCount==2) {level2.draw(g); }
		
		if(levelCount==3) {level3.draw(g); }
		
		if(levelCount==4) {level4.draw(g); }
		
		if(levelCount==5) {level5.draw(g); }
		
		if(levelCount==6) {level6.draw(g); }	
		
		//Main Menu
		if(mainmenu.active) { 
			mainmenu.draw(g);
			return;
		}
		
		//Pause Menu
		if(pausemenu.active) { 
			pausemenu.draw(g);
			return;
		}  
		
		//level complete
		if (levelcomplete.active) {
				levelcomplete.draw(g);
				return;
		}  

		//game over
		if (gameover.active) {
			gameover.draw(g);
			return;
		}
		
		//game over
		if (gamecomplete.active) {
			gamecomplete.draw(g);
			return;
		}
		
		soldier.draw(g);
			
		//bullet being drawn
		ArrayList bullets = soldier.getBullets();
		for(int i = 0; i < bullets.size(); i++) {
			Bullets m = (Bullets) bullets.get(i);
			g.drawImage(m.getImage(), m.getX(), m.getY(), null);
		}
						
		// Health bar needs work and is in progress
		Integer health = new Integer(health_status);
		String Healthval;
		Healthval = health.toString();
		
		//Temporary, Soldiers coordinates
		Integer soldierX = new Integer(soldier.x);
		String Solval;
		Solval = soldierX.toString();
		
		//Temporary, Camera's coordinates
		Integer cameraX = new Integer(Camera.x);
		String camval;
		camval = cameraX.toString();
		
		//Killcount coordinates
		Integer kill = new Integer(KillCount);
		String killcountVal;
		killcountVal = kill.toString();
		//killcount text
		String killcountText = "KILLCOUNT";
		
		g.setFont(getFont());
        g.setColor(Color.black);
		g.drawString(Solval, 100, 100);
		g.drawString(camval, 150, 100);
		g.drawString(killcountVal, 260, 100);
		g.drawString(killcountText, 190, 100);

		//draws health bar
		g.drawImage(image, 15, 80, 30, 30, null);
		//draws current health status
		g.drawString(Healthval, 50, 100);
	}
		
	
}					

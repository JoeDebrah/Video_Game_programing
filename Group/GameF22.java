
/*
 * Yismel & Alexia 
 * Added bullet line 23...functionality soldier and bullet line 113-119 .. draw line 825
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;

public class GameF22 extends GameBase {
	// Health icon
	ImageIcon health = new ImageIcon("Health.png");
	Image image = health.getImage();

	//needs more work
	Zombies zombie;
	Soldier soldier = new Soldier(width / 2, height - 280, 27*4, 51*4);
	
	//bullet size  
	Bullets bullet = new Bullets(775, 720, 27, 51);
	
	//in-game markers
	GameObjects rightarrow;
	GameObjects start = new GameObjects(100, 100, 434, 96, "start.png");
	GameObjects stop = new GameObjects(((width) + (width * ZombieCount) / 4),  100, 201, 191, "end.png");
	GameObjects door = new GameObjects(((width) + (width * ZombieCount) / 4), height - 200, 31*2, 47*2, "door.png");
	//experimental
	//GameObjects door = new GameObjects(width * 3, height - 200, 31*2, 47*2, "door.png");	

	public void inGameLoop() {
		
		// Controls for Level 1
		if (levelCount == 1) {
			soldier.setAcceleration(0, 1);
			soldier.moveBasedOnPhysics();
			
//			for(int i=0; i<test.length; i++) {
//			test[i].chase(soldier);
//			test[i].moveBasedOnPhysics();
//			}
  	
			//Level complete screen
			//This is currently incomplete
			//note use this for level complete --> KillCount==ZombieCount
			if(soldier.overlaps(door)) { 
			levelcomplete.active=true;
			levelcomplete.reset=true;
			}
			
			//Game over screen
			if(health_status==0 && running == true && levelPassed == false) { 
			gameover.active=true;
			gameover.reset=true;
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
		  
			/*
			 * //Set Boundaries stop when he overlaps the right side of the screen
			 * if(soldier.x + soldier.vx > ((width) + (width * ZombieCount) / 4)) {
			 * soldier.x = ((width) + (width * ZombieCount) / 4) ; }
			 */
	 

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
			  
			  
			  //set the soldier to pose for gun
			  if(pressing[_S]) {
				  soldier.takeWeaponRT();
				  soldier.takeWeaponLT();
				  
				  bullet.setVelocity(5, 0);
			  } 
			  bullet.moveBasedOnPhysics();
			
			
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
			// soldier.setVelocity(0, 1);

			//Code to switch to the next level
			if(soldier.overlaps(door)) {
				levelcomplete.active=true;
				levelcomplete.reset=true;
			}
			
			//Game over screen
			if(health_status==0 && running == true && levelPassed == false) { 
			gameover.active=true;
			gameover.reset=true;
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
			
			/*
			 * //Set Boundaries stop when he overlaps the right side of the screen
			 * if(soldier.overlapRightPanel()) { soldier.stopatRightPanel(); } 
			 */

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

			//stop when he overlaps the left side of the screen 
			  if(pressing[LT] && Camera.x == 0)  { 
				Camera.stop(); 
				}
			  
			// Keep soldier static(but still animated) and move right
			if (pressing[RT]) {
				Camera.moveRight(5);
				soldier.moveRight(5); // soldier.setVelocity(0, 0);
				level2.background2a.moveLeft(3);
				level2.midground2a.moveLeft(5);
				level2.foreground2a.moveLeft(7);
				level2.background2b.moveLeft(3);
				level2.midground2b.moveLeft(5);
				level2.foreground2b.moveLeft(7);
			}

			// Move Left, Keep soldier static(but still animated)
			if (pressing[LT]) {
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

			//Code to switch to the next level
			if(soldier.overlaps(door)) {
				levelcomplete.active=true;
				levelcomplete.reset=true;
			}
			
			//Game over screen
			if(health_status==0 && running == true && levelPassed == false) { 
			gameover.active=true;
			gameover.reset=true;
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
			
			/*
			 * //Set Boundaries stop when he overlaps the right side of the screen
			 * if(soldier.overlapRightPanel()) { soldier.stopatRightPanel(); }
			 */

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
			if (pressing[LT]) {
				Camera.moveLeft(5);
				soldier.moveLeft(5); // soldier.setVelocity(0, 0);
				level3.background3a.moveRight(3);
				level3.midground3a.moveRight(5);
				level3.foreground3a.moveRight(7);
				level3.background3b.moveRight(3);
				level3.midground3b.moveRight(5);
				level3.foreground3b.moveRight(7);
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
			// soldier.setVelocity(0, 1);
			
			//Code to switch to the next level
			if(soldier.overlaps(door)) {
				levelcomplete.active=true;
				levelcomplete.reset=true;
			}
			
			//Game over screen
			if(health_status==0 && running == true && levelPassed == false) { 
			gameover.active=true;
			gameover.reset=true;
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
			
			/*
			 * //Set Boundaries stop when he overlaps the right side of the screen
			 * if(soldier.overlapRightPanel()) { soldier.stopatRightPanel(); }
			 */

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
			if (pressing[LT]) {
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
			
			//Code to switch to the next level
			if(soldier.overlaps(door)) {
				levelcomplete.active=true;
				levelcomplete.reset=true;
			}
			
			//Game over screen
			if(health_status==0 && running == true && levelPassed == false) { 
			gameover.active=true;
			gameover.reset=true;
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
			
			/*
			 * //Set Boundaries stop when he overlaps the right side of the screen
			 * if(soldier.overlapRightPanel()) { soldier.stopatRightPanel(); }
			 */

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
			if (pressing[LT]) {
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

			//Game complete screen
			if(KillCount==ZombieCount && running == true && gameOver==false) { 
			if(soldier.overlaps(door)) { 	
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
			
			/*
			 * //Set Boundaries stop when he overlaps the right side of the screen
			 * if(soldier.overlapRightPanel()) { soldier.stopatRightPanel(); }
			 */

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
			if (pressing[LT]) {
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
	
		//In game markers
		start.draw(g);
		stop.draw(g);
		door.draw(g);
		for(int i=0; i<ZombieCount; i++) {
		rightarrow = new GameObjects(((width) + (width * i) / 4), 100, 370, 447, "right arrow.png");
		rightarrow.draw(g);
		}
		
		
		soldier.draw(g);
		
		//bullet being drawn
		bullet.draw(g);
		
		
		// Health bar needs work and is in progress
		Integer health = new Integer(health_status);
		String val;
		val = health.toString();
		
		//Temporary, Soldiers coordinates
		Integer soldierX = new Integer(soldier.x);
		String Solval;
		Solval = soldierX.toString();
		
		//Temporary, Camera's coordinates
		Integer cameraX = new Integer(Camera.x);
		String camval;
		camval = cameraX.toString();
		g.drawString(Solval, 100, 100);
		g.drawString(camval, 150, 100);
		
		//draws health bar -- in progress
		//g.drawImage(image, 15, 15, 10, 10, null);
		
		//draws current health status -- in progress
		//g.drawString(val, 30, 24);
	}
		
	
}
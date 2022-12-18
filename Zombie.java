package com.main;
import java.awt.*;

//JANISSA'S CLASS PLEASE DONT TOUCH IF YOU HAVE QUESTIONS ASK//
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//



public class Zombie extends Rect {
	
	int health = 100;
	
	int vx = 0;
	int vy = 0;
	int ax = 0;
	int ay = 0;
	Animation[] Zombieanim;
	
	//Screen Dimensions specifications are below
	Dimension size= Toolkit.getDefaultToolkit().getScreenSize();
	// width will store the width of the screen in the 
	//setSize function in the init() method
	int width = (int)size.getWidth();
	// height will store the height of the screen in the 
	//setSize function in the init() method
	int height = (int)size.getHeight();
	
	static final int ATTACKLT = 0;
	static final int DEAD = 1;
	static final int ZLT = 2;
	static final int ZRT = 3;
	static final int ATTACKRT = 4;
	
	int zombiePose = ZLT;
	
   boolean zombieMoving = false;
	
	
	public Zombie(int x, int y, int w, int h){
		super(x, y, w, h);
		Zombieanim = new Animation[5];
		
		String[] zombiePose = {"attacklt", "dead", "lt", "rt", "attackrt"};
		
		for(int i = 0; i < Zombieanim.length; i++){
			Zombieanim[i] = new Animation("z_" + zombiePose[i] +"_", 9, ".png", 10);
		}	
	}
	
	//chase method so he goes after kirby
    public void chase(Soldier soldier) {

        int xdiff = (Math.abs(x - soldier.x));
        int ydiff = (Math.abs(y - soldier.y));

        //you can set specific velocity and stuff in here
        if((ydiff < 400)&& (xdiff< 500)) { // if i make it 300 pix away he'll stop chasing 
        //if my x is bigger than Soldier x move me to the left
            if(xdiff > 10) 
                if (x > soldier.x) { // the + and - is how far away need to be for the stuff in the if statement
                    moveAttackLeft();
                	moveLeft(1);
                }else 
                if (x < soldier.x) {
                	moveAttackRight();
                    moveRight(1);
                }
            }
        }// closes chase method

   
    
	public void setVelocity(int vx, int vy){
		this.vx = vx;
		this.vy = vy;
	}
	
	public void setAcceleration(int ax, int ay){
		this.ax = ax;
		this.ay = ay;
	}
	
	public void moveBasedOnPhysics(){
		x += vx;
		y += vy;
		
		vx += ax;
		vy += ay;
	}
	
	public void moveLeft(int dx){
		vx = -dx;
		//x -= dx;
		zombiePose = ZLT;
		zombieMoving = true;
	}
	
	public void moveRight(int dx){
		vx = dx;
		//x += dx;
		
		zombiePose = ZRT;
		zombieMoving = true;
	}
	
	public void moveAttackLeft(){
		zombiePose = ATTACKLT;
		zombieMoving = true;
	}
	public void moveAttackRight(){
		zombiePose = ATTACKRT;
		zombieMoving = true;
	}
	public void moveDead()
	{
		zombiePose = DEAD;
		zombieMoving = true;
	}
	
	public boolean overlapLeftPanel() {
		return (x + vx < 0);	
	}
	
	public boolean overlapRightPanel() {
		return (x + vx > width-20);
	}
	public boolean overlapTopPanel() {
		return(y < 5);	
	}
	
	public boolean overlapBottomPanel() {
	    return (y > height-280);
	}
	
	public int stopatLeftPanel() {
		return (x = 0);	
	}
	
	public int stopatRightPanel() {
		return (x = width-20-1); 
	}
	public int stopatTopPanel() {
		return y = 5; 	
	}
	
	public int stopatBottomPanel() {
		setVelocity(0, 0);
		return (y = height-280);
	}	
	
	public void draw(Graphics g)
	{
		if(zombieMoving) {		
			g.drawImage(Zombieanim[zombiePose].currentImage(), x-Camera.x, y-Camera.y, 36*3, 58*3, null);
		}else {
			g.drawImage(Zombieanim[zombiePose].stillImage(), x-Camera.x, y-Camera.y, 36*3, 58*3, null);
		}
		
		zombieMoving = false;
		//g.drawRect(x, y, w, h);
	}
}
import java.awt.*;
import java.util.ArrayList;

//check line 35...and 50-60

public class Soldier extends Rect {
	
	// Screen Dimensions specifications are below
	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	// width will store the width of the screen in the
	// setSize function in the init() method
	int width = (int) size.getWidth();
	// height will store the height of the screen in the
	// setSize function in the init() method
	int height = (int) size.getHeight();

	int vx = 0;
	int vy = 0;

	int ax = 0;
	int ay = 0;
	Animation[] anim;
	
	static final int UP = 0;
	static final int DN = 1;
	static final int LT = 2;
	static final int RT = 3;

	static final int ATTACKLT = 4;
	static final int ATTACKRT = 5;
	int pose = RT;

	boolean moving = false;
	
	public static ArrayList bullets;
	


	public Soldier(int x, int y, int w, int h) {
		super(x, y, w, h);
		anim = new Animation[6];

		String[] pose = {"up", "dn","lt", "rt", "gunlt", "gunrt"};

		for (int i = 0; i < anim.length; i++) {
			anim[i] = new Animation("g_" + pose[i] + "_", 5, ".png", 10);
			
		}
		
		bullets = new ArrayList();
	}
	public void fire() {
		Bullets z = new Bullets(width/2 +53, height - 180);
		bullets.add(z);
	
	}
	
	public static ArrayList getBullets() {
		return bullets;
	}
	

	
	public void move() {
		this.vy = -vy;
	}

	public void jump(int vy) {
		this.vy = -vy;
	}


	public void setVelocity(int vx, int vy) {
		this.vx = vx;
		this.vy = vy;
	}

	public void setAcceleration(int ax, int ay) {
		this.ax = ax;
		this.ay = ay;
	}

	public void moveBasedOnPhysics() {
		x += vx;
		y += vy;

		vx += ax;
		vy += ay;
	}
	
	public void takeWeaponLT() {
		if(pose == LT) {
		pose = ATTACKLT;
		}
		moving = true;
	}

	public void takeWeaponRT() {
		if(pose == RT) {
		pose = ATTACKRT;
		}
		moving = true;
	}
	public void moveLeft(int dx) {
		vx = -dx;

		pose = LT;

		moving = true;
	}

	public void moveRight(int dx) {
		vx = dx;

		pose = RT;

		moving = true;
	}

	public void moveBy(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public boolean overlapLeftPanel() {
		return (x + vx < 0);
	}

	public boolean overlapRightPanel() {
		return (x + vx > width - 20);
	}

	public boolean overlapTopPanel() {
		return (y < 5);
	}

	public boolean overlapBottomPanel() {
		return (y > height - 280);
	}

	public int stopatLeftPanel() {
		return (x = 0);
	}

	public void stopatRightPanel() {
		 x = width - 20 - 1;
	}

	public int stopatTopPanel() {
		return y = 5;
	}

	public int stopatBottomPanel() {
		setVelocity(0, 0);
		return (y = height - 280);
	}
	
	//take back to origin
	public void reset() {
		x = width/2;
		y = height-200;
		pose = RT;
	}
	


	public void draw(Graphics g) {
		if (moving)
			g.drawImage(anim[pose].currentImage(), x - Camera.x, y - Camera.y, 27*4, 51*4, null);
		else
			g.drawImage(anim[pose].stillImage(), x - Camera.x, y - Camera.y, 27*4, 51*4,  null);


		moving = false;
		// g.drawRect(x, y, w, h);
	}
	
	

}
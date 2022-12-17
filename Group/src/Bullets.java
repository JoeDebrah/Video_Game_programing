import java.awt.Graphics;
/* 
 * Needs work 
 * -on multiplying the bullets
 * -setting it invisible
 * 
 */

public class Bullets extends Rect{

	int vx = 0;
	int vy = 0;
	
	static final int RT = 0;
	static final int LT = 1;
	
	int pose = LT;
	
	Animation [] anim;

	
	public Bullets(int x, int y, int w, int h) {
		super(x,y,w,h);
		anim = new Animation[2];
		
		String[] pose = {"lt", "rt"};
		
		for(int i = 0; i < anim.length; i++)
		{
			anim[i] = new Animation("bullet_" + pose[i] +"_",2, ".png", 10);
		}
	}

	public void setVelocity(int vx, int vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	public void moveBasedOnPhysics() {
		x += vx;
		y += vy;

		vx += ax;
		vy += ay;
	}

	public void draw(Graphics g) {
		
		g.drawImage(anim[pose].currentImage(), x, y, null);
		
	}
}


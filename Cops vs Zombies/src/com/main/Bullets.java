import java.awt.Image;
import javax.swing.ImageIcon;

public class Bullets {

	int x, y;
	int w, h;
	Image img;

	boolean visible;
	
	public Bullets(int x, int y) {
		this.x = x;
		this.y = y;
		
		
		ImageIcon newBullet = new ImageIcon("bullet_rt_0.png");
		
		img = newBullet.getImage();
		visible = true;
	}

	
	public void move() {
		x += 2;
		
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean getVisible() {
		return visible;
	}
	public Image getImage() {
		return img;
	}

}


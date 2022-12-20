package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMenu extends GameBase implements MouseListener   {

	public boolean active;
	public boolean reset;
	
	//button play
	private Rectangle playBtn;
	private String playTxt = "Play";
	//but ton play
	private Rectangle quitBtn;
	private String quitTxt = "Quit";
	private String optionTxt = "Main Menu";
	
	private Rectangle background;
	
	private Font font;
	
	public MainMenu (GameBase game) {
	active = true;
	game.start ();
	
	int BackW = 500; 
	int BackH = 500;
	int BackX = (width/2 - BackW/2);
 	int BackY = (height/2 - BackH/2);
	int w, h;
	w = 300;
	h = 150;
	
	background  = new Rectangle(BackX, BackY, BackW, BackH);
	playBtn = new Rectangle(BackX + BackW/5, BackY+ BackH/5, w, h);
	quitBtn = new Rectangle(BackX + BackW/5, BackY + BackH/2, w, h);	
	font  = new Font("Roboto", Font.BOLD, 80);

}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setFont(font);
		g.setColor(Color.black) ;
		g2d.fill(playBtn) ; 
		
		g.setColor(Color.black) ;
		g2d.fill(quitBtn); 
	
		g.setColor(Color.black) ;
		g2d.fill(background);
		
		g.setColor(Color.white) ;
		g2d.draw(background);
		g2d.draw(playBtn);
		g2d.draw(quitBtn);

		int strW = g.getFontMetrics(font).stringWidth(playTxt);
		int strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.green);
		g.drawString(playTxt, playBtn.x + (int)(playBtn.getWidth()/4) , playBtn.y + (int)(playBtn.getHeight()/2 + 30));
		
		g.setColor(Color.ORANGE);
		g.drawString(optionTxt, background.x + 50, background.y + 80);
		
		strW = g.getFontMetrics(font).stringWidth(quitTxt);
		strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.red);
		g.drawString(quitTxt, quitBtn.x + (int)(quitBtn.getWidth()/4) , quitBtn.y + (int)(quitBtn.getHeight()/2 + 30));
		
	}

	public void mouseClicked (MouseEvent e) {
	Point p =  e.getPoint ();
	if(active) {
	if (playBtn.contains(p)) {
	startGame();
	reset = true;
	active = false; 
	System.out.println("MainMenu startGame");}
	 
	if(quitBtn.contains(p)) {
	ExitGame();}
	}
	}
	
	public void mouseMoved(MouseEvent e) {	}

	public void mouseReleased(MouseEvent e) {  }

	public void mouseEntered(MouseEvent e) {  }

	public void mouseExited(MouseEvent e) {  }

	public void mousePressed(MouseEvent e) {  }

	public void inGameLoop() {	}
	
	
 }
	
	

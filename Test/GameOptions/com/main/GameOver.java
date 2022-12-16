package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameOver extends GameBase implements MouseListener{
	
	boolean active = false;
	boolean reset = false;
	
	//button play
	private Rectangle replayBtn;
	private String replayTxt = "Play Again";
	//button mainmenu
	private Rectangle mainBtn;
	private String mainTxt = "Main Menu";
	//button quit
	private Rectangle quitBtn;
	private String quitTxt = "Quit";
	
	private Rectangle background;
	
	private Font font;

	public GameOver(GameBase game) {
	active = false;
	
	int BackW = 500; 
	int BackH = 500;
	int BackX = (width/2 - BackW/2);
 	int BackY = (height/2 - BackH/2);
	int w, h;
	w = 300;
	h = 100;
	
	background  = new Rectangle(BackX, BackY, BackW, BackH);
	replayBtn = new Rectangle(BackX + BackW/5, BackY + 100, w, h);
	mainBtn = new Rectangle(BackX + BackW/5, BackY + 200, w, h);	
	quitBtn = new Rectangle(BackX + BackW/5, BackY + 300, w, h);	
	font  = new Font("Roboto", Font.BOLD, 50);
	
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setFont(font);
		g.setColor(Color.black) ;
		g2d.fill(replayBtn) ; 
		
		g.setColor(Color.black) ;
		g2d.fill(quitBtn); 
	
		g.setColor(Color.black) ;
		g2d.fill(background);
		
		g.setColor(Color.white) ;
		g2d.draw(background);
		g2d.draw(replayBtn);
		g2d.draw(quitBtn);
		g2d.draw(mainBtn);

		int strW = g.getFontMetrics(font).stringWidth(replayTxt);
		int strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.green);
		g.drawString(replayTxt, replayBtn.x + (int)(replayBtn.getWidth()/8) , replayBtn.y + (int)(replayBtn.getHeight()/2 + 30));
		
		strW = g.getFontMetrics(font).stringWidth(quitTxt);
		strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.red);
		g.drawString(quitTxt, quitBtn.x + (int)(quitBtn.getWidth()/4) , quitBtn.y + (int)(quitBtn.getHeight()/2 + 30));	
		
		strW = g.getFontMetrics(font).stringWidth(mainTxt);
		strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.blue);
		g.drawString(mainTxt, mainBtn.x + (int)(mainBtn.getWidth()/8) , mainBtn.y + (int)(mainBtn.getHeight()/2 + 30));	
		
	}

	//controls where you click and what they do
	public void mouseClicked(MouseEvent e) {
		
		Point p =  e.getPoint ();
		if(active) {
		if (replayBtn.contains(p)) {
		active = false;
		playAgain();
		reset=true;
		System.out.println("Gameover play again"); }
	
		if(mainBtn.contains(p)) {
		active=false; 
		mainmenu.active=true;
		reset=true;
		GoToMainMenu();
		System.out.println("Gameover main Menu"); }
		
		if (quitBtn.contains(p)) {
		ExitGame();
		System.out.println("Gameover quit"); }
		}
		
	}
	
	public void mouseMoved(MouseEvent e) { }
	
	@Override
	public void mousePressed(MouseEvent e) {  }

	@Override
	public void mouseReleased(MouseEvent e) {	}

	@Override
	public void mouseEntered(MouseEvent e) {	}

	@Override
	public void mouseExited(MouseEvent e) {		}

	@Override
	public void inGameLoop() {		}
	

}

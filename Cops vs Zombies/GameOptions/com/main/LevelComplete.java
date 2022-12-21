package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LevelComplete extends GameBase implements MouseListener{
	
	boolean active = false;
	boolean reset = false;
	boolean level = false;
	
	//button play
	private Rectangle playAgainBtn;
	private String playAgainTxt = "Play Again";
	//button next level
	private Rectangle nextLevelBtn;
	private String nextLevelTxt = "Next Level";
	//button main menu
	private Rectangle mainBtn;
	private String mainTxt = "Main Menu";
	//quit
	private Rectangle quitBtn;
	private String quitTxt = "Quit";
	
	private Rectangle background;
	
	private Font font;
	
	public LevelComplete(GameBase game) {
	active = false;
	
	int BackW = 500; 
	int BackH = 500;
	int BackX = (width/2 - BackW/2);
 	int BackY = (height/2 - BackH/2);
	int w, h;
	w = 300;
	h = 100;
	
	background  = new Rectangle(BackX, BackY, BackW, BackH);
	playAgainBtn = new Rectangle(BackX + BackW/5, BackY + 50, w, h);
	nextLevelBtn = new Rectangle(BackX + BackW/5, BackY + 150, w, h);
	mainBtn = new Rectangle(BackX + BackW/5, BackY + 250, w, h);	
	quitBtn = new Rectangle(BackX + BackW/5, BackY + 350, w, h);	
	font  = new Font("Roboto", Font.BOLD, 50);
	
	}
	
	public void levelcompleted() {
	level =! level;
	}
		
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setFont(font);
		g.setColor(Color.black) ;
		g2d.fill(playAgainBtn) ; 
		
		g.setColor(Color.black) ;
		g2d.fill(quitBtn); 
		
		g.setColor(Color.black) ;
		g2d.fill(mainBtn); 
		
		g.setColor(Color.black) ;
		g2d.fill(nextLevelBtn); 
	
		g.setColor(Color.black) ;
		g2d.fill(background);
		
		g.setColor(Color.white) ;
		g2d.draw(background);
		g2d.draw(playAgainBtn);
		g2d.draw(nextLevelBtn);
		g2d.draw(quitBtn);
		g2d.draw(mainBtn);

		int strW = g.getFontMetrics(font).stringWidth(playAgainTxt);
		int strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.green);
		g.drawString(playAgainTxt, playAgainBtn.x + (int)(playAgainBtn.getWidth()/8) , playAgainBtn.y + (int)(playAgainBtn.getHeight()/2 + 30));
		
		strW = g.getFontMetrics(font).stringWidth(quitTxt);
		strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.red);
		g.drawString(quitTxt, quitBtn.x + (int)(quitBtn.getWidth()/4) , quitBtn.y + (int)(quitBtn.getHeight()/2 + 30));	
		
		strW = g.getFontMetrics(font).stringWidth(mainTxt);
		strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.blue);
		g.drawString(mainTxt, mainBtn.x + (int)(mainBtn.getWidth()/8) , mainBtn.y + (int)(mainBtn.getHeight()/2 + 30));	
		
		strW = g.getFontMetrics(font).stringWidth(nextLevelTxt);
		strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.blue);
		g.drawString(nextLevelTxt, nextLevelBtn.x + (int)(mainBtn.getWidth()/8) , nextLevelBtn.y + (int)(nextLevelBtn.getHeight()/2 + 30));	
		
	}

	public void mouseMoved(MouseEvent e) { }

	public void mouseClicked(MouseEvent e) {
		
		Point p =  e.getPoint ();
		if(active) {
		if(playAgainBtn.contains(p)) {
		active = false;
		playAgain();
		System.out.println("levelcomplete playAgain"); }
		
		if(nextLevelBtn.contains(p)) {
		active=false;
		levelComplete();
		NextLevel();
		System.out.println("levelcount = "+levelCount);
		System.out.println("levelcomplete next level"); }
		
		//go to main menu from the level complete screen
		if(mainBtn.contains(p)) {
		active=false;
		mainmenu.active=true;
		GoToMainMenu();
		System.out.println("levelcomplete main menu"); }
		
		if(quitBtn.contains(p)) {
		ExitGame();
		System.out.println("levelcomplete exit Game"); }
		}

	}

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {	}

	@Override
	public void inGameLoop() {	}
	

}
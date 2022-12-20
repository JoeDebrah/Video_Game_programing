package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PauseMenu extends GameBase implements MouseListener, KeyListener {
	//boolean controls
	boolean active = false;
	boolean pausenow = false;
	boolean reset = false;
	
	//button play
	private Rectangle resumeBtn;
	private String resumeTxt = "Resume";
	//button mainmenu
	private Rectangle mainBtn;
	private String mainTxt = "Main Menu";
	//button quit
	private Rectangle quitBtn;
	private String quitTxt = "Quit";
	private String optionTxt = "Pause Menu";
	
	private Rectangle background;
	
	private Font font;
	

	public PauseMenu(GameBase game) {
	active = false;
	
	int BackW = 500; 
	int BackH = 500;
	int BackX = (width/2 - BackW/2);
 	int BackY = (height/2 - BackH/2);
	int w, h;
	w = 300;
	h = 100;
	
	background  = new Rectangle(BackX, BackY, BackW, BackH);
	resumeBtn = new Rectangle(BackX + BackW/5, BackY + 100, w, h);
	mainBtn = new Rectangle(BackX + BackW/5, BackY + 200, w, h);	
	quitBtn = new Rectangle(BackX + BackW/5, BackY + 300, w, h);	
	font  = new Font("Roboto", Font.BOLD, 50);
	
	}
	
	//toggle pause state
	public void pause() {
		pausenow=!pausenow;
	}
	
	//draw pause menu
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setFont(font);
		g.setColor(Color.black) ;
		g2d.fill(resumeBtn) ; 
		
		g.setColor(Color.black) ;
		g2d.fill(quitBtn); 
	
		g.setColor(Color.black) ;
		g2d.fill(background);
		
		g.setColor(Color.white) ;
		g2d.draw(background);
		g2d.draw(resumeBtn);
		g2d.draw(quitBtn);
		g2d.draw(mainBtn);

		int strW = g.getFontMetrics(font).stringWidth(resumeTxt);
		int strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.green);
		g.drawString(resumeTxt, resumeBtn.x + (int)(resumeBtn.getWidth()/4) , resumeBtn.y + (int)(resumeBtn.getHeight()/2 + 30));
		g.setColor(Color.ORANGE);
		g.drawString(optionTxt, background.x + (int)(background.getWidth()/4) , background.y + 50);
		
		strW = g.getFontMetrics(font).stringWidth(quitTxt);
		strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.red);
		g.drawString(quitTxt, quitBtn.x + (int)(quitBtn.getWidth()/4) , quitBtn.y + (int)(quitBtn.getHeight()/2 + 30));	
		
		strW = g.getFontMetrics(font).stringWidth(mainTxt);
		strH = g.getFontMetrics(font).getHeight();
		g.setColor(Color.blue);
		g.drawString(mainTxt, mainBtn.x + (int)(mainBtn.getWidth()/8) , mainBtn.y + (int)(mainBtn.getHeight()/2 + 30));	
		
		}


	public void mouseMoved(MouseEvent e) { }

	//controls where you click and what they do
	public void mouseClicked(MouseEvent e) {
		
		Point p =  e.getPoint ();
		if(active) {
		if(resumeBtn.contains(p)) {
		active = false; 
		resumeGame();
		System.out.println("pause Resume"); }
		
		//go to main menu
		if(mainBtn.contains(p)) {
		active=false;
		mainmenu.active=true;
		reset=true;
		GoToMainMenu();
		System.out.println("pause Main menu"); }
		
		//quit
		if(quitBtn.contains(p)) {
		ExitGame();
		System.out.println("pause menu Quit"); }
		}
		
		}

	public void keyPressed(KeyEvent e) {
		int Keys = e.getKeyCode();
		//controls when pause is activated
		if( isPaused==false && running==true && levelcomplete.active==false && 
		gamecomplete.active==false && gameover.active==false ) 
		if(Keys == KeyEvent.VK_ESCAPE) {
			pauseGame();
			active=true;
			pause();
			return;
		}
		
	}

	public void keyReleased(KeyEvent e) {	}

	@Override
	public void mousePressed(MouseEvent e) {		
	}

	@Override
	public void mouseReleased(MouseEvent e) {	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {		
	}
	
	@Override
	public void inGameLoop() {	}
	

}

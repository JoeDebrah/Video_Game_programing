package com.main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

public class Rect {
	
	int x;
	int y;

	int w;
	int h;

	int vx;
	int vy;
	int ax;
	int ay;

	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;

		this.w = w;
		this.h = h;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public void moveBy(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public void moveUp(int dy) {
		y -= dy;
	}

	public void moveDown(int dy) {
		y += dy;
	}

	public void moveLeft(int dx) {
		x -= dx;
	}

	public void moveRight(int dx) {
		x += dx;
	}

	public void move() {
		x += vx;
		y += vy;
	}

	public void setVelocity(int vx, int vy) {
		this.vx = vx;
		this.vy = vy;
	}

	public void setAcceleration(int ax, int ay) {
		this.ax = ax;
		this.ay = ay;
	}

	public void bounceOffVerticalSurface() {
		vx = -vx;
	}

	public void bounceOffHorizontalSurface() {
		vy = -vy;
	}
	
	//This will reset the main character back to its origin
	

	public void draw(Graphics g) {

		g.drawRect(x, y, w, h); 
	}

	public boolean overlaps(Rect r) {
		return (x + w >= r.x) && (r.x + r.w >= x) && (r.y + r.h >= y) && (y + h >= r.y);
	}

}
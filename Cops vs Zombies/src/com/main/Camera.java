package com.main;

public class Camera {
	static int x;
	static int y;
	static int z = 1;
//	static int originX = 0;
//	static int originY = 0;

	public static void moveUp(int dy) {
		y -= dy;
	}

	public static void moveDown(int dy) {
		y += dy;
	}

	public static void moveLeft(int dx) {
		x -= dx;
	}

	public static void moveRight(int dx) {
		x += dx;
	}

	public static void moveIn(int dz) {
		z -= dz;
	}

	public static void moveOut(int dz) {
		z += dz;
	}
	
	//This will reset the screen to the origin
	public static  void reset(){
		x = 0;
		y = 0;
	}
	
	//This will reset the screen to the origin
	public static  void stop(){
		x = x;
		y = y;
	}
	
	

}
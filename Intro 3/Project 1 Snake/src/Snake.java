import edu.du.dudraw.Draw;

public class Snake implements Comparable<Snake> {
	private int x;
	private int y;
	private double rad;
	private double xVel;
	private double yVel;

	// Snake constructor
	public Snake(int x, int y) {
		this.x = x;
		this.y = y;
		rad = 0.5;
		xVel = 0.5;
		yVel = 0;
	}

	// Adds the current xVel and yVel to the snake head 
	public void move() {
		x += xVel;
		y += yVel;
	}

	// decreases x value without changing y
	public void turnLeft() {
		xVel = -1;
		yVel = 0;
	}

	// increases x value without changing y
	public void turnRight() {
		xVel = 1;
		yVel = 0;
	}

	// increases y value without changing x
	public void turnUp() {
		yVel = 1;
		xVel = 0;
	}

	// decreases y value without changing x
	public void turnDown() {
		yVel = -1;
		xVel = 0;
	}

	// Stores which value of x or y is currently moving in
	public int direction() {
		if (xVel == -1 && yVel == 0) {
			return 1; // left
		} else if (xVel == 1 && yVel == 0) {
			return 2; // right
		} else if (xVel == 0 && yVel == 1) {
			return 3; // up
		} else if (xVel == 0 && yVel == -1) {
			return 4; // down
		}
		return 0;
	}

	// Draw the snake
	public void draw(Draw draw) {
		draw.setPenColor(0, 0, 0);
		draw.filledSquare(x, y, rad);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	public int compareTo(Snake o) {
		// TODO Auto-generated method stub
		return 1;
	}
}
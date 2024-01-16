import java.awt.Color;
import edu.du.dudraw.Draw; 

public class Food implements Comparable<Food>{
	
	private int x; 
	private int y; 
	private double rad;
	private Color color;
	
	//finds a random place to put a food object 
	public Food(int x, int y) {
		this.x = x;
		this.y = y; 
		rad = 0.5;
		color = new Color((int)(Math.random()*255), (int)(Math.random() *255), (int)Math.random()*255); 
	}
	
	public void draw(Draw draw) {
		draw.setPenColor(color); 
		draw.filledSquare(x, y, rad); 
	}
	
	public double getRad() {
		return rad; 
	}
	
	public void setRad(int rad) {
		this.rad = rad; 
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
	
	@Override
	public int compareTo(Food o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

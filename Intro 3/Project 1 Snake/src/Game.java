import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;
import java.util.LinkedList; 

public class Game implements DrawListener{
	
	//Stores snake and food objects in a linked list 
	private LinkedList<Snake> snake;
	private LinkedList<Food> food;
	
	private Draw draw;
	
	public Game() {
		
		draw = new Draw();
		
		draw.setCanvasSize(750, 750);
		draw.setXscale(0, 25);
		draw.setYscale(0, 25);
		
		//Create the head of the snake and start it in the middle of the screen
		snake = new LinkedList<>();
		snake.addLast(new Snake(12, 12));
		
		//Creates a food object randomly on the screen 
		food = new LinkedList<>();
		int x = (int)(Math.random()*20) + 1;
		int y = (int)(Math.random()*20) + 1;
		food.addLast(new Food(x, y));
		
		draw.enableDoubleBuffering();
		
		draw.addListener(this);
		
		draw.startUpdate();
	}
	
	//Draws a grid on the canvas 
	public void drawGrid() {
		draw.setPenColor(220, 220, 220);
		for(int i = 0; i < 25; i++) {
			draw.line(0.5 + i, 0, 0.5 + i, 25);
			draw.line(0, 0.5 + i, 25, 0.5 + i);
		}
	}
	
	//Erase the grid when the game is lost 
	public void emptyGrid() {
		draw.clear(255, 255, 255);
	}
	
	//Moves the snake around the screen
	public void moveSnake() {
		for(int i = snake.size()-1; i > 0; i--) {
			int oldX = snake.get(i-1).getX();
			int oldY = snake.get(i-1).getY();
			
			snake.get(i).setX(oldX);
			snake.get(i).setY(oldY);
		}
		snake.get(0).move();
	}
	
	//Player uses keys to move snake around 
	@Override
	public void keyTyped(char key) {
		if(!gameLost()) {	
			
			//Turns the snake left
			if((key == 'a' || key == 'A') && snake.get(0).direction() != 2) {   
				for(int i = 0; i < snake.size(); i++) {							
					snake.get(i).turnLeft();									
				}
			}
			
			//Turns the snake right
			else if((key == 'd' || key == 'D') && snake.get(0).direction() != 1) {
				for(int i = 0; i < snake.size(); i++) {
					snake.get(i).turnRight();
				}
			}
			
			//Turns the snake up
			else if((key == 'w' || key == 'W') && snake.get(0).direction() != 4) {
				for(int i = 0; i < snake.size(); i++) {
					snake.get(i).turnUp();
				}
			}
			
			//Turns the snake down
			else if((key == 's' || key == 'S') && snake.get(0).direction() != 3) {
				for(int i = 0; i < snake.size(); i++) {
					snake.get(i).turnDown();
				}
			}
		}
	}
	
	//snake eats the food when the head hits it, snake grows longer, new food appears
	private void eat() {
		for(int i = 0; i < food.size(); i++) {
			Food current = food.get(i);
			Snake head = snake.get(0);
			Snake tail = snake.get(snake.size() - 1);
			
			//Distance equation between the head and the food object
			double distance = Math.sqrt((head.getX()-current.getX())
					*(head.getX()-current.getX())
					+ (head.getY()-current.getY())
					* (head.getY()-current.getY()));
			
			if(distance < (head.getRad()+current.getRad())) {
				
				//add one food every time one gets eaten
				if(snake.size() < 5) {
					food.remove(i);
					snake.addLast(new Snake(tail.getX(), tail.getY()));
					food.addLast(randomFood());
				}
				
				//adds 2 food objects to make the game more fun 
				else if(snake.size() < 10) {
					food.remove(i);
					snake.addLast(new Snake(tail.getX(), tail.getY()));
					
					if(food.size() == 1) {
						food.addLast(randomFood());
					}
					else if(food.size() == 0) {
						food.addLast(randomFood());
						food.addLast(randomFood());
					}
				}
			}
		}
	}
	
	//checks whether the game has been lost 
	private boolean gameLost() {
		if(hitsWall() || hitsBody()) { 
			return true;
		}
		return false;
	}
	
	//Checks if the head of the snake hits it edge of the canvas
	public boolean hitsWall() {
		Snake head = snake.get(0);
		
		if(head.getX() + head.getRad() >= 25||
				head.getX() - head.getRad() <= 0 ||
				head.getY() + head.getRad() >= 25 ||
				head.getY() - head.getRad() <= 0) {
			return true;
		}
		return false;
	}
	
	//Checks if the head of the snake has hit another part of the snake body
	public boolean hitsBody() {
		Snake head = snake.get(0);
		int headX = head.getX();
		int headY = head.getY();
		
		for(int i = 2; i < snake.size(); i++) {
			Snake current = snake.get(i);
			double distance = Math.sqrt((headX-current.getX())
					*(headX-current.getX())
					+ (headY-current.getY())
					* (headY-current.getY()));
			
			if(distance < (head.getRad()+current.getRad())) {
				return true;
			}
		}
		return false;
	}
	
	//Generates a new SnakeFood at any random point
	public Food randomFood() {
		int x = (int)(Math.random()*20) + 1;
		int y = (int)(Math.random()*20) + 1;
		Food newFood = new Food(x, y);
		return newFood;
	}

	public void update() {
		draw.clear();
		drawGrid();
		
		if(!gameLost()) {
			for(int i = 0; i < snake.size(); i++) {
				snake.get(i).draw(draw);
			}
			
			for(int i = 0; i < food.size(); i++) {
				food.get(i).draw(draw);
			}
			
			moveSnake();
			eat();
		}
		
		else if(gameLost()) {
			emptyGrid();
			draw.setPenColor(0, 0, 0);
			String score = "" + (snake.size()-1);
			draw.text(12, 12, "Game Over! Score: " + score);
		}
		draw.pause(100);
		draw.show();
	}

	//unused methods
	@Override
	public void keyPressed(int arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(int arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(double arg0, double arg1) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(double arg0, double arg1) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(double arg0, double arg1) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(double arg0, double arg1) {
		// TODO Auto-generated method stub
	}

}
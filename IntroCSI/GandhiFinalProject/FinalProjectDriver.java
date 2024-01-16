/*
Assignment: Grid Clear
Sunjoi Gandhi 
Deadline: August 18, 2021
*/

import edu.du.dudraw.DUDraw;
import java.util.Scanner;

public class FinalProjectDriver {
   public static void main(String[] args) {
      System.out.println("Hello, welcome to Grid Clear!");
      System.out.println("Please select a difficulty: easy, medium, or hard");
      
      Scanner keyboard = new Scanner(System.in);
      String level = keyboard.next();
      int gridSize = 0;
      
      // reasks for level if user input is incorrect 
      while(!level.equals("easy") && !level.equals("medium") && !level.equals("hard"))  {
         System.out.println("Please select a difficulty: easy, medium, or hard"); 
         level = keyboard.next();
      }
      
      // creates grid size based on level
      if (level.equals("easy")) {
         gridSize = 3;
      }
      else if (level.equals("medium")) {
         gridSize = 4;
      }
      else if (level.equals("hard")) {
         gridSize = 5; 
      }
      
      long startTime = System.currentTimeMillis();
      
      GridClearGame gridClear = new GridClearGame(gridSize,gridSize);
      DUDraw.setCanvasSize(600,600);
      DUDraw.setXscale(0, gridSize);
      DUDraw.setYscale(0, gridSize);
      DUDraw.enableDoubleBuffering();
      int gameRounds = 0;
         
      while(gameRounds < 3) {
         gridClear.draw();
         if (DUDraw.getMouseReleased() > 0) {
            gridClear.handleMouse(DUDraw.mouseX(), DUDraw.mouseY());
         }
         if (gridClear.isCleared()) {
            gameRounds++;
            gridClear.randomize();
         }
         DUDraw.show();
      }
          
      // finding time it took to complete game
      long endTime = System.currentTimeMillis();
      long time = (endTime - startTime) / 1000;
       
      System.out.println("Finished");
      System.out.println("Your clear time was: " + time + " seconds.");
      
      System.exit(0);
   } 
}
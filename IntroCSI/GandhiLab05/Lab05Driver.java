/*
Assignment: Lab 05
Sunjoi Gandhi 
Deadline: July 9, 2021
*/

import edu.du.dudraw.DUDraw;

public class Lab05Driver {
   public static void main(String[] args) {
   
      int canvasSize = 600;
      double xCoord = canvasSize/2; 
      double yCoord = canvasSize/2;
      double speed = 1.0;
      DUDraw.setCanvasSize(600, 600);
      DUDraw.setXscale(0, 600);
      DUDraw.setYscale(0,600);
      
      while (true) {
         DUDraw.clear();
         DUDraw.filledCircle(xCoord, yCoord, 20);
         xCoord = xCoord + speed;   
         
         if (xCoord + 20 >= canvasSize) {
            speed = speed * -1.0;
            xCoord = xCoord + speed;
         } else if (xCoord -20 <= 0) {
            speed = speed * -1.0;
            xCoord = xCoord + speed;
         }
      }
   }
}
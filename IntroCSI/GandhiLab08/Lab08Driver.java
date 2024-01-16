/*
Assignment: Overlapping Shapes 
Sunjoi Gandhi
Deadline: July 21, 2021
*/

import edu.du.dudraw.DUDraw;

public class Lab08Driver {
   public static void main(String[] args) {
      
      DUDraw.setCanvasSize(600, 600);
      DUDraw.enableDoubleBuffering();
      DUDraw.setXscale(0, 600);
      DUDraw.setYscale(0,600);
      
      int canvasSize = 600;
      double xCoord = canvasSize/2; 
      double yCoord = canvasSize/2;
      double h = canvasSize/4;
      double x = canvasSize/6;
      double y = canvasSize/12;
      int radius = 20;
      double xVel = 10.0;
      double yVel = 8.0;
      
      while (true) {
         DUDraw.clear();
         DUDraw.setPenColor(DUDraw.YELLOW);
         DUDraw.filledSquare(xCoord, yCoord, h);
         boolean check = isPointInSquare(x, y, xCoord, yCoord, h);
         
         if (check == true) {
            DUDraw.setPenColor(DUDraw.GREEN);
         } else {
            DUDraw.setPenColor(DUDraw.BLUE);
         }
         
         DUDraw.filledCircle(x, y, radius);
         
         x += xVel; 
         y += yVel;

         if (x + 20 >= canvasSize || x - 20 <= 0) {
            xVel *= -1.0;
         } 
         if (y + 20 >= canvasSize || y - 20 <= 0) {
            yVel *= -1.0;
         }
         
      DUDraw.show(); 
      DUDraw.pause(100);
      }
   }
   public static boolean isPointInSquare(double xCirc, double yCirc, double xSquare, double ySquare, double halfLength) {
      if (xCirc >= xSquare - halfLength && yCirc >= ySquare - halfLength 
          && xCirc <= xSquare + halfLength && yCirc <= ySquare + halfLength) {
          return true; 
      }
      return false; 
   } 
  
}
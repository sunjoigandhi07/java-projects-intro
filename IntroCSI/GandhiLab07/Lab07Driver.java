/*
Assignment: Animated Figure
Sunjoi Gandhi
Deadline: July 16, 2021
The animation is done very poorly and I apologize for how janky it looks. 
*/

import edu.du.dudraw.DUDraw;

public class Lab07Driver {
   public static void main(String[] args) {
      
      double canvasSize = 1.0;
      double xCoord= 0.5;
      double yCoord= 0.5;
      double speed = 0.01;
      DUDraw.setCanvasSize(600, 600);
      
      while (true) {
         DUDraw.clear();
         fish(xCoord, yCoord);
         xCoord = xCoord - speed;
         yCoord = yCoord + speed;
         
         if(xCoord <=0) {
            xCoord = 0.8;
         } 
         if(yCoord >=1.0) {
            yCoord = 0.1;
         }
       
      DUDraw.pause(150);
      }
   }
   
   public static void fish(double x, double y) {
   
      DUDraw.setPenRadius(2);
      DUDraw.setPenColor(DUDraw.BLACK);
      DUDraw.triangle(x +0.05, y, x + 0.15, y + 0.1, x + 0.15, y - 0.1);
      DUDraw.setPenColor(DUDraw.ORANGE);
      DUDraw.filledTriangle(x + 0.05, y, x + 0.15, y + 0.1, x + 0.15, y- 0.1);
      DUDraw.filledEllipse(x, y, 0.08, 0.05);
      DUDraw.setPenRadius(1);
      DUDraw.setPenColor(DUDraw.BLACK);
      DUDraw.ellipse(x, y, 0.08, 0.05);
      
      DUDraw.filledCircle(x- 0.05, y, 0.01);
   
   
   }  
}
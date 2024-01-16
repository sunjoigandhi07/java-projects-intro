/*
*Assignment: Random Shape 
*Sunjoi Gandhi 
*Deadline: June 30, 2021
*/


import edu.du.dudraw.DUDraw;

public class Lab02Driver {
   public static void main(String[] args) {
   
   DUDraw.setCanvasSize(500, 500); 
   
   double randNum = Math.random();
   
   if (randNum >= 0 && randNum <= 0.25) {
      DUDraw.setPenColor(DUDraw.RED);
      DUDraw.filledCircle(0.5, 0.5, 0.2);
   } 
   else if (randNum >= 0.25 && randNum <= 0.5) {
      DUDraw.setPenColor(DUDraw.BLUE);
      DUDraw.filledRectangle(0.5, 0.5, 0.4, 0.2); 
   } 
   else if (randNum >= 0.5 && randNum <= 0.75) {
      DUDraw.setPenColor(DUDraw.GREEN);
      DUDraw.line(0.0, 0.0, 1.0, 1.0);
      DUDraw.line(0.0, 1.0, 1.0, 0.0);
   }
   else if (randNum >= 0.75 && randNum <= 1.0) {
      DUDraw.setPenColor(DUDraw.BLACK);
      DUDraw.circle(0.5, 0.5, 0.2); 
   }
   
   
   }
}
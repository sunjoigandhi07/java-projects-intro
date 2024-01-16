/*
Assignment: Drawing with DU
Sunjoi Gandhi
Deadline: July 8, 2021
*/

import edu.du.dudraw.DUDraw;

public class Drawing {
   public static void main(String[] args) {
   
   DUDraw.setCanvasSize(500, 500); 
   
   DUDraw.setPenColor(150, 0, 200);
   DUDraw.filledSquare(0.5, 0.5, 0.4);
   
   DUDraw.setPenColor(DUDraw.MAGENTA);
   DUDraw.filledCircle(0.2, 0.8, 0.2);
   DUDraw.filledCircle(0.8, 0.8, 0.2);
   
   DUDraw.setPenColor(DUDraw.BLACK);
   DUDraw.filledCircle(0.2, 0.8, 0.1);
   DUDraw.filledCircle(0.8, 0.8, 0.1);
   
   DUDraw.setPenColor(DUDraw.YELLOW);
   DUDraw.filledEllipse(0.5, 0.5, 0.2, 0.4);

   }
} 
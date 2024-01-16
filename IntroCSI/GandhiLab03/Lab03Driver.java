/*
Assignment: Concentric Squares
Sunjoi Gandhi
Deadline: July 2, 2021
*/

import edu.du.dudraw.DUDraw;

public class Lab03Driver {
   public static void main(String[] args) {
   
   DUDraw.setCanvasSize(500, 500); 
   DUDraw.setXscale(0, 1);
   DUDraw.setYscale(0, 1);
   
   double s = 0.05;
   
   for (int i = 0; i<10; i++) {
      
      DUDraw.setPenColor(DUDraw.MAGENTA);
      DUDraw.setPenRadius(1.5);
      DUDraw.square(0.5, 0.5, s);
   
      s += 0.035;
   }
   
   double x = 0.17;
   double y = 0.17;
   
   for (int c = 0; c<5; c++) {
   
      DUDraw.setPenColor(DUDraw.BLACK);
      DUDraw.setPenRadius(1.5);
      DUDraw.circle(x, 0.08, 0.03);
      DUDraw.circle(x, 0.92, 0.03);
      DUDraw.circle(0.08, y, 0.03);
      DUDraw.circle(0.92, y, 0.03);
      
      x += 0.17;
      y += 0.17;
   }
      
      
   }
} 
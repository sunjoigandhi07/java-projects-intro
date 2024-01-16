/*
Assignment: Enter the Matrix
Sunjoi Gandhi
Deadling: August 9, 2021
*/

import edu.du.dudraw.DUDraw;

public class Lab13Driver {
   public static void main(String[] args) {
   
      NumberGrid matrix = new NumberGrid(6,6);
   
      DUDraw.setCanvasSize(600,600);
      DUDraw.setXscale(0,6);
      DUDraw.setYscale(0,6);
      DUDraw.enableDoubleBuffering();
      
      
      while(true) {
         DUDraw.clear(DUDraw.BLACK);
         DUDraw.setPenColor(DUDraw.MAGENTA); 
         
         matrix.draw();
         matrix.randomize(0.2);
         
         DUDraw.show();
         DUDraw.pause(150); 
      }
   }
}
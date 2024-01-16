/*
Assignment: Fading Stars
Sunjoi Gandhi 
Deadling: August 4, 2021
*/

import edu.du.dudraw.DUDraw;

public class Lab12Driver {
   public static void main(String[] args) {
   
      Star[] stars = new Star[50]; 
      for (int i = 0; i < stars.length; i++) {
         stars[i] = new Star();
      }
      
      DUDraw.setCanvasSize(500, 500);
      DUDraw.enableDoubleBuffering();
      
      while(true) {
         DUDraw.clear(0,0,0);
        
         for (int i = 0; i < stars.length; i++) {
            stars[i].fade();
            stars[i].draw(); 
            
         }
      
         DUDraw.pause(150);
         DUDraw.show();
      }
   
   }
}
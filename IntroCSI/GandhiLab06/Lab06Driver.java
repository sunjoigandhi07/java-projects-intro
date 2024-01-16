/*
Assignment: Debugging
Sunjoi Gandhi 
Deadline: July 14, 2021
*/

import edu.du.dudraw.DUDraw;

public class Lab06Driver {
   public static void main(String[] args) {
   
      DUDraw.setCanvasSize(500, 500); 
      DUDraw.setPenRadius(2); 
      
      double radius = 0.02;
      /* changed the variable type from integer to double
         because it is assigned a decimal */
      double radiusStep = 0.02;
      
      int red = 225;
      int blue = 0;
      int colorStep = 6;
      
      while (true) {
         DUDraw.setPenColor(red, 0, blue);
         DUDraw.circle(0.5, 0.5, radius); 
         
         radius += radiusStep;
         /* changed the + to - because red starts at the 255,
         which is the largest integer color can start at */ 
         red -= colorStep;
         /* changed the - to + because blue starts at 0, 
         and color integers cannot go negative */ 
         blue += colorStep;
         
         /* adding curly braces to the if statement because 
         it will not run the code inside without them &
         changing the sign from < to > so a larger circle
         will be drawn*/
         if (radius > 0.75) {
            radius = 0.02;
            red = 255; 
            blue = 0;
         } 
      DUDraw.pause(150);
      }
   
   }
}
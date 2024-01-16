/*
Assignment: Fading Stars
Sunjoi Gandhi 
Deadling: August 4, 2021
*/

import edu.du.dudraw.DUDraw;

public class Star {

   private double xCoord;
   private double yCoord;
   private double radius;
   private int brightness;
   
   public Star() {
      this.xCoord = Math.random();
      this.yCoord = Math.random();
      this.radius = Math.random() * 0.02 + 0.01;
      this.brightness = (int)(Math.random()*256);
   }
   
   public void fade() {
      
      for(int i = 0; i < 1000000; i++) {
         this.brightness -= 20;
   
         if(this.brightness <=  0) {
            this.brightness += 255;
         }
      }
   }
   
   public void draw() {
      DUDraw.setPenColor(this.brightness, this.brightness, this.brightness);
      DUDraw.filledCircle(xCoord, yCoord, radius);
   } 
} 
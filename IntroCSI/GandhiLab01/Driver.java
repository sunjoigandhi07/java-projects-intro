/* Lab 01- Random Cirlce 
Sunjoi Gandhi 
Deadline: June 24, 2021*/

import edu.du.dudraw.DUDraw;

public class Driver {
   public static void main(String[] args) {
   
   DUDraw.setCanvasSize(500, 500);  
   
   double xCoord = Math.random();
   double yCoord = Math.random(); 
   double radNum = Math.random() *0.2 + 0.1;
     
   DUDraw.setPenColor(DUDraw.MAGENTA);
   DUDraw.filledCircle(xCoord, yCoord, radNum);  
   
   DUDraw.setPenColor(DUDraw.BLACK); 
   DUDraw.text(0.5, 0.95, "Random Circle"); 
   
   }
}
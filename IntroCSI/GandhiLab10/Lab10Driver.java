/* 
Assignment: Keyboard & Mouse Input with DUDraw
Student Name: Sunjoi Gandhi
Deadline: July 28, 2021
*/

import edu.du.dudraw.DUDraw;

public class Lab10Driver {
   public static void main(String[] args) {
   
      DUDraw.setCanvasSize(500, 500);
      DUDraw.setXscale(0,1);
      DUDraw.setYscale(0,1);
      
      while(true) {
      
         if(DUDraw.isMousePressed()) {
            double xCoord = DUDraw.mouseX();
            double yCoord = DUDraw.mouseY();
            DUDraw.filledCircle(xCoord, yCoord, 0.03);
         }
      
         if (DUDraw.hasNextKeyTyped()) {
            char key = DUDraw.nextKeyTyped();
   
            if(key == 'r' || key == 'R') {
               DUDraw.clear(DUDraw.BOOK_RED);
            }
            else if(key == 'b' || key == 'B') {
               DUDraw.clear(DUDraw.BOOK_BLUE);
            } 
            else if (key == 'q' || key == 'Q') {
               System.exit(0);
            } 
            else  {
               DUDraw.clear();
            } 
         }
      }
   }
}
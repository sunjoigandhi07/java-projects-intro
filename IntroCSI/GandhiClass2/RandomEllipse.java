import edu.du.dudraw.DUDraw;

public class RandomEllipse {
   public static void main(String[] args) {
   
      DUDraw.setCanvasSize(500,500);
      DUDraw.setXscale(0, 500);
      DUDraw.setYscale(0, 500); 
      
      
      int randomRed = (int) (Math.random() * 256);
      int randomGreen = (int) (Math.random() * 256);
      int randomBlue = (int) (Math.random() * 256);
      
      
      DUDraw.setPenColor(randomRed, randomGreen, randomBlue);
      DUDraw.filledEllipse(250, 250, 100, 150);
      
      DUDraw.setPenColor(DUDraw.BLACK);
      DUDraw.text(250, 250, "Hi");
   
   
   }
}
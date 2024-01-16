import edu.du.dudraw.DUDraw;

public class Driver {
   public static void main(String[] args) {
   
   DUDraw.clear(220,150,250);
   textbox(0.5, 0.5, "Hello, world");
   textbox(0.2, 0.2, "hi");
   textbox(0.6, 0.7, "Supercaligragilisticexpialidocious");
   
   }
   
   public static void textbox(double xCoord, double yCoord, String text) {
      DUDraw.setPenColor(DUDraw.WHITE);
      DUDraw.filledRectangle(xCoord,  yCoord,text.length()*0.01, 0.05);
      DUDraw.setPenColor(DUDraw.BLACK);
      DUDraw.rectangle(xCoord, yCoord,text.length()*0.01, 0.05);
      
      DUDraw.text(xCoord, yCoord, text);
   }   
}
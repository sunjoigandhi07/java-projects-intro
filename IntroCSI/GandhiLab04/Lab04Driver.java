/*
Assigment: Random Circles
Sunjoi Gandhi
Deadline: July 7, 2021
*/

import java.util.Scanner;
import edu.du.dudraw.DUDraw;

public class Lab04Driver {
   public static void main(String[] args) {
   
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Please choose a number greater than 0."); 
      int circNum = keyboard.nextInt(); 
      System.out.println("Thank you!");
   
      DUDraw.setCanvasSize(500, 500); 
   
      for (int i = 0; i < circNum; i++) {
         double xCoord = Math.random();
         double yCoord = Math.random();
         int randomRed = (int)(Math.random()* 256);
         int randomGreen = (int)(Math.random()*256); 
         int randomBlue = (int)(Math.random()*256);
         DUDraw.setPenColor(randomRed, randomGreen, randomBlue);
         DUDraw.filledCircle(xCoord, yCoord, 0.05);
   
      }
      DUDraw.setPenColor(DUDraw.BLACK);
      DUDraw.text(0.5, 0.95, circNum + " circles");
   
 }
}
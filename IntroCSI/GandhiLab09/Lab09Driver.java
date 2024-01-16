/*
Assignment: Random Squares
Sunjoi Gandhi
Deadline: July 24, 2021
*/

import edu.du.dudraw.DUDraw;

public class Lab09Driver {
   public static void main(String[] args) {
   
      double [] xCoordinate = new double [100]; 
      double [] yCoordinate = new double [100];
      DUDraw.clear(DUDraw.MAGENTA);
      int length = xCoordinate.length;
      double xSum = 0;
      double ySum = 0;
      
      for (int i = 0; i < xCoordinate.length; i++) {
         xCoordinate[i] = Math.random();
         yCoordinate [i] = Math.random();

         DUDraw.setPenColor(DUDraw.YELLOW);
         DUDraw.filledSquare(xCoordinate[i], yCoordinate[i], 0.008);
         
         xSum += xCoordinate[i];
         ySum += yCoordinate[i];
      } 
      
      double xAverage = xSum/length;
      double yAverage = ySum/length;
      
      System.out.println("Average x-coordinate: " + xAverage);
      System.out.println("Average y-coordiante: " + yAverage);
      
   
   }
}
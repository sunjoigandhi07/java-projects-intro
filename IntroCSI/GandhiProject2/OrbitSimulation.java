/*
Assignment: Orbit Simulation 
Sunjoi Gandhi 
Deadline: July 22, 2021
*/

import edu.du.dudraw.DUDraw;

public class OrbitSimulation {
   public static void main(String[] args) {
   
      DUDraw.setCanvasSize(600, 600); 
      DUDraw.enableDoubleBuffering();
      
      //Sun Variables
      double sunRadius = 0.2;
      double xSun = 0.5;
      double ySun = 0.5;
      //Earth Variables
      double earthRadius = sunRadius/5;
      double xEarth = 0.9;
      double yEarth = 0.5;
      double rFromSun = 0.3;
      double earthSpeed = 0.03;
      double earthAngle = 0.0; 
      //Moon Variables 
      double moonRadius = earthRadius/4;
      double xMoon = 0.95;
      double yMoon = 0.5;
      double rFromEarth = 0.06;
      double moonSpeed = 0.03;
      double moonAngle = 0.5*Math.PI;
      Math.toDegrees(moonAngle);


      while (earthAngle <= Math.PI*6) {
         DUDraw.clear(DUDraw.BLACK); 
         for (int i = 0; i < 10; i++) {
            double xStar = Math.random();
            double yStar = Math.random();
            DUDraw.setPenColor(DUDraw.WHITE); 
            DUDraw.filledCircle(xStar, yStar, 0.005);
         } 
         DUDraw.setPenColor(DUDraw.YELLOW);
         DUDraw.filledCircle(xSun, ySun, sunRadius);
         
         xEarth = rFromSun * Math.cos(earthAngle) + xSun;
         yEarth = rFromSun * Math.sin(earthAngle) + ySun; 
         DUDraw.setPenColor(DUDraw.BOOK_LIGHT_BLUE);
         DUDraw.filledCircle(xEarth, yEarth, earthRadius);
         
         xMoon = rFromEarth * Math.cos(moonAngle) + xEarth;
         yMoon = rFromEarth * Math.sin(moonAngle) + yEarth; 
         DUDraw.setPenColor(DUDraw.GRAY);
         DUDraw.filledCircle(xMoon, yMoon, moonRadius); 
         
         earthAngle += 0.05;
         moonAngle += 0.15;
 
         DUDraw.show();
         DUDraw.pause(50);

      }
     
       
   }

}
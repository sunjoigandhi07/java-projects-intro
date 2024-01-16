/*
Assignment: Enter the Matrix
Sunjoi Gandhi
Deadling: August 9, 2021
*/

import edu.du.dudraw.DUDraw;

public class NumberGrid {
   private int[][] grid; 
   
   public NumberGrid(int numRows, int numCol) {
       grid = new int[numRows][numCol];
       
       randomize(1.0);
   }
   
   public void randomize(double threshold) {
      for(int i = 0; i< grid.length; i++) {
         for(int j = 0; j < grid[i].length; j++) {
            double x = Math.random();
            if(x < threshold) {
               grid[i][j] = (int)(Math.random()*100); 
            }
         }
      } 
   }
   
   public void draw() {
      for(int i = 0; i< grid.length; i++) {
         for(int j = 0; j < grid[i].length; j++) {
            DUDraw.text(0.5 + i, 0.5 + j, "" + grid[i][j]);
         }
      } 
   }
} 
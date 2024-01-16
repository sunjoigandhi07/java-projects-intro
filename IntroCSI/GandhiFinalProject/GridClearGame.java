/*
Assignment: Grid Clear
Sunjoi Gandhi 
Deadline: August 18, 2021
*/

import edu.du.dudraw.DUDraw;

public class GridClearGame {
   private int[][] grid;
   
   
   public GridClearGame(int numRows, int numCol) {
      grid = new int[numRows][numCol];  
      
      randomize();
   }
   // randomizes number that will pick the color of the squares on the canvas 
   public void randomize() {
      for(int i = 0; i < grid.length; i++) {
         for(int j = 0; j < grid[i].length; j++) {
            int colorNum = (int)(Math.random()*3);
            grid[i][j] = colorNum;
         }
      }
   }
   // draws grayscale squares on the canvas 
   public void draw() {
      for(int i = 0; i < grid.length; i++) {
         for(int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == 0) {
               DUDraw.setPenColor(DUDraw.BLACK);
            } 
            else if (grid[i][j] == 1) {
               DUDraw.setPenColor(DUDraw.DARK_GRAY); 
            } 
            else if (grid[i][j] == 2) {
               DUDraw.setPenColor(DUDraw.LIGHT_GRAY);
            } 
            else if(grid[i][j] == 3) {
               DUDraw.setPenColor(220,150,250);
            }
            
         DUDraw.filledSquare(i + 0.5, j + 0.5, 0.5); 
         }
      }
   }
   // checks if all boxes have been clicked until the clear color shows 
   public boolean isCleared() {
      for(int i = 0; i < grid.length; i++) {
         for(int j = 0; j < grid[i].length; j++) {
            if(grid[i][j] != 3) {
               return false;
            } 
         }
      }
      return true;
   }
   
   public void handleMouse(double xCoord, double yCoord) {
      for(int i = 0; i < grid.length; i++) {
         for(int j = 0; j < grid[i].length; j++) {
            double iCoord = i + 0.5;
            double jCoord = j + 0.5;
            if (xCoord >= iCoord - 0.5 && xCoord <= iCoord + 0.5 && yCoord >= jCoord - 0.5 && yCoord <= jCoord + 0.5) {
               if (grid[i][j] < 3) {
                  grid[i][j]++;
               } 
            }  
          }
       }
   } 
} 
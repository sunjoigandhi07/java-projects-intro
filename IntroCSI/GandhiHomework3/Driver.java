public class Driver {
   public static void main(String[] args){
   
      int factorial = 1;
      int n = 9;
      
      while (factorial != 9) {
         n ++; 
         factorial *= n;
      } 
      
      System.out.print(n + "! = " + factorial);
   
   }
}
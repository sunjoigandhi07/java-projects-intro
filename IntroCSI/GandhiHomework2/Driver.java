public class Driver {
 public static void main(String[] args) {
 
 for (int i = 1; i <= 50; i++) {
   if (i % 3 == 0 || i % 5 == 0) {
      System.out.println("Thrive");
   } else {
      System.out.println(i);
   }   
 }
 
 for (int t = 10; t <= 200; t +=10) {
   System.out.println(t);
 }
 
}
}
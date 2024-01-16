import edu.du.dudraw.DUDraw;

public class Driver{
   public static void main(String[] args) { 
   
   int check = mysteryMethod("Catman hat", 'a');
   
   System.out.println(check);
   
  }
   
   public static int mysteryMethod(String str, char c) {
   int num = 0;
   String current = str;
   int index = current.indexOf(c);
   
   while (index >= 0) {
      num++;
      current = current.substring(index+1);
      index = current.indexOf(c);
   }
   
   return num;
 }
}

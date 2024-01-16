import java.util.Scanner;

public class Driver {
   public static void main(String[] args) {
   
   Scanner keyboard = new Scanner(System.in);
   System.out.print("What is your name?");
   String name = keyboard.nextLine();
   System.out.println("Hello, " + name); 
   
   System.out.print("What is your age?"); 
   int age = keyboard.nextInt();
   System.out.println("Cool!");
   
   }
}

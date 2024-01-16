import java.util.Scanner;

public class Homework {
   public static void main(String[]args){
     Scanner kb = new Scanner(System.in);
     System.out.println("Hello, please type a word that begins with the letter 'A'");
     String userInput = kb.nextLine();
     
     while(userInput.charAt(0)!= 'A' && userInput.charAt(0)!= 'a') {
         System.out.println("ERROR! Please try again.");
         userInput = kb.nextLine();
     }
     
     System.out.println("A is for " + userInput);
     
   }
}
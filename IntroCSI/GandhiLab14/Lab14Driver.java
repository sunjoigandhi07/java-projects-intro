/* 
Assignement: String Methods
Sunjoi Gandhi
Deadline: August 11, 2021
*/

public class Lab14Driver {
    // Define method multiply
   public static String multiply(String str, int count) {
      for(int i = 0; i <= count; i++) {
         return str;
      }
         return "";
      
       
   }
   
   // Define method isUpperCase
   public static boolean isUpperCase(String str) {
      if(str == "") {
         return false;
      } 
      else if (str == str.toUpperCase()) {
         return true;
      }
      return false;
   }
   
   
   // Define method indexOf
   public static int indexOf(String str, String substring) {
      for(int i = 0; i <= str.length(); i++) {
         char stringCheck = str.charAt(i);
         char subCheck = substring.charAt(i);
         
         while(stringCheck == subCheck) {
            return i;
         }
      }
      return -1;
   }


   // DO NOT CHANGE CODE INSIDE MAIN METHOD
   public static void main(String[] args) {      
      // Tests for multiply
      testMultiply("a", 0, "a");
      testMultiply("a", 1, "a");
      testMultiply("a", 5, "aaaaa");
      testMultiply("bother", 4, "botherbotherbotherbother");
      testMultiply("", 1000, "");
      
      // Tests for isUpperCase
      testIsUpperCase("ABC", true);
      testIsUpperCase("abc", false);
      testIsUpperCase("Abc", false);
      testIsUpperCase("ABc", false);
      testIsUpperCase("A", true);
      testIsUpperCase("ABCDEFGHIJKLMNOPQRSTUVWXYZ", true);
      testIsUpperCase("ABCDEFGHIJKLMNOPQRSTUVWXYz", false);
      testIsUpperCase("", false);
      
      // Tests for indexOf
      testIndexOf("aa", "a", 0);
      testIndexOf("galaxy", "xy", 4);
      testIndexOf("c", "c", 0);
      testIndexOf("artificial intelligence", "fish", -1);
      testIndexOf("artificial intelligence", "intel", 11);
      testIndexOf("artificial intelligence", "intelligence", 11);
      testIndexOf("artificial intelligence", "inteligence", -1);
      testIndexOf("art", "", 0);
      testIndexOf("", "c", -1);
      testIndexOf("", "", -1);
   }
   
   // DO NOT CHANGE TEST METHODS
   public static void testMultiply(String str, int count, String expected) {
      String given = multiply(str, count);
      
      if (given.equals(expected)) {
         System.out.println("PASSED - multiply");
      } else {
         System.out.println("FAILED - multiply");
         System.out.println("\tParameters: str=\"" + str + "\", count=" + count);
         System.out.println("\tGiven Answer: " + given + ", Expected Answer: " + expected);
      }
   }
   
   public static void testIsUpperCase(String str, boolean expected) {
      boolean given = isUpperCase(str);
      
      if (given == expected) {
         System.out.println("PASSED - isUpperCase");
      } else {
         System.out.println("FAILED - isUpperCase");
         System.out.println("\tParameters: str=\"" + str + "\"");
         System.out.println("\tGiven Answer: " + given + ", Expected Answer: " + expected);
      }
   }
   
   public static void testIndexOf(String str, String sub, int expected) {
      int given = indexOf(str, sub);
      
      if (given == expected) {
         System.out.println("PASSED - indexOf");
      } else {
         System.out.println("FAILED - indexOf");
         System.out.println("\tParameters: str=\"" + str + "\", substring=\"" + sub + "\"");
         System.out.println("\tGiven Answer: " + given + ", Expected Answer: " + expected);
      }
   }
  
}
 
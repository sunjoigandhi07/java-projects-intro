/*
Assignment: Book Class
Sunjoi Gandhi
Deadling: July 30, 2021
*/

public class Lab11Driver {
   public static void main(String[] args) {
   
   Book b = new Book("The Color Purple", 288, 11.99);
   
   System.out.println(b.getBookTitle());
   System.out.println(b.getPageNum());
   System.out.println(b.getPrice());
   
   b.setPrice(9.99);
   
   System.out.println(b.getPrice());
   
   }
}
/*
Assignment: Book Class
Sunjoi Gandhi
Deadling: July 30, 2021
*/

public class Book {

   private String bookTitle;
   private int pageNum;
   private double price; 
   
   public Book (String book, int page, double money) { 
      this.bookTitle = "The Color Purple";
      this. pageNum = 288;
      this.price = 11.99;
   } 
   // Book Title Getter & Setter
   public String getBookTitle() {
      return bookTitle;
   }
   public void setBookTitle(String newBookTitle) {
      bookTitle = newBookTitle;
   } 
   // Page Number Getter & Setter
   public int getPageNum() {
      return pageNum;
   }
   public void setPageNum(int newPageNum) {
      pageNum = newPageNum;
   }
   // Price Getter & Setter
   public double getPrice() {
      return price;
   } 
   public void setPrice(double newPrice) {
      price = newPrice; 
   }
  
}
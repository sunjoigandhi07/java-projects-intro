/*
Assignment: Project 3
Sunjoi Gandhi
Deadline: August 5 2021
*/

import java.util.Scanner;

public class RockPaperScissors {
   public static void main(String[] args) {
   
      Scanner keyboard = new Scanner(System.in); 
   
      System.out.println("Welcome to Rock, Paper, Scissors - Best of 5");
      System.out.print("Please enter your name: "); 
      String name = keyboard.next();
      
      int rock = 0;
      int paper = 1;
      int scissors = 2;
      int userWins = 0;
      int compWins = 0;
     
      while (userWins < 3 && compWins < 3) {
         System.out.print("Choose (0) ROCK, (1) PAPER, or (2) SCISSORS?"); 
         int userChoice = keyboard.nextInt();
         int compChoice = (int)(Math.random()*2); 
         
            if (userChoice == rock) {
               System.out.println(name + " chooses ROCK");  
            } 
            else if (userChoice == paper) {
               System.out.println(name + " chooses PAPER");
            } 
            else if (userChoice == scissors) {
               System.out.println(name + " chooses SCISSORS");
            }
           
            if (compChoice == rock) {
               System.out.println("COMPUTER chooses ROCK");
            }
            else if (compChoice == paper) {
               System.out.println("COMPUTER chooses PAPER");
            }
            else if (compChoice == scissors) {
                System.out.println("COMPUTER chooses SCISSORS");
            }
            
            
            if(userChoice == rock && compChoice == scissors) {
               System.out.println(name + " wins!");
               userWins++;
               System.out.println("Points for " + name + ": " + userWins);
               System.out.println("Points for COMPUTER: " + compWins);
            }
            else if(userChoice == scissors && compChoice == paper) {
               System.out.println(name + " wins!");
               userWins++;
               System.out.println("Points for " + name + ": " + userWins);
               System.out.println("Points for COMPUTER: " + compWins);
            } 
            else if(userChoice == paper && compChoice == rock) {
               System.out.println(name + " wins!");
               userWins++;
               System.out.println("Points for " + name + ": " + userWins);
               System.out.println("Points for COMPUTER: " + compWins);
            } 
            else if(userChoice == compChoice) {
               System.out.println("Draw!");
               System.out.println("Points for " + name + ": " + userWins);
               System.out.println("Points for COMPUTER: " + compWins);
            }
            else {
               System.out.println("COMPUTER wins!");
               compWins++;
               System.out.println("Points for " + name + ": " + userWins);
               System.out.println("Points for COMPUTER: " + compWins);
            } 
      
            if(userWins >= 3 && compWins < 3) {
               System.out.println(name + " is the Rock, Paper, Scissors champion!");
            } 
            else if (compWins >= 3 && userWins < 3) {
               System.out.println("COMPUTER is the Rock, Paper, Scissors champion!");
            }
      }  
   }
}
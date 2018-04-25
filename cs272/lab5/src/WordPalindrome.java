// CS 272
// Program Name: Lab5
// Author:  Evan Lavelle
// Date: 10/26/17
// Purpose: Demonstrate understanding of the Queue ADT and the skills
// involved with modifying/extending an existing program. 

// File: WordPalindrome.java
// This program determines whether an input line is a world palindrome.
// Ignores everything except alphabetic letters, spaces, and apostrophes.
// Not case-sensitive.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;  

public class WordPalindrome 
{
   /**
   * The main method prompts the user for a strings. Each string is read
   * and checked to see whether it is a palindrome.  The program ends when
   * the user enters an empty line (just the return key).
   * @param args
   *   not used in this implementation
   **/
   public static void main(String[ ] args){
	   
	Scanner stdin = new Scanner(System.in); // Keyboard input       
	String line;                            // One input line
    String clean = "";
    int index;
    
      do{
	    System.out.println("Type a sentence or press Enter to quit.");
        line = stdin.nextLine( );  
        
        if (line.length() != 0) {
        	
        	for (index = 0; index < line.length(); index++) {
        		
        		// boxing to enable isLetter function
        		Character c = line.charAt(index);
        		
        		// check for valid characters
        		if (Character.isLetter(c)||
        		c == '\'' || 
        		c == ' '){

        		// move	valid characters into second string
                clean += c;
        		} // end if
        	} // end for 
     
            if (isWordPalindrome(clean)) {
	           System.out.println("That is a palindrome.");
               clean = "";
            } // end if
            else {
	           System.out.println("That is not a palindrome.");
               clean = "";
            } // end else   
        } // end if
        
      } // end do
      while (line.length() != 0);
      
      stdin.close();
   } // end main

   /**
   * Determine whether a string is a palindrome. Note: All non-letters are
   * ignored, and the case of the letters is also ignored.
   * @param input
   *   the string to check
   * @return
   *   true if and only if the input string is a palindrome.
   **/
   public static boolean is_palindrome(String input){   
      Queue<Character> q = new LinkedList<Character>( );
      Stack<Character> s = new Stack<Character>( );
      Character letter;   // One character from the input string
      int mismatches = 0; // Number of spots that mismatched
      int i;              // Index for the input string
      
      for (i = 0; i < input.length( ); i++)
      {
	      letter = input.charAt(i);
         if (Character.isLetter(letter))
         {
            letter = Character.toUpperCase(letter);
            q.add(letter);
            s.push(letter);
         }
      }
      
      while (!q.isEmpty( ))
      {
         if (q.remove( ) != s.pop( ))
            mismatches++;
      }

      // If there were no mismatches, then the string was a palindrome.
      return (mismatches == 0); 
   }
    
   public static boolean isWordPalindrome(String input){   
      Queue<String> q = new LinkedList<String>();
      Stack<String> s = new Stack<String>();
      String wordString = ""; 
      Character letter;   // One character from the input string
      int mismatches = 0; // Number of spots that mismatched
      int i;              // Index for the input string
      
      // loop through input
      for (i = 0; i < input.length(); i++){
	     letter = input.charAt(i);
	     
	     // forms words from sanitized input by collecting non-whitespace Characters)
         if (Character.isLetter(letter) || letter == '\''){
            letter = Character.toUpperCase(letter);
            wordString += letter;
         } // end if
         
         // check for end of word/input and store word, refreshing to empty after
         if (letter == ' ' || i == input.length() - 1){
            q.add(wordString);
            s.push(wordString);
            wordString = "";
         } // end if
      } // end for
      
      // compare words opposite words w/ linked list and queue
      while (!q.isEmpty( )){
         if (!q.remove().equals(s.pop()))
            mismatches++;
      } // end while
      
      // If there were no mismatches, then the string was a palindrome.
      if (mismatches == 0) {
    	  return true; 
      } // end if
      
      return false;
   } // end isWorldPalindrome
} // end class
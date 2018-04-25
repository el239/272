// CS 272
// Program Name: Lab2
// Author:  Evan Lavelle
// Date: 9/25/17
// Purpose: Employ various methods with Bag ADT

import java.util.Arrays;

public class QwirkleTest{
   public static void main(String[] args){
   Tile tile1 = new Tile(1,1);
   Tile tile2 = new Tile(1,1);
   Tile tile3 = tile2.clone();
   Tile tile4 = new Tile(-1,7);
   QwirkleBag game1 = new QwirkleBag();
//   tile1.equals(tile2); // preliminary tests for clone & equals component methods
//   System.out.println(tile1);   
//   System.out.println(tile2);
//   System.out.println(tile3);
//   System.out.println(tile4);
   System.out.println("\n" + "I created a new QuirkleBag. Here's what's in it:");
   System.out.println("\n" + game1); // print tile contents
   game1.add(tile1);
   game1.trimToSize();
   game1.remove(0);
   game1.draw();
   game1.countOccurences(tile1);
   } // end main
} // end test
// CS 272
// Program Name: Lab2
// Author:  Evan Lavelle
// Date: 9/25/17
// Purpose: Employ various methods with Bag ADT

import java.util.*;
public class QwirkleBag implements Cloneable{
   // instance variables
   private int manyItems;
   private Tile[] TileArray;
   
   // constructor : behavior #1
   public QwirkleBag( ){
      final int INITIAL_CAPACITY = 108;
      manyItems = 108;
      TileArray = new Tile[INITIAL_CAPACITY];
      int i = -1;
      int j;
      int k;
      int l;
      for (l = 0; l < 3; l++){
         for (k = 1; k < 7; k++){ 
            for (j = 1; j < 7; j++){
               i++;
               TileArray[i] = new Tile(j,k);
            } // end for loop
         } // end for loop
      } // end for loop
   } // end constructor
   // ensure memory capacity for array
   public void ensureCapacity(int minimumCapacity){
      int i;
      Tile biggerArray[]; // declaration
      if (TileArray.length < minimumCapacity){
         biggerArray = new Tile[minimumCapacity]; // allocate space
         for (i = 0; i < manyItems; i++){ // copy references
            biggerArray[i] = TileArray[i];
         } // end for
      TileArray = biggerArray;
      } // end if
   }// end ensure Capacity


   // add one item 
   public void add(Tile element){
      if (manyItems == TileArray.length){ // Ensure twice as much space as we need.
         ensureCapacity((manyItems + 1)*2);
      } // end if
      TileArray[manyItems] = element.clone();
      manyItems++;
   } // end add

   // remove one item
   
   public boolean remove(Tile target)
   {
      int index;  // must declare before the loop
      for (index = 0; (index < manyItems) && (!target.equals(TileArray[index])); index++){ 
         ; // halt
      } // end for    
            
      if (index == manyItems)  // target was not found
            return false;
         
      else{  
         manyItems--;
         TileArray[index] = TileArray[manyItems];
         return true;
         } // end else
   } // end remove
   
   public void trimToSize( ){
      int i;
      Tile trimmedArray[];
      if (TileArray.length != manyItems){                         
         trimmedArray = new Tile[manyItems];
         for (i = 0; i < manyItems; i++){ // copy references
            trimmedArray[i] = TileArray[i];
         } // end for
      TileArray = trimmedArray;
      } // end if
   } // end trimToSize
 
   
   public String toString(){
      int i;
      for (i = 0; i < manyItems; i++){
         System.out.println(TileArray[i]);
      } // end for     
   return "\n";   
   } // end toString

   public QwirkleBag deepClone(){ // Clone an IntArrayBag object.
      QwirkleBag answer;
      int i;
         try{
            answer = (QwirkleBag)super.clone();
            
            for (i = 0; i < answer.manyItems; i++){
               answer.TileArray[i] = TileArray[i].clone();
            } // end for
            
         } // end try
         catch (CloneNotSupportedException e){
            throw new RuntimeException
            ("This class does not implement Cloneable");
         } // end catch   
         
 // Evan Lavelle, 9/23/17: The default (shallow) clone method will replicate
 // all of a given object's fields. Therefore, references to other objects, 
 // while being duplicated, will indicate the same addresses as the references
 // of the original. This is in contrast to a deep clone, wherein such 
 // references will cause entirely new objects to be generated. Whereas the 
 // former is sufficient to clone tiles, being that they possess no such references,
 // the latter is more suitable for the bag class, as it references tile objects.   
   return answer;
 } // end clone 

   // count number of certain tiles in bag 
   public int countOccurences(Tile target){
      int count = 0;
         for (int index = 0; index < manyItems; index++){
            if (target.equals(TileArray[index]))
               count++;     
         } //end for 
      System.out.println("There are " + count + " occurences of " + target);         
      return count;
    } // end countOccurrences
 
    public int getCapacity(){
       return TileArray.length;
    } // end getCapacity

    public int getSize( ){
       return manyItems;
    } // end size

   public Tile draw(){
      int random = new Random().nextInt(TileArray.length);
      Tile temp = TileArray[random];
      if (manyItems == 0){
         return null;
      } // end if
      manyItems -= 1;
 //     System.out.println("You drew: " + TileArray[random] + "\n");
      remove(TileArray[random]);
      return temp;
   } // end draw   
} // end class

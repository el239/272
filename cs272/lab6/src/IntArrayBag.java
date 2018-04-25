// Program Name: lab6
// Author: Evan Lavelle 
// Date: 11/10/17
// Purpose: Create a program that is both applet and application

public class IntArrayBag implements Cloneable{
   
   // instance variables
   private int[] data;
   private int manyItems; 
   
   // constructor : behavior #1
   public IntArrayBag( ){
      final int INITIAL_CAPACITY = 10;
      manyItems = 0;
      data = new int[INITIAL_CAPACITY];
   } // end constructor
     

   // another constructor : behavior #1
   public IntArrayBag(int initialCapacity){
	   
      if (initialCapacity < 0)
         throw new IllegalArgumentException
         ("The initialCapacity is negative: " +  initialCapacity);
      data = new int[initialCapacity];
      manyItems = 0;
   } // end constructor
        
   // add one item : behavior #2
   public void add(int element){
	   
      if (manyItems == data.length){  
    	 // Ensure twice as much space as we need.
         ensureCapacity((manyItems + 1)*2);
      } // end if
      data[manyItems] = element;
      manyItems++;
   } // end add

   // add many items : behavior #3
   public void addMany(int... elements) {
   // This is a variable arity method.  
   // We can specify as many parametersa as needed.
	   
      if (manyItems + elements.length 
           > data.length){  
    	 // Ensure twice as much space as we need.
         ensureCapacity((manyItems + elements.length)*2);
      } // end if

      System.arraycopy(elements, 0, data, manyItems, elements.length);
      manyItems += elements.length;
   }


   public void addAll(IntArrayBag addend){
      ensureCapacity(manyItems + addend.manyItems);
  
      System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
      manyItems += addend.manyItems;
   } // end addAll

   public IntArrayBag clone( ){
	  // Clone an IntArrayBag object.
      IntArrayBag answer;
      
      try{
         answer = (IntArrayBag) super.clone( );
      } // end try
      catch (CloneNotSupportedException e){
          throw new RuntimeException
           ("This class does not implement Cloneable");
      } // end catch
      
      answer.data = data.clone( );
      return answer;
   } // end clone

// see the remainder of the IntArrayBag.java file in 
// the Sept 7 notes

   public int countOccurrences(int target){
      int count = 0;
  
      for (int index = 0; index < manyItems; index++)
         if (target == data[index])
            count++;
      return count;
   } // end countOccurences
   
   public void ensureCapacity(int minimumCapacity){
      int biggerArray[ ]; // declaration
      
      if (data.length < minimumCapacity){
         biggerArray = new int[minimumCapacity]; // allocate space

         System.arraycopy(data, 0, biggerArray, 0, manyItems);

         data = biggerArray;  
      } // end if
   } // end ensureCapacity

   public int getCapacity(){
      return data.length;
   } // end getCapacity
       
   public boolean remove(int target){
      int index;  // must declare before the loop

      for (index = 0; index < manyItems; index++) {
         
         if (index == manyItems)  // target was not found
            return false;
         
         else if (target == data[index]){
            data[index] = data[manyItems - 1];
            manyItems--;
            return true;
         } // end else if
      } // end for  
      return false;
   } // end remove
                 
   public int size(){
      return manyItems;
   } // end size
   
   public void trimToSize(){
      int trimmedArray[];
      
      if (data.length != manyItems){
         trimmedArray = new int[manyItems];
         System.arraycopy(data, 0, trimmedArray, 0, manyItems);
         data = trimmedArray;
      } // end if
   } // end trimToSize
      
   public static IntArrayBag union(IntArrayBag b1, IntArrayBag b2){
      //   a call to this method would look like
      //   IntArrayBag.union( first IntArrayBag, second IntArrayBag )

      // If either b1 or b2 is null, then a NullPointerException is 
      // thrown. 
      // In the case that the total number of items is beyond
      // Integer.MAX_VALUE, there will be an arithmetic overflow and
      // the bag will fail.
   
      IntArrayBag answer = new IntArrayBag(b1.getCapacity() +          
                                      b2.getCapacity());
      
      // Dr. Steiner replaced the calls to System.arraycopy
      // with two simple loops

      for (int i = 0; i < b1.manyItems; i++)
         answer.data[i] = b1.data[i];

      for (int j = 0; j < b2.manyItems; j++) {
         answer.data[b1.manyItems + j] = b2.data[j];
         answer.manyItems = b1.manyItems + b2.manyItems;
      } // end for      
      return answer;
   } // end union
   
   public int findRandomItem(){
	   
   int index = (int)(Math.random() * (manyItems - 1));  
   return data[index];
   } // end findRandomItem
  
} // end class

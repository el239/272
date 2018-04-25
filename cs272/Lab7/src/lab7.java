// Program Name: lab7
// Author: Evan Lavelle 
// Date: 11/24/17
// Purpose: Create a program that is both applet and application

import java.lang.Math.*;

public class lab7{

public static void main(String args[]){
//	int[] myArray = new int[10];
//	myArray = {2,7,4,5,9};
	int[] myArray = {2,7,4,5,9};
	arraySort(myArray,5);
	System.out.println(java.util.Arrays.toString(myArray));
} // end main

public static void arraySort(int[] theArray, int occupied) {

int i;
   for (i = 0; i < occupied + 1; i++) {
	   int p;
	   for (p = i + 1; p < occupied; p++){
		   if (theArray[i] > theArray[p]) {
			   int temp = theArray[p];
			   theArray[p] = theArray[i];
			   theArray[i] = temp;				
		   } // end if
	   } // end for
   } // end for
} // end arraysort

} // end class


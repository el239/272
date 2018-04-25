// Program Name: lab6
// Author: Evan Lavelle 
// Date: 11/10/17
// Purpose: Create a program that is both applet and application

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JApplet;

public class lab6 extends JApplet{
   public static void main(String args[]){
      binaryPrint(27);
      System.out.println();
      IntArrayBag tester = new IntArrayBag();
      tester.addMany(1,2,3,4,5,6,7,8,9);
      printBag(tester);
   } // end main

   public static void printBag(IntArrayBag input){
	   if (input.size() == 0)
	   return;
	   int oneItem = input.findRandomItem();
	   input.remove(oneItem);
	   System.out.println(oneItem);
	   printBag(input);
	   input.add(oneItem);
   } // end printBag
   
   public static void binaryPrint(int n){
	   
	   // precondition
	   if (n < 0)
		   return;
	   
	   // base case
	   else if (n < 2) {
		   System.out.print(n%2);
           return;
	   } // end elseif
	   
	   binaryPrint(n/2);
	   System.out.print(n%2);
   } // end binaryPrint
   
   private Image display;
   private Graphics drawingArea;
   
   public void init( )
   {  
      int height = getSize( ).height;
      int width = getSize( ).width;
      display = createImage(width, height);
      drawingArea = display.getGraphics( );
      
      randomFractal(0, height/2, width, height/2, drawingArea, Color.CYAN);
   }
      
   public void paint(Graphics g)
   {
      g.drawImage(display, 0, 0, null);
   }
      
   public static void randomFractal(
      int leftX,
      int leftY,
      int rightX,
      int rightY,
      Graphics drawingArea,
      Color c
   )
   {
      final int STOP = 4;  // When length < EPSILON, draw a line segment
      int midX, midY;      // Midpoints in the x and y dimensions
      int delta;           // Amount to shift the line's midpoint up or down
      
      if ((rightX - leftX) <= STOP) {
    	 drawingArea.setColor(c); 
         drawingArea.drawLine(leftX, leftY, rightX, rightY);
      } // end if
      else
      {
         midX = (leftX + rightX) / 2;
         midY = (leftY + rightY) / 2;
         delta = (int)((Math.random( ) - 0.5) * (rightX - leftX));
         midY += delta;
         randomFractal(leftX, leftY, midX,   midY,   drawingArea, c);
         randomFractal(midX,  midY,  rightX, rightY, drawingArea, c);
      }
   }   
} // end main
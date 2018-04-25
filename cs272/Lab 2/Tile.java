// CS 272
// Program Name: Lab3
// Author:  Evan Lavelle
// Date: 9/25/17
// Purpose: 

public class Tile implements Cloneable{
	private int Tile_color;
	private int Tile_shape;
   
   // Tile constructor
   public Tile(int color, int shape){
      Tile_color = color;
      Tile_shape = shape;
   } // end constructor
   
   public int getColor(){
      return Tile_color;
   } // end accessor
   
   public int getShape(){
      return Tile_shape;
   } // end shape
   
   public void setColor(int color){
      Tile_color = color;
   } // end setter
   
   public void setShape(int shape){
      Tile_shape = shape;
   } // end setter    
   
   public boolean equals(Tile Tile2){
      if (Tile_color == Tile2.getColor() && Tile_shape == Tile2.getShape()){
         System.out.println("Same");
         return true; 
      } // end if   
      else{ 
         System.out.println("Different");
         return false;
      } // end else   
   } // end equals
   
   public String toString (){
      String shape = "unassigned";
      String color = "unassigned";
      switch(Tile_shape){
         case 1:
            shape = "circle";
            break;
         case 2:
            shape = "square";
            break;
         case 3:
            shape = "diamond";
            break;
         case 4:
            shape = "star";
            break;
         case 5:
            shape = "clover";
            break;    
         case 6:
            shape = "shuriken";
            break;  
         default:
            shape = "unknown";
            break;   
      } // end switch
      
      switch(Tile_color){
         case 1:
            color = "purple";
            break;
         case 2:
            color = "blue";   
            break;
         case 3:
            color = "orange";
            break;
         case 4:
            color = "red";
            break;
         case 5:
            color = "yellow";  
            break;
         case 6:
            color = "green";  
            break; 
         default:
            color = "unknown";
            break;
      } // end switch     
   return color + " " + shape;                                              
   } // end toString
   
   public Tile clone(){
      Tile answer;
      
      try{
         answer = (Tile)super.clone();
      }
      catch (CloneNotSupportedException e)
      {
         throw new RuntimeException
         ("This class does not implement Cloneable>");
      }
      return answer;
   } // end clone   
} // end class

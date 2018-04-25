// CS 272
// Program Name: Lab4
// Author:  Evan Lavelle
// Date: 10/23/17
// Purpose: Demonstrate mastery of the generic class and understanding of the stack ADT

public class QwirkleRowTest{
	public static boolean validRow (ArrayStack<Tile> stack){
		
		// check if stack is empty (invalid)
		if (stack.isEmpty()){
			System.out.println("\n" + "Empty stack - no tiles to make a row");
			return false;
		} // end if
		
		// check if only a single tile is in stack (valid)
		if (stack.size() == 1){
			return true;
		} // end if
		
		// check if stack contains over six tiles (invalid)
		if (stack.size() > 6){
			System.out.println("\n" + "Too many tiles for a row (6 max)");
			return false;
		} // end if
		
		// creates an array of the same size as argument stack
		Tile[] layout = new Tile[stack.size()];
		
		// clones stack to prevent needing to restore it
		ArrayStack<Tile> copiedStack = stack.clone();
		
		// fills array with stack's tiles
		int i = 0;
		int j = 0;
		while (!copiedStack.isEmpty()){
			layout[i] = copiedStack.pop();
			i++;
		} // end while
		
	// loops through array	
	for (i = 0; i < stack.size() - 1; i++) {
		
		// checks for duplicates (invalid)
		if ((layout[i].getColor() == layout[i + 1].getColor()) &&
		(layout[i].getShape() == layout[i + 1].getShape())) {
			return false;
		} // end if

		// checks for uniform color, differing shapes (valid)
		else if (layout[i].getColor() == layout[i + 1].getColor()){
			for (j = 0; j < stack.size() - 1; j++) {
				if (layout[j].getShape() != layout[j + 1].getShape()) { 
					return true;
				} // end if
				return false;
			} // end for
	    } // end for
		
		// checks for uniform shapes, differing colors (valid)
		else if (layout[i].getColor() != layout[i + 1].getColor()){
			for (j = 0; j < stack.size() - 1; j++) {
				if (layout[j].getShape() == layout[j + 1].getShape()) { 
					return true;
				} // end if
				return false;
			} // end for
		} // end else if
		else return false;
	} // end for 	
	return false;
	} // end validRow

	public static void main(String args[]) {
		ArrayStack<Tile> stack1 = new ArrayStack<Tile>(6);
		stack1.push(new Tile(1,1));
		stack1.push(new Tile(2,1));
		stack1.push(new Tile(3,1));
		stack1.push(new Tile(1,1));
		stack1.push(new Tile(1,1));
		stack1.push(new Tile(1,1));
		stack1.push(new Tile(1,1));
	
	System.out.print(stack1);	
	if (validRow(stack1) == false){
		System.out.println("\n" + "The hand is not valid");
	}
	else {
		System.out.println("\n" + "The hand is valid");
	}
} // end main
} // end class
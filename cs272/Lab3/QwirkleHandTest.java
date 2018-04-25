// CS 272
// Program Name: Lab3
// Author:  Evan Lavelle
// Date: 10/4/17
// Purpose: Demonstrate proficiency with the TileNode ADT and linked lists

public class QwirkleHandTest {	
	public static void main(String args[]){
		TileNode qwirkleHand = null;
		QwirkleBag game1 = new QwirkleBag();
		
		// draw 6 tiles out of the bag and add them to the player's hand
		for (int t = 1; t <= 6; t++) {
			qwirkleHand = TileNode.insertAtHead(qwirkleHand,new TileNode(game1.draw(),null));
		} // end for
	
		TileNode.printList(qwirkleHand); // display the tiles in the player's hand
		System.out.printf("\n");
		
		TileNode reversed; 
		reversed = TileNode.reverse(qwirkleHand); // display new reversed list
		TileNode.printList(reversed);
		
		System.out.printf("\n");
		TileNode.printList(qwirkleHand); // checks preservation of list
		System.out.printf("\n");	
		
		int length = TileNode.listLength(qwirkleHand);
		System.out.println("Number of tiles in hand: " + length);
		
		TileNode match = TileNode.listSearch(qwirkleHand, game1.draw()); // checks if drawn Tile matches hand
		
		if (match != null) {
			System.out.println("You drew a match: " + match.getData());
		}
		if (match == null) {
			System.out.println("Drawn tile (" + game1.draw() + ") does not match");
		}
        qwirkleHand.addNodeAfter(new Tile(1,1));
		TileNode.printList(qwirkleHand); // check add functionality  
		System.out.printf("\n");
        qwirkleHand.removeNodeAfter();
		TileNode.printList(qwirkleHand); // check remove functionality        
	} // end main
} // end class

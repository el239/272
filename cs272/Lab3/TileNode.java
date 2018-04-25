// CS 272
// Program Name: Lab3
// Author:  Evan Lavelle
// Date: 10/4/17
// Purpose: Demonstrate proficiency with the TileNode ADT and linked lists

public class TileNode{
	private Tile data;
	private TileNode link;

	public TileNode(Tile initialData, TileNode initialNode){
		data = initialData;
		link = initialNode;
	} // end constructor
	
	public void setData(Tile d){
		data = d;
	} // end setData
	
	public void setLink(TileNode l){
		link = l;
	} // end setLink
	
	public Tile getData(){
		return data;
	} // end getData
	
	public TileNode getLink(){
		return link;
	} // end TileNode
	
	public void addNodeAfter(Tile item){
		link = new TileNode(item, link);
	} // end addNodeAfter
	
	public void removeNodeAfter(){
		link = link.link;
	} // end removeNodeAfter
	
	public static int listLength(TileNode head){
		TileNode cursor;
		int count = 0;		
		for(cursor = head; cursor!=null; cursor = cursor.link){
			count++;
		} // end for
		return count;
	} // end listLength
	
	public static TileNode listSearch(TileNode head, Tile target){
		TileNode cursor;
		for (cursor = head ; cursor!= null; cursor=cursor.link){
			if(target.equals(cursor.data)){
				return cursor;
			} // end if 
		} // end for 
		return null;
	} // end listSearch
	
	public static TileNode listCopy(TileNode original){
		TileNode copyHead;
		TileNode copyTail;
		//check if empty 
		if(original == null){
			return null;
		} // end if
		copyHead = new TileNode(original.data, null); // copies head of input list
		copyTail = copyHead;
		// while not at end of list
		while(original.link != null){
			original = original.link; 
			copyTail.addNodeAfter(original.data); // adds data to tail
			copyTail = copyTail.link;
		} // end while
		// return new list head reference
		return copyHead;
	} //end listCopy 
	
	public static TileNode reverse(TileNode original){
		TileNode currentNode = listCopy(original); // runs function on a copy to preserve original
		TileNode nextNode;
		TileNode lastNode;
		// check if empty
		if(original == null){
			return original;
		} // end if
		
		else{
//			currentNode = original;
			lastNode = null;	
			// check if end of the list
			
			while(currentNode != null){		
				// set next node to the node after current
				nextNode = currentNode.link;			
				// set current node link to last Node
				currentNode.link = lastNode;				
				// set previous node to current
				lastNode = currentNode;//last = current copy 			
				// set current node to the next node
				currentNode = nextNode;
			} // end while
			currentNode = lastNode;
			return currentNode; // original list's tail
		} // end else		
	} // end reverse 
	
	public static TileNode insertAtHead(TileNode head, TileNode tile) {
		if (head == null) {
	        head = tile;
		} // end if
		else {
			tile.link = head;
			head = tile;
		}
	    return head;
	} // end insertAtHead

	public static void printList(TileNode head){
		TileNode cursor = head;	
		// while the cursor isn't the tail
		while(cursor != null){
	        if (cursor.link != null){
			    System.out.print(cursor.data + "--");
	        } // end if
	        else {
	        	System.out.print(cursor.data);
	        } // end else
			cursor = cursor.link;
		} // end while
	} // end display
} // end class
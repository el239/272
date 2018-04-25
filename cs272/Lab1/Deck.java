// CS 272
// Program Name: Lab1
// Author:  Evan Lavelle
// Date: 8/23/17
// Purpose: create a playing card deck class with associated methods

public class Deck{
   private int deck[];
   private int cardCount;

   public Deck(){
      deck = new int [60]; 
      cardCount = 60;
      int i = 0;
   for (i = 0; i < deck.length - 1; i++);
      deck[i] = i;
   } //end Deck
/*
   public void initDeck(){
     int i = 0;
	  for (i; i < 12; i++){
         deck[i] = {value[0], suit[0]};
	  } //end for

      for (i; i < 25; i++){
         deck[i] = {value[(i - 13)], suit[1]};
	  } // end for

	  for (i; i < 38; i++){
         deck[i] = {value[(i - 26)], suit[2]};
	  } // end for

	  for (i; i < 51; i++){
         deck[i] = {value[(i - 39)], suit[3]};
	  } // end for

	  for (i; i < 55; i++){
         deck[i] = {value[13], ""};
	  } // end for

	  for (i; i < 59; i++){
         deck[i] = {value[14], ""};
	  }	// end for
   } // end initDeck

   public String toString(){
	  value[] = {"Ace","2","3","4","5","6","7","8","9","10",
     "Jack","Queen","King","Jester","Wizard"};
     suit[] = {"spades", "hearts", "clubs", "diamonds"};
     String createString();
	  for (int i = 0; i < deck.length; i++){
	     createString += Deck[i] + value[0] + " of " + Deck[i] + suit[0] + "\n";
	  } // end for
	  return createString;
   } // end string

   public void shuffleDeck(){
      sDeck = new int [60];
	   int i = 0;
      for (int i = 0; i < deck.length; i++){
		   int random = (int)(Math.random()*(sDeck.length);
		   Deck[i] = sDeck[random];
		   sDeck[] -= deck[random];
      } // end for
      return sDeck;
   } // end void
*/
   public void printDeck(){
	    for (int i = 0; i < deck.length; i++){
	       System.out.printf("%4d", deck[i]);
		    if (i % 10 == 9){
			    System.out.println();
		       } // end if
	    } // end for
   } // end void
/*
   public String dealACard(){
      printf(deck[59]);
	   deck[] = deck[-1];
      return deck;
   } // end string

   public boolean emptyDeck(){
	   if deck == 0;
	      return true
	   else;
	      return false 
   } // end boolean 
*/
} //end class 

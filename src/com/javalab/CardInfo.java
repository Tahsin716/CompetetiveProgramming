package highlowgame;

/**
 *
 * @author Tahsin Rashad
 * ID: 1432020022
 */
public interface CardInfo {
    
     //Value of each face
     final int ACE = 1;
     final int TWO = 2;
     final int THREE = 3;
     final int FOUR = 4;
     final int FIVE = 5;
     final int SIX = 6;
     final int SEVEN = 7;
     final int EIGHT = 8;
     final int NINE = 9;
     final int TEN = 10;
     final int JACK = 11;
     final int QUEEN = 12;
     final int KING = 13;
     
     
      String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
      String[] faces = {"Ace", "Two", "Three", "Four", "Five", "Six", 
                                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
     
     //Array of all face values
     final int[] values = {ACE, TWO, THREE, FOUR, FIVE, SIX, 
                                SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
    
}

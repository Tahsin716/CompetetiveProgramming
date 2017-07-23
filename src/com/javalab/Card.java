package highlowgame;


/**
 *
 * @author Tahsin Rashad
 * ID: 1432020022
 */
public class Card implements CardInfo{
    
    private int suit, face;
    
    //Constructor
    public Card(int suit, int face) {
        this.suit = suit;
        this.face = face;
    }
       
    
    //Setter Functions
    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setFace(int face) {
        this.face = face;
    }

    //Getter Functions
    public int getSuit() {
        return suit;
    }

    public int getFace() {
        return face;
    }
    
    @Override
    public String toString() {
        return this.face +" of "+ this.suit;
    }
}

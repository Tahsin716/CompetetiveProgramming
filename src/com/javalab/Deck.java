/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highlowgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Tahsin Rashad
 */
public class Deck implements CardInfo{
    
    public ArrayList<Card> cards = new ArrayList<>();
    public HashMap<String, Integer> faceValues = new HashMap<>();
    
    //Constructor to create new card objects
    public Deck() {      
        for(int i = 0; i < CardInfo.suits.length; i++) {
            
            for(int j = 0; j < CardInfo.faces.length; j++) {   
                Card card = new Card(i,j);
                cards.add(card);
            }
        }
        Collections.shuffle(cards);
        setFaceValues();
    }
    
    
    
    //Assigning each face to its appropriate value
    private void setFaceValues() {
        for(int i = 0; i < CardInfo.faces.length; i++) {
            faceValues.put(CardInfo.faces[i], CardInfo.values[i]);
        }
    }
}

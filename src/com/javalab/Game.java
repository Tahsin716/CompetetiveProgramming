package highlowgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Tahsin Rashad
 */
public class Game {
    
    Deck deck;
    BufferedReader bufferedReader;
    String input;
    int playerScore;
    final int gameOverScore = -5;
    
    public Game() {
        deck = new Deck();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        playerScore = 0;
    }
    
    public void play() {
         
        //Loop until user give correct input
        try {
             do{
                System.out.printf("Welcome to High-Low Game!%nPress 'y' to start or 'n' to quit!%n");
                input = bufferedReader.readLine();
            
            }while(input != "y" || input != "n" );
        
        } catch(IOException e) {
            e.printStackTrace();
        }
       
        //Check whether to quit or start the game
        if(input.equals("n")) {
            System.exit(0);
        }
        else {
            gameLoop();
        }
    }
    
    /**
     * Starts the game loop
     */
    private void gameLoop() {
        int count = 0;
        
        while(playerScore > gameOverScore && count > 50) {
              
            //Loop for user input
            try {
                  do{
                    System.out.printf("%s%nPress 'y' if next card will be higer or 'n' if lower%n", deck.cards.get(count));
                    input = bufferedReader.readLine();
            
                }while(!input.equals("y") /*|| !input.equals("n")*/);
            
            }catch(IOException e) {
                e.printStackTrace();
            }
          
            
            ++count;
            
            //Condition for player decision
            if(deck.cards.get(count).getFace() > deck.cards.get(count - 1).getFace()) {
                if(input.equals("y")) {
                    playerScore++;
                }      
            }
            else if(deck.cards.get(count).getFace() < deck.cards.get(count - 1).getFace()) {
                if(input.equals("n")) {
                    playerScore++;
                }
            }
            else
                playerScore--;
        }
    }
}

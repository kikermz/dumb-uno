//This is an Uno game simulation.
//Created by James Vanderhyde, 30 September 2024
//Enrique Loza

package dumbuno;

import java.util.Random;

public class DumbUno
{
    private static final Random rng = new Random();
    
    public static void main(String[] args) 
    {
        final int maxHandSize = 12;
        final int minHandSize = 3;
        
        //Put the players into a circular linked list
        IntNode startPlayer = new IntNode(0,null);
        IntNode current = startPlayer;
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        
        current.setNext(startPlayer);
        
        //Deal every player a hand
        current = startPlayer;
        
       do 
       {
            current.setData(rng.nextInt(minHandSize, maxHandSize+1));
            current = current.getNext();
        } 
       while (current != startPlayer);
        
       
        printGame(startPlayer);
        
        //Play the game
        current = startPlayer;
        
    int turnCount = 0;
        
     while (true) {
    // Decrement the current player's score
    current.setData(current.getData() - 1);

    // Move to the next player
    current = current.getNext();
    
    turnCount++;  // Increment the turn counter
    

    // Check if the current player has won (reached zero)
    if (current.getData() == 0) 
    {
        System.out.println("I win!");
        break;  // Exit the loop i
    }

    
    
    if (turnCount % 5 == 0) {
        printGame(startPlayer);
    }
    }

        
        
    }
    
    private static void printGame(IntNode startPlayer)
    {
        //Student implementation
        IntNode current  = startPlayer;
        
        int playerNumber = 1;  // Start with Player 1

        System.out.print("Current Cards: ");
        do {
            System.out.print("Player " + playerNumber + ": " + current.getData() + "  ");
            current = current.getNext();
            playerNumber++;
        } while (current != startPlayer);
        
        System.out.println();  // Move to the next line after printing all players
    }
        
        
    
    
}

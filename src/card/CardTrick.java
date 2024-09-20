/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package card;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1.
 * Additionally, a special "Lucky Card" is checked for fun!
 * @author srinivsi
 * @modifier Sawandeep Singh
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];  
        Random random = new Random();

        
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1);  // Card values between 1-13
            c.setSuit(Card.SUITS[random.nextInt(4)]);  // Randomly select suit
            magicHand[i] = c;
            System.out.println("Card " + (i+1) + ": " + c.getSuit() + " " + c.getValue());  
        }

        
        Card luckyCard = new Card();
        luckyCard.setValue(7);  // Lucky card value
        luckyCard.setSuit("Hearts");  // Lucky card suit
        System.out.println("\nLucky Card: " + luckyCard.getSuit() + " " + luckyCard.getValue());

        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a card value (1-13): ");
        int userValue = scanner.nextInt();
        
        
        if (userValue < 1 || userValue > 13) {
            System.out.println("Invalid card value. Must be between 1 and 13.");
            return;
        }

        System.out.println("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int suitIndex = scanner.nextInt();
        
        
        if (suitIndex < 0 || suitIndex > 3) {
            System.out.println("Invalid suit index.");
            return;
        }

        String userSuit = Card.SUITS[suitIndex];

       
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        
        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }

        
        boolean luckyFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equals(luckyCard.getSuit())) {
                luckyFound = true;
                break;
            }
        }

       
        if (luckyFound) {
            System.out.println("The lucky card is in the magic hand!");
        } else {
            System.out.println("The lucky card is not in the magic hand.");
        }
    }
}

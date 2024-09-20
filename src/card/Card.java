/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package card;

/**
 * A class that models playing card Objects. Cards have 
 * a value (note that Ace = 1, Jack = 11, Queen = 12, King = 13)
 * A suit (clubs, hearts, spades, diamonds).
 * There are 52 cards in a deck, no jokers.
 * This code is to be used in ICE1. When you create your own branch,
 * add your name as a modifier.
 * @author srinivsi
 * @modifier Sawandeep Singh
 */

public class Card {
    
    private int value;  
    private String suit;  

    
    public static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};

    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value >= 1 && value <= 13) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Invalid card value. Must be between 1 and 13.");
        }
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        // Check if the suit is valid
        for (String validSuit : SUITS) {
            if (validSuit.equalsIgnoreCase(suit)) {
                this.suit = validSuit;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid suit. Must be one of: Hearts, Diamonds, Clubs, Spades.");
    }
}

package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.*;

public class ThreeCardPokerEngine {
    private Deck<PlayingCard> deck;


    // Deals 3 cards to specified player from deck.
    // TODO: PlayerInterface is temporary filler for PokerPlayer
    protected void dealCards(PlayerInterface player){}

    // Returns 1 if hand1 is greater than hand2, 0 if equal, -1 if less
    protected int compareHands(Hand hand1, Hand hand2) {return 0;}

    protected void addAnteWager(PlayerInterface player, int wager) {
    }

    protected void addPairPlusWager(PlayerInterface player, int wager) {}

}

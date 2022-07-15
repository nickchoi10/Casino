package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.CardRank;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import com.github.zipcodewilmington.casino.games.cardgames.StandardDeck;

import java.util.*;

public class BlackjackEngine {


    StandardDeck deck;
    Hand dealerHand;
    List<BlackjackPlayer> players;
    Map<BlackjackPlayer, Integer> playerBets;
    //a map to map the players bet to the players.
    //at the end, pass the pot amount to the BlackjackPlayer method winPot.


    public BlackjackEngine() {
        deck = new StandardDeck();
        dealerHand = new Hand();
        players = new ArrayList<>();
        playerBets = new HashMap<>();
    }

    public static void startPrompt() {
        System.out.println("Welcome to Blackjack at Stardust Casino! \n");
        System.out.println("Please choose from the following: 1) Play Game 2) Quit \n Enter 1 or 2 \n");
    }

    public static void instructionsPrompt() {
        System.out.println("");
        // Blackjack is usually a table of 2-7 players and uses one to 52-card deck.
        // Jack, Queen, King are all 10 points. Ace is one or 11 points.
        // deal one card face up to all players, then deal second card to all players. AKA deal 2 cards to player.
        // dealer receive two card, one face up and one face down.
        // Objective is to get 21 or be as close you can to 21 without going over.
        // Beginning of game players place their bets.
        // "Hit" or "Stand" without being busted (exceeding 21).
        // After each player Hit or Stand, dealer's turn to hit or stand.
    }

    public void startGame() {
        //initialize the game.
        // How many players.
        // Deal the card to the players.
    }
    public void convertValue(PlayingCard card) {
        if (card.getRank().equals(CardRank.JACK) || card.getRank().equals(CardRank.QUEEN)
                || card.getRank().equals(CardRank.KING)) {
            card.getRank().setValue(10);
        }

        if (card.getRank().equals(CardRank.ACE)) {
            card.getRank().setValue(11);
        }
    }

    public boolean isBlackJack(Hand hand) {

        int sum = 0;
        for (PlayingCard playingCard : hand.getCards()) {
            sum += playingCard.getRank().getValue();
        }
        return hand.getNumberOfCards() == 2 && sum == 21;
    }

    public void hit(Hand hand) {
        hand.getCards().add(deck.dealCard());
    }

    public void stand() {
        //possibly boolean, not sure yet.
    }

    public boolean isBust(Hand hand) {
        int sum = 0;
        for (PlayingCard playingCard : hand.getCards()) {
            sum += playingCard.getRank().getValue();
        }

        if (sum > 21) {
            for (PlayingCard playingCard : hand.getCards()) {
                if (playingCard.getRank().equals(CardRank.ACE)) {
                    playingCard.getRank().setValue(1);
                    sum -= 10;
                }
            }
        }

        return sum > 21;
    }

    public void dealerTurn() {
//        isBlackjack();
        //if dealer's hand is less than 16, he must hit until it is 16 or higher.
        //if greater than 16, then stand.
    }

    public void rewardWinner(int index, int totalWinning) {
        //call player's winPot method with totalWinning.
        players.get(0); //not finish!
        //reward amount is calculated in the engine.
    }


}

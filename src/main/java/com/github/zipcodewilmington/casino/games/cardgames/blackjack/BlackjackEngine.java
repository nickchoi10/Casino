package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
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

    public void startPrompt() {
        System.out.println("Welcome to Blackjack at Stardust Casino! \n");
        System.out.println("Please choose from the following: 1) Play Game 2) Quit \n Enter 1 or 2 \n");
    }

    public void instructionsPrompt() {
        System.out.println("All players are dealt two cards face up.");
        // Blackjack is usually a table of 2-7 players and uses one to 52-card deck.
        // Jack, Queen, King are all 10 points. Ace is one or 11 points.
        // deal one card face up to all players, then deal second card to all players. AKA deal 2 cards to player.
        // dealer receive two card, one face up and one face down.
        // Objective is to get 21 or be as close you can to 21 without going over.
        // Beginning of game players place their bets.
        // "Hit" or "Stand" without being busted (exceeding 21).
        // After each player Hit or Stand, dealer's turn to hit or stand.
    }

    public static void main(String[] args) {
        BlackjackMain bm = new BlackjackMain();
        bm.run();
    }

    public void startGame() {
        //initialize the game.
        // How many players.
        // Deal the card to the players.
        for (Account account : ActiveAccount.activeAccounts) {
            players.add(new BlackjackPlayer(account));
        }

        for (BlackjackPlayer blackjackPlayer : players) {
            initializeHand(blackjackPlayer.hand);
            blackjackPlayer.updateHandValue();
        }

        initializeHand(dealerHand);
    }

    private void initializeHand(Hand hand) {
        for (int i = 0; i < 2; i++) {
            hand.getCards().add(deck.dealCard());
        }
    }

    public boolean isBlackJack(BlackjackPlayer blackjackPlayer) {
        return blackjackPlayer.getHandValue() == 21
                && blackjackPlayer.getHand().getCards().size() == 2;
    }

    public void hit(BlackjackPlayer blackjackPlayer) {
        blackjackPlayer.hand.getCards().add(deck.dealCard());
        blackjackPlayer.updateHandValue();
    }

    public void stand() {
        //possibly boolean, not sure yet.
    }

    public boolean isBust(BlackjackPlayer blackjackPlayer) {
        if (blackjackPlayer.getHandValue() > 21) {
            blackjackPlayer.recalculateHandValue();
        }
        return blackjackPlayer.getHandValue() > 21;
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

    public void resetGame() {
        deck.reset();
        players = new ArrayList<>();
        dealerHand = new Hand();
    }

    public void printCurrentState() {
        System.out.println("Current game status");
        System.out.printf("\nDealer's hand: %s + Hidden Card", this.dealerHand.getCards().get(0));
        for (BlackjackPlayer blackjackPlayer : this.players) {
            System.out.printf("\nPlayer %s's hand: %s%n", blackjackPlayer.casinoAccount.getAccountName(), blackjackPlayer.hand.getCards());
            System.out.printf("Current hand value: %d%n", blackjackPlayer.handValue);
        }
    }


}

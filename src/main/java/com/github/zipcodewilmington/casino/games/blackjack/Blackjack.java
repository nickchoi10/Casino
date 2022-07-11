package com.github.zipcodewilmington.casino.games.blackjack;

import java.util.Scanner;

public class Blackjack {

    Scanner scanner = new Scanner((System.in));
    Deck deck;
    Dealer dealerHand;
    Player playerHand;

    // BlackJack is usually a table of 2-7 players and uses one to 52-card deck.
    // Jack, Queen, King are all 10 points. Ace is one or 11 points.
    // deal one card face up to all players, then deal second card to all players. AKA deal 2 cards to player.
    // dealer receive two card, one face up and one face down.
    // Objective is to get 21 or be as close you can to 21 without going over.
    // Beginning of game players place their bets.
    // "Hit" or "Stand" without being busted (exceeding 21).
    // After each player Hit or Stand, dealer's turn to hit or stand.
    // Players can also Split, Double Down, Insurance (if dealer's up card is an ace, Surrender (give up half your bet)
    // ^Dunno if we will be having these options yet o.o

    public Blackjack() { //constructor

    }

    public int Blackjack(int balance) { //to take in

    }

    public void startGame() { //welcome the player with rules of BJ?

    }

    public int placeBet() {
        scanner.nextInt();
        return 0;
    }

    public void dealCards() {

    }

    public void checkForBlackjack() {
        if (//sum)

    }

    public String checkForBust() {

    }

    public String hitOrStand() { //hit to get additional card or stand to keep current
        return null;
    }

    public Deck cardFaceUp() {
        return null;
    }

    public Deck cardFaceDown() {
        return null;
    }

}

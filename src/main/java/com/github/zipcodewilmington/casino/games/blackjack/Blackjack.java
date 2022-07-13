package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import com.github.zipcodewilmington.casino.games.cardgames.StandardDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack implements GameInterface {

    Scanner scanner = new Scanner((System.in));
    StandardDeck deck = new StandardDeck();
    BlackjackDealer dealerHand = new BlackjackDealer();
//    BlackjackPlayer playerHand = new BlackjackPlayer();
    List<BlackjackPlayer> players = new ArrayList<>();

    // Blackjack is usually a table of 2-7 players and uses one to 52-card deck.
    // Jack, Queen, King are all 10 points. Ace is one or 11 points.
    // deal one card face up to all players, then deal second card to all players. AKA deal 2 cards to player.
    // dealer receive two card, one face up and one face down.
    // Objective is to get 21 or be as close you can to 21 without going over.
    // Beginning of game players place their bets.
    // "Hit" or "Stand" without being busted (exceeding 21).
    // After each player Hit or Stand, dealer's turn to hit or stand.

    public Blackjack() {

    }

//    public int blackjackBalance(int balance) {
//
//    }

    public void startGame() {
        System.out.println("Welcome to Blackjack at Stardust Casino! \n");
        int numOfPlayers;
        do {
            System.out.println("How many people are playing (1-6)?");
            numOfPlayers = scanner.nextInt();
        } while (numOfPlayers > 6 || numOfPlayers < 0);

        for (int i = 1; i <= numOfPlayers; i++) {
            BlackjackPlayer player = new BlackjackPlayer(i);
            players.add(player); //add player to ArrayList
        }

        for (BlackjackPlayer blackjackPlayer : players) {
            blackjackPlayer.addToHand(dealCards());
            blackjackPlayer.addToHand(dealCards());
        }

    }

    public int placeBet() {
        scanner.nextInt();
        return 0;
    }

    public PlayingCard dealCards() {
        deck.dealCard();
    }

    public void checkForBlackjack() {
//        if (condition) {
//
//        }
    }

    public void hit() {

    }

    public String stand() {
        return null;
    }

    public String checkForBust() {
        return null;
    }

    public void dealerTurn() {

    }

    public double winner() {
        return 0;
    }

    boolean playAgain() {
        return true;

    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

        //run playerSetup().get(account name, balance)

    }



}

package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.*;

import java.util.*;

public class BlackjackEngine {


    StandardDeck deck;
    BlackjackPlayer dealer;
    List<BlackjackPlayer> players;
    Map<BlackjackPlayer, Integer> playerBets;
    //a map to map the players bet to the players.
    //at the end, pass the pot amount to the BlackjackPlayer method winPot.


    public BlackjackEngine() {
        this.deck = new StandardDeck();
        this.dealer = new BlackjackPlayer();
        this.players = new ArrayList<>();
        this.playerBets = new HashMap<>();
    }

    public void startPrompt() {
        System.out.println("Welcome to Blackjack at Stardust Casino! \n");
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

        initializeHand(dealer.hand);
        dealer.updateHandValue();
    }

    private void initializeHand(Hand<PlayingCard> hand) {
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

    public boolean stand() {
        return false;
    }

    public boolean isBust(BlackjackPlayer blackjackPlayer) {
        if (blackjackPlayer.getHandValue() > 21) {
            blackjackPlayer.recalculateHandValue();
        }
        return blackjackPlayer.getHandValue() > 21;
    }

    public boolean dealerBlackjack() {
        if(isBlackJack(this.dealer)) {
            for (BlackjackPlayer blackjackPlayer : players) {
                if (!isBlackJack(blackjackPlayer)) {
                    blackjackPlayer.setGameState(GameState.LOSE);
                } else {
                    blackjackPlayer.setGameState(GameState.DRAW);
                }
            }
            return true;
        }
        return false;
    }

    public boolean dealerTurn() {
        while (dealer.getHandValue() < 16) {
            printFinalState();
            System.out.println("Dealer hits");
            hit(dealer);
            dealer.updateHandValue();
            if(isBust(dealer)) {
                for (BlackjackPlayer blackjackPlayer : players) {
                    if (!blackjackPlayer.getGameState().equals(GameState.LOSE)) {
                        blackjackPlayer.setGameState(GameState.WIN);
                    } else {
                        blackjackPlayer.setGameState(GameState.DRAW);
                    }
                }
                return true;
            }
        }

        for (BlackjackPlayer blackjackPlayer : players) {
            if (!blackjackPlayer.getGameState().equals(GameState.LOSE) && blackjackPlayer.getHandValue() > dealer.getHandValue()) {
                blackjackPlayer.setGameState(GameState.WIN);
            } else if (!blackjackPlayer.getGameState().equals(GameState.LOSE) && blackjackPlayer.getHandValue() == dealer.getHandValue()) {
                blackjackPlayer.setGameState(GameState.DRAW);
            } else {
                blackjackPlayer.setGameState(GameState.LOSE);
            }
        }
        //if dealer's hand is less than 16, he must hit until it is 16 or higher.
        //if greater than 16, then stand.
        return false;
    }

    public void rewardWinner(BlackjackPlayer blackjackPlayer) {
        if (blackjackPlayer.getGameState().equals(GameState.WIN)) {
            blackjackPlayer.getArcadeAccount().deposit(blackjackPlayer.getArcadeAccount(), playerBets.get(blackjackPlayer) * 2);
        } else if (blackjackPlayer.getGameState().equals(GameState.DRAW)) {
            blackjackPlayer.getArcadeAccount().deposit(blackjackPlayer.getArcadeAccount(), playerBets.get(blackjackPlayer));
        }
    }

    public void resetGame() {
        deck.reset();
        players = new ArrayList<>();
        dealer = new BlackjackPlayer();
    }

    public void printCurrentState() {
        System.out.printf("%nCurrent game status");
        System.out.printf("%nDealer's hand: %s + Hidden Card", this.dealer.hand.getCards().get(0));
        for (BlackjackPlayer blackjackPlayer : this.players) {
            System.out.printf("%nPlayer %s's hand: %s%n", blackjackPlayer.getName(), blackjackPlayer.hand.getCards());
            System.out.printf("%nPlayer %s's hand value: %d%n", blackjackPlayer.getName(), blackjackPlayer.handValue);
        }
    }

    public void printFinalState() {
        System.out.printf("%nCurrent game status");
        System.out.printf("%nDealer's hand: %s ", this.dealer.hand.getCards());
        System.out.printf("%nDealer's hand value: %d", this.dealer.getHandValue());
        for (BlackjackPlayer blackjackPlayer : this.players) {
            System.out.printf("%nPlayer %s's hand: %s%n", blackjackPlayer.getName(), blackjackPlayer.hand.getCards());
            System.out.printf("%nPlayer %s's hand value: %d%n", blackjackPlayer.getName(), blackjackPlayer.handValue);
        }
    }


}

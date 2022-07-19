package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
import com.github.zipcodewilmington.casino.games.cardgames.*;

import java.util.*;

public class BlackjackEngine {

    StandardDeck deck;
    BlackjackPlayer dealer;
    List<BlackjackPlayer> players;
    Map<BlackjackPlayer, Integer> playerBets;
    //a map to map the players bet to the players.

    public BlackjackEngine() {
        this.deck = new StandardDeck();
        this.dealer = new BlackjackPlayer();
        this.players = new ArrayList<>();
        this.playerBets = new HashMap<>();
    }

    public void setDealer(BlackjackPlayer dealer) {
        this.dealer = dealer;
    }

    public void startPrompt() {
        System.out.println("Welcome to Blackjack at Stardust Casino! \n");
    }

    public void startGame() {
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
//        if dealer's hand is less than 16, he must hit until it is 16 or higher.
//        if greater than 16, then stand.
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

package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.Dealer;
import com.github.zipcodewilmington.casino.games.cardgames.StandardDeck;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PokerMain implements GameInterface {
    private List<PokerPlayer> players;
    private Dealer<PokerHand, StandardDeck> dealer;
    private ThreeCardPokerEngine engine;
    private PokerState state;

    public void add(PlayerInterface player) {

    }

    public void remove(PlayerInterface player) {

    }

    public void run() {}

    private void handleState(PokerState state, PokerPlayer player) {
        switch (state) {
            case MAIN_MENU:
                int input = getSelectionInput(1, 2, mainMenuText());
                switch (input) {
                    case 1:
                        this.state = state.nextState();
                        handleState(this.state, player);
                    case 2:
                        return;
                }
            case BETTING:
                if (!handleBeforeBets(player)) {
                    System.out.println("You are required to have at least $10 in your balance to play");
                    return;
                }
                state.nextState();
                handleState(this.state, player);
            case DEALING:
                dealer.setHand(new PokerHand(dealer.dealCards(3)));
                player.setHand(new PokerHand(dealer.dealCards(3)));
        }
    }

    public String mainMenuText() {
        StringBuilder res = new StringBuilder();
        res.append("WELCOME TO THREE CARD POKER\nChoose an Option:\n1. Play\n2. Leave");
        return res.toString();
    }

    // TODO Create and throw custom exception of NotE
    /** Gets and adds player's wagers. Returns false if player does not have enough balance to make the minimum ante bet of $5. **/
    public boolean handleBeforeBets(PokerPlayer player) {
        Account acc = player.getArcadeAccount();
        int bal = acc.getBalance();
        if (bal < 10) {
            return false;
        }
        String anteMsg = "Please make an ante wager above 1. You may bet up to %d".formatted(bal);
        int anteWager = getSelectionInput(1, bal, anteMsg);
        player.setAnteBet(anteWager);
        acc.setBalance(bal - anteWager);

        // Get pair plus wager
        bal = acc.getBalance();
        if (bal < 1) {
            return false;
        }
        String pairWagerMsg = "Please make a pair plus wager. Enter 0 to pass. You may bet up to %d".formatted();
        int pairPlusWager = getSelectionInput(0, bal, pairWagerMsg);
        if (pairPlusWager > 0) {
            player.setPairPlusBet(pairPlusWager);
            acc.setBalance(bal - pairPlusWager);
        }
        return true;
    }

    /** Lower and upper bound inclusive **/
    public int getSelectionInput(int lowerBound, int higherBound, String loopMsg) {
        Scanner s = new Scanner(System.in);
        int selection = lowerBound - 1;
        while(selection < lowerBound || selection > higherBound) {
            System.out.println(loopMsg);
            try {
                selection = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
            }
        }
        return selection;
    }

}

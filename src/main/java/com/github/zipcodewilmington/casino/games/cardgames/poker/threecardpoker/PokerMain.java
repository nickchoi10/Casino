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
    private int minimumWager;
    private Scanner scanner;


    public PokerMain() {
        minimumWager = 5;
        scanner = new Scanner(System.in);
    }
    public void add(PlayerInterface player) {

    }

    public void remove(PlayerInterface player) {

    }

    public void run() {}

    private void handleState(PokerState state, PokerPlayer player) {
        Account acc = player.getArcadeAccount();
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
                    System.out.println("You are required to have at least $d in your balance to play".formatted(minimumWager * 2));
                    return;
                }
                state.nextState();
                handleState(this.state, player);
            case DEALING:
                dealer.setHand(new PokerHand(dealer.dealCards(3)));
                player.setHand(new PokerHand(dealer.dealCards(3)));
                player.getHand().printHand();
                System.out.println(foldOrPlayText());
                int choice = getSelectionInput(1, 2,"");
                switch (choice) {
                    case 1:
                        this.state = PokerState.USERFOLD;
                        handleState(this.state, player);
                    case 2:
                        this.state = PokerState.USERPLAY;
                        handleState(this.state, player);
                }
            case USERFOLD:
                System.out.println("You have chosen to fold. Your wagers are now forfeit. Money deducted from account"
                    + "Ante bet: %d\tPair Plus: %d".formatted(player.getAnteBet(), player.getPairPlusBet()));
                acc.setBalance(acc.getBalance() - player.getAnteBet() - player.getPairPlusBet());
                player.setAnteBet(0);
                player.setPairPlusBet(0);
                state.nextState();
                handleState(this.state, player);
            case USERPLAY:
                handlePlayBet(player);
                this.state.nextState();
                handleState(this.state, player);
            case WINNERCALC:
                PokerPlayer dealerPlayer = new PokerPlayer("Dealer", this.dealer.getHand().getCards());
                PokerPlayer winner = engine.computeWinner(player, dealerPlayer);
                handlePairPlus(player);
                if (winner == null) {
                    handlePlayTie(player);
                } else if (winner.equals(player)) {
                    handlePlayWinner(player);
                } else {
                    handlePlayLoser(player);
                }
                this.state = state.nextState();
                handleState(this.state, player);
            case RESULT_MENU:
                String msg = "Do you wish to continue?\n1. Next Round\n2. Quit";
                int in = getSelectionInput(1, 2, "");
                switch (in) {
                    case 1:
                        return;
                    case 2:
                        this.remove(player);
                }
        }
    }

    public String mainMenuText() {
        StringBuilder res = new StringBuilder();
        res.append("WELCOME TO THREE CARD POKER\nChoose an Option:\n1. Play\n2. Leave");
        return res.toString();
    }

    public String foldOrPlayText() {
        StringBuilder res = new StringBuilder();
        res.append("Choose an option below: If you fold you will lose your ante and pair plus wagers.\n" +
                "If you play, you are wagering on a better hand than the dealer");
        res.append("You must make a play wager of at least %d\n\n".formatted(minimumWager));
        res.append("1. Fold\n2. Play(minimum wager: %d".formatted(minimumWager));

        return res.toString();
    }

    public void handlePlayBet(PokerPlayer player) {
        Account acc = player.getArcadeAccount();
        int bal = acc.getBalance();
        if (bal < minimumWager) {
            System.out.println("You do not have enough balance to play, you must fold");
            this.state = PokerState.USERFOLD;
            handleState(this.state, player);
        }
        String msg = "Please make a bet of $%d or more".formatted(minimumWager);
        int wager = getSelectionInput(minimumWager, bal, msg);
        player.setPlayBet(wager);
    }

    private void handlePlayTie(PokerPlayer player) {
        System.out.println("Tie. Wagers returned");
        player.setPlayBet(0);
        player.setAnteBet(0);
    }

    private void handlePlayWinner(PokerPlayer player) {
        Account acc = player.getArcadeAccount();
        boolean isQualifiedDealer = engine.dealerHandQualifies(this.dealer.getHand());
        int anteBet = player.getAnteBet();
        int playBet = player.getPlayBet();
        if (isQualifiedDealer) {
            System.out.println("Dealer hand qualified. You WIN: Ante wager: %d\t Play Wager: %d"
                    .formatted(anteBet, playBet));
            acc.setBalance(acc.getBalance() + anteBet + playBet);
        } else {
            System.out.println("Dealer hand not qualified. You WIN: Ante wager: %d".formatted(anteBet));
            acc.setBalance(acc.getBalance() + anteBet);
        }
        player.setAnteBet(0);
        player.setPlayBet(0);
    }

    private void handlePairPlus(PokerPlayer player) {
        boolean isPairPlus = player.getHand().getRank() != ThreePokerHandRank.HIGH_CARD;
        Account acc = player.getArcadeAccount();
        int pairBet = player.getPairPlusBet();
        if (isPairPlus) {
            System.out.println("You've won the pair plus bet with your %s hand. Pair Plus wager: %d"
                    .formatted(player.getHand().getRank().toString(), pairBet));
            acc.setBalance(acc.getBalance() + pairBet);
        } else {
            System.out.println("You've lost the pair plus bet. Pair Plus wager: %d".formatted(pairBet));
            acc.setBalance(acc.getBalance() - pairBet);
        }
        player.setPairPlusBet(0);
    }

    private void handlePlayLoser(PokerPlayer player) {
        System.out.println("You've lost. The following will be withdrawn from your account: Play wager: %d\n Ante wager: %d"
                .formatted(player.getPlayBet(), player.getAnteBet()));
        Account acc = player.getArcadeAccount();
        acc.setBalance(acc.getBalance() - player.getAnteBet() - player.getPlayBet());
    }

    // TODO Create and throw custom exception of NotE
    /** Gets and adds player's wagers. Returns false if player does not have enough balance to make the minimum ante bet of $5. **/
    public boolean handleBeforeBets(PokerPlayer player) {
        Account acc = player.getArcadeAccount();
        int bal = acc.getBalance();
        if (bal < minimumWager * 2) {
            System.out.println("You do not have enough balance to play");
            return false;
        }
        String anteMsg = "Please make an ante wager above 1. You may bet up to %d".formatted(bal);
        int anteWager = getSelectionInput(1, bal, anteMsg);
        player.setAnteBet(anteWager);

        // Get pair plus wager
        if (bal - anteWager - minimumWager < 0) {
            System.out.println("Not enough balance remaining to make minimum play bet");
            return false;
        }
        String pairWagerMsg = "Please make a pair plus wager. Enter 0 to pass. You may bet up to %d".formatted();
        int pairPlusWager = getSelectionInput(0, bal, pairWagerMsg);
        if (pairPlusWager > 0) {
            player.setPairPlusBet(pairPlusWager);
        }
        return true;
    }

    /** Lower and upper bound inclusive **/
    public int getSelectionInput(int lowerBound, int higherBound, String loopMsg) {
        scanner = new Scanner(System.in);
        int selection = lowerBound - 1;
        while(selection < lowerBound || selection > higherBound) {
            System.out.println(loopMsg);
            try {
                selection = scanner.nextInt();
                if (selection < lowerBound) {
                    System.out.println("Your input is below the minimum");
                } else {
                    System.out.println("Your input is above the maximum");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
            }
        }
        return selection;
    }

}

package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.Dealer;
import com.github.zipcodewilmington.casino.games.cardgames.Deck;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import com.github.zipcodewilmington.casino.games.cardgames.StandardDeck;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
        engine = new ThreeCardPokerEngine();
        dealer = new Dealer<>(new PokerHand(), new StandardDeck());
        state = PokerState.MAIN_MENU;
    }
    public void add(PlayerInterface player) {

    }

    public void remove(PlayerInterface player) {

    }

    public void run() {}

    public static void main(String[] args) {
        PokerMain poker = new PokerMain();
        Account acc = new Account("1", "2", 1000);
        PokerPlayer player = new PokerPlayer("Jeff");
        player.account = acc;
        poker.handleState(poker.getState(), player);
    }

    private void handleState(PokerState state, PokerPlayer player) {
        Account acc = player.getArcadeAccount();

        switch (state) {
            case MAIN_MENU:
                int input = getSelectionInput(1, 2, mainMenuText());
                switch (input) {
                    case 1:
                        this.state = this.state.nextState();
                        handleState(this.state, player);
                        return;
                    case 2:
                        return;
                }


            case BETTING:
                if (!hasBalance(player, acc.getBalance(), minimumWager * 2)) {
                    return;
                }
                int ante = askAnteWager(player, acc.getBalance());
                int pairPlus = askPairPlusWager(player, acc.getBalance() - ante);
                if (!hasBalance(player, acc.getBalance() - ante - pairPlus, minimumWager)) {
                    return;
                }
                setBeforeBets(player, ante, pairPlus);
                this.state = this.state.nextState();
                handleState(this.state, player);
                return;


            case DEALING:
                System.out.println("DEALING...");
                dealer.setHand(new PokerHand(dealer.dealCards(3, PlayingCard.class)));
                player.setHand(new PokerHand(dealer.dealCards(3, PlayingCard.class)));
                player.getHand().printHand();
                System.out.println(String.format("YOUR HAND: %s", player.getHand().getRank()));
                System.out.println("\n\n" + foldOrPlayText());
                int choice = getSelectionInput(1, 2,"");
                switch (choice) {
                    case 1:
                        this.state = PokerState.USERFOLD;
                        handleState(this.state, player);
                        return;
                    case 2:
                        this.state = PokerState.USERPLAY;
                        handleState(this.state, player);
                        return;
                }


            case USERFOLD:
                System.out.println("You are folding for this round. Your wagers are now forfeit. Money deducted from account\n"
                    + String.format("Ante bet: %d\tPair Plus: %d\nBalance: %d(-%d)", player.getAnteBet(), player.getPairPlusBet(),
                        acc.getBalance(), player.getAnteBet() + player.getPairPlusBet()));
                handleFold(player);
                this.state = this.state.nextState();
                handleState(this.state, player);
                return;


            case USERPLAY:
                int playBet = getPlayBet(player, acc.getBalance() - player.getAnteBet() - player.getPairPlusBet());
                if (!handlePlayBet(player, playBet)) {
                    this.state = PokerState.USERFOLD;
                    handleState(this.state, player);
                    return;
                }
                this.state = this.state.nextState();
                handleState(this.state, player);
                return;


            case WINNERCALC:
                PokerHand dealerHand = this.dealer.getHand();
                PokerPlayer dealerPlayer = new PokerPlayer("Dealer", dealerHand.getCards());
                PokerPlayer winner = engine.computeWinner(player, dealerPlayer);
                System.out.println(String.format("DEALER HAND: %s", dealerHand.getRank().toString()));
                dealerHand.printHand();
                handlePairPlusResult(player);
                if (winner == null) {
                    handlePlayTie(player);
                } else if (winner.equals(player)) {
                    handlePlayWinner(player);
                } else {
                    deductFromPlayLoser(player);
                }
                this.state = this.state.nextState();
                handleState(this.state, player);
                return;


            case RESULT_MENU:
                String msg = "Do you wish to continue?\n1. Next Round\n2. Quit";
                int in = getSelectionInput(1, 2, msg);
                switch (in) {
                    case 1:
                        return;
                    case 2:
                        this.remove(player);
                        return;
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
                "If you play, you are wagering on a better hand than the dealer.\n");
        res.append("You must make a play wager of at least %d\n\n".formatted(minimumWager));
        res.append("1. Fold\n2. Play(minimum wager: %d)".formatted(minimumWager));

        return res.toString();
    }

    public void handleFold(PokerPlayer player) {
        Account acc = player.getArcadeAccount();
        acc.setBalance(acc.getBalance() - player.getAnteBet() - player.getPairPlusBet());
        player.setAnteBet(0);
        player.setPairPlusBet(0);
    }

    public int getPlayBet(PokerPlayer player, int balance) {
        String msg = "Please make a wager of %d or more. Balance: %d".formatted(minimumWager, balance);
        int wager = getSelectionInput(minimumWager, balance, msg);
        return wager;
    }

    /** Returns false if player does not have enough balance to meet their play bet or the minimum **/
    public boolean handlePlayBet(PokerPlayer player, int wager) {
        Account acc = player.getArcadeAccount();
        int bal = acc.getBalance() - player.getAnteBet() - player.getPairPlusBet();
        if (bal < minimumWager || bal < wager ) {
            System.out.println("You do not have enough balance to play, you must fold!");
            return false;
        }
        player.setPlayBet(wager);
        return true;
    }

    protected void handlePlayTie(PokerPlayer player) {
        System.out.println("Tie. Wagers returned");
        player.setAnteBet(0);
        player.setPlayBet(0);
    }

    protected void handlePlayWinner(PokerPlayer player) {
        Account acc = player.getArcadeAccount();
        boolean isQualifiedDealer = engine.dealerHandQualifies(this.dealer.getHand());
        int anteBet = player.getAnteBet();
        int playBet = player.getPlayBet();
        if (isQualifiedDealer) {
            int newBal = acc.getBalance() + anteBet + playBet;
            System.out.println("Dealer hand QUALIFIED. You WIN:\nAnte wager: %d\nPlay Wager: %d\nBalance: %d(+%d)"
                    .formatted(anteBet, playBet, newBal, anteBet + playBet));
            acc.setBalance(newBal);
        } else {
            System.out.println(("Dealer hand NOT QUALIFIED." +
                    " You WIN:\nAnte wager: %d\nBalance: %d(+%d)").formatted(anteBet, acc.getBalance() + anteBet, anteBet));
            acc.setBalance(acc.getBalance() + anteBet);
        }
        player.setAnteBet(0);
        player.setPlayBet(0);
    }

    protected void handlePairPlusResult(PokerPlayer player) {
        boolean isPairPlus = player.getHand().getRank() != ThreePokerHandRank.HIGH_CARD;
        Account acc = player.getArcadeAccount();
        int pairBet = player.getPairPlusBet();
        if (isPairPlus) {
            int addBal = acc.getBalance() + pairBet;
            System.out.println("You've won the pair plus bet with your %s hand.\nPair Plus wager: %d\nBalance: %d(+%d)"
                    .formatted(player.getHand().getRank().toString(), pairBet, addBal, pairBet));
            acc.setBalance(addBal);
        } else {
            int subBal = acc.getBalance() - pairBet;
            System.out.println(("You've lost the pair plus bet with your HIGH CARD hand." +
                    " Pair Plus wager: %d\nBalance: %d(-%d)").formatted(pairBet, subBal, pairBet));
            acc.setBalance(subBal);
        }
        player.setPairPlusBet(0);
    }

    protected void deductFromPlayLoser(PokerPlayer loserPlayer) {
        System.out.println("You've lost. The following will be withdrawn from your account: \nPlay wager: %d\n Ante wager: %d"
                .formatted(loserPlayer.getPlayBet(), loserPlayer.getAnteBet()));
        Account acc = loserPlayer.getArcadeAccount();
        acc.setBalance(acc.getBalance() - loserPlayer.getAnteBet() - loserPlayer.getPlayBet());
        System.out.println(String.format("Your balance is: %d", loserPlayer.getArcadeAccount().getBalance()));
    }


    public int askAnteWager(PokerPlayer player, int balance) {
        String anteMsg = "Please make an ante wager above %d. You may bet up to %d".formatted(minimumWager, balance);
        int anteWager = getSelectionInput(minimumWager, balance, anteMsg);
        return anteWager;
    }

    public int askPairPlusWager(PokerPlayer player, int balance) {
        String pairWagerMsg = "Please make a pair plus wager. Enter 0 to pass. You may bet up to %d".formatted(balance);
        int pairPlusWager = getSelectionInput(0, balance, pairWagerMsg);
        return pairPlusWager;
    }

    public boolean hasBalance(PokerPlayer player, int balance, int minimum) {
        if (balance < minimum) {
            System.out.println("You do not have enough balance to play");
            return false;
        }
        return true;
    }

    public void setBeforeBets(PokerPlayer player, int anteWager, int pairPlusWager) {
        player.setAnteBet(anteWager);
        if (pairPlusWager > 0) {
            player.setPairPlusBet(pairPlusWager);
        }
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
                } else if (selection > higherBound) {
                    System.out.println("Your input is above the maximum");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }
        return selection;
    }

    public PokerState getState() {
        return state;
    }

    public void setState(PokerState state) {
        this.state = state;
    }

    public Dealer<PokerHand, StandardDeck> getDealer() {
        return this.dealer;
    }

}

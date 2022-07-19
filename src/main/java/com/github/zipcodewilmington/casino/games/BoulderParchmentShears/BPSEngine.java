package com.github.zipcodewilmington.casino.games.BoulderParchmentShears;
import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
import com.github.zipcodewilmington.utils.TheScanner;
import java.util.Random;
import java.util.Scanner;

public class BPSEngine {
    final String GREEN_BRIGHT = "\033[0;92m";
    private Casino casino;
    private ActiveAccount aa;
    private Account acct;
    static Random randy = new Random();
    static Integer botRoll = 0;
    static String botThrow;

    public void intro(int numPlayers){
        aa = new ActiveAccount();
        acct = new Account();
        casino = new Casino();
        int choice;
        System.out.println(GREEN_BRIGHT + "\nWelcome to Boulder Parchment Shears!\nThe game of mental dominance over your foes.\n");
        if (numPlayers == 1) {
            System.out.println("Since there is one player, you will be competing against our high-tech AI.");
            PvE();
        } else if (numPlayers == 2) {
            PvP();
        }
    }
    public void BPSRules2P() {
        System.out.println(GREEN_BRIGHT + "The rules are simple. Boulder beats Shears, Shears beats Parchment, Parchment beats Boulder.\n" +
                "Each player will make the same wager, winner gets all.\n\n");
    }

    //1-PLAYER GAME STUFF
    public void PvE() {
        int wager;
        String p1;
        String p2;
        BPSRules2P();
        System.out.println(GREEN_BRIGHT + "How much do you want to wager?\n");
        wager = acct.makeBet(aa.activeAccounts.get(0));
        p1 = getThrow(1);
        p2 = AIThrow();
        threw(p1);
        threw(p2);
        if (pveWin(p1, p2, wager) == true)  {
            acct.deposit(ActiveAccount.activeAccounts.get(0), (wager*2));
        } else if (draw(p1, p2)) {
            acct.deposit(ActiveAccount.activeAccounts.get(0), (wager));
            PvE();
        } else System.out.println(ActiveAccount.activeAccounts.get(0).getAccountName() + " threw " + p1 + " and the AI threw " + p2 + "." +
                ActiveAccount.activeAccounts.get(0).getAccountName() + " lost :(\n\n");
        quitPvE();
    }
    public void quitPvE(){
        int choice;
        choice = TheScanner.getNumber(GREEN_BRIGHT + "\n 1) Play Again\n2) Return to Main Menu\n");
        if (choice == 1) {PvE();}
        else casino.splashScreen();
    }
    public boolean pveWin(String p1, String p2, int wager){
        if (p1.equals(getWinner2P(p1, p2))) {
            System.out.println(GREEN_BRIGHT + ActiveAccount.activeAccounts.get(0).getAccountName() + " Wins! \n" +
                    ActiveAccount.activeAccounts.get(0).getAccountName() + " threw " + p1 + " and the AI threw " + p2 + ".\n" +
                    "You wagered " + wager + " and won " + (wager*2) + ". That amount has been deposited in your account.\n");
            acct.deposit(ActiveAccount.activeAccounts.get(0), (wager*2));
            return true;}
        else return false;
    }
    public boolean draw(String p1, String p2) {
        if (p1.equals(p2)) {
            System.out.println(GREEN_BRIGHT + "It's a draw! Wager's have been returned, play again.");
            return true;}
        else return false;
    }

    //2-PLAYER GAME STUFF
    public void PvP() {
        int wager;
        String p1;
        String p2;
        BPSRules2P();
        System.out.println(GREEN_BRIGHT + ActiveAccount.activeAccounts.get(0).getAccountName() + ", how much do the players want to wager?\n");
        wager = acct.makeBet(ActiveAccount.activeAccounts.get(0));
        acct.withdraw(ActiveAccount.activeAccounts.get(1), wager);
        p1 = getThrow(1);
        p2 = getThrow(2);
        threw(p1);
        threw(p2);
        if (draw(p1, p2)) {
            PvP();
        } else pvpWin(p1, p2, wager);
        quitPvP();
    }
    public void quitPvP(){
        int choice;
        choice = TheScanner.getNumber(GREEN_BRIGHT + "\n1) Play Again\n2) Return to Main Menu\n");
        if (choice == 1) {PvP();}
        else casino.splashScreen();
    }
    public boolean pvpWin(String p1, String p2, int wager){
        if (p1.equals(getWinner2P(p1, p2))) {
            System.out.println(GREEN_BRIGHT + ActiveAccount.activeAccounts.get(0).getAccountName() + " threw " + p1 + " and " + ActiveAccount.activeAccounts.get(1).getAccountName() + " threw " + p2 +  ".\n\n" +
                    ActiveAccount.activeAccounts.get(0).getAccountName() + " WINS!!\n" +
                    "You wagered " + wager + " and won " + (wager*2) + ". That amount has been deposited in your account.\n");
            acct.deposit(ActiveAccount.activeAccounts.get(0), (wager*2));
            return true;
        } else {
            System.out.println(GREEN_BRIGHT + ActiveAccount.activeAccounts.get(1).getAccountName() + " threw " + p2 + " and " + ActiveAccount.activeAccounts.get(0).getAccountName() + " threw " + p1 +  ".\n\n" +
                    ActiveAccount.activeAccounts.get(1).getAccountName() + " WINS!!\n" +
                    "You wagered " + wager + " and won " + (wager*2) + ". That amount has been deposited in your account.\n");
            acct.deposit(ActiveAccount.activeAccounts.get(1), (wager*2));
            return false;}
    }


    public String getThrow(int player){
        String pt;
        System.out.println(GREEN_BRIGHT + "Player " + player + ", pick your sign.\n" +
                "1) Boulder\n" +
                "2) Parchment\n" +
                "3) Shears");
        while (true) {
            int choice = TheScanner.getNumber("");
            if (choice == 1) {
                pt = "boulder";
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            } else if (choice == 2) {
                pt = "parchment";
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            } else if (choice == 3) {
                pt = "shears";
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            } else System.out.println(GREEN_BRIGHT + "That is not a valid choice, choose 1, 2, or 3.");
        }
        return pt;
    }
    public String AIThrow(){
        botRoll = (randy.nextInt(3)+1);
        if (botRoll == 1) {botThrow = "boulder";}
        else if (botRoll == 2) {botThrow = "parchment";}
        else botThrow = "shears";
        return botThrow;
    }
    public String getWinningMove(String handSign) {
        if (handSign.equals("boulder")) {
            return "parchment";
        } else if (handSign.equals("parchment")) {
            return "shears";
        } else return "boulder";
    }
    public String getLosingMove(String handSign) {
        if (handSign.equals("boulder")) {
            return "shears";
        } else if (handSign.equals("parchment")) {
            return "boulder";
        } else return "parchment";
    }
    public String getWinner2P(String player1, String player2) {
        String oneWinner = getLosingMove(player1);
        String oneLoser = getLosingMove(player1);
        if (player2.equals(oneWinner)) {return player1;}
        else if (player2.equals(oneLoser)) {return player2;}
        else {return "draw";}
    }

    public void threw(String p) {
        String hands = "";
        switch (p) {
            case "boulder":
                hands = GREEN_BRIGHT + """
                    _______
                ---'   ____)
                      (_____)
                      (_____) BOULDER!
                      (____)
                ---.__(___)
                        """;
                break;
            case "parchment":
                hands = GREEN_BRIGHT + """
                    _______
                ---'   ____)____
                          ______)
                          _______) PARCHMENT!
                         _______)
                ---.__________)
                        """;
                break;
            case "shears":
                hands = GREEN_BRIGHT + """
                    _______
                ---'   ____)____
                          ______)
                       __________) SHEARS!
                      (____)
                ---.__(___)
                        """;
                break;
        }
        System.out.println(hands);
    }
}

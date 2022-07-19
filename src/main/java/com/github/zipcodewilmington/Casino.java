package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
import com.github.zipcodewilmington.casino.games.BoulderParchmentShears.BPSMain;
import com.github.zipcodewilmington.casino.games.cardgames.blackjack.BlackjackMain;
import com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker.PokerMain;
import com.github.zipcodewilmington.casino.games.dicegames.highlowdice.HighLowDiceMain;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessMain;
import com.github.zipcodewilmington.casino.games.roulette.RouletteMain;
import com.github.zipcodewilmington.casino.games.slots.SlotMain;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.Scanner;

import static com.github.zipcodewilmington.utils.AnsiColor.CYAN;

public class Casino implements Runnable {
    private NumberGuessMain ngm;
    private Account acct;
    private SlotMain sm;
    private RouletteMain rm;
    private PokerMain pokey;
    private HighLowDiceMain hldm;
    private ActiveAccount aa;
    private BPSMain bps;
    private BlackjackMain bjm;

    @Override
    public void run() {
        splashScreen();
    }

    public void splashScreen(){
        final String TEXT_RESET = "\u001B[0m"; // RESET TO DEFAULT
        final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        final String RED_BRIGHT = "\033[0;91m";    // RED
        final String CYAN = "\u001B[36m";
        System.out.println(YELLOW_BRIGHT + """
                 WELCOME TO...
                 
                 .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.\s
                | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |
                | |    _______   | || |  _________   | || |      __      | || |  _______     | || |  ________    | || | _____  _____ | || |    _______   | || |  _________   | |
                | |   /  ___  |  | || | |  _   _  |  | || |     /  \\     | || | |_   __ \\    | || | |_   ___ `.  | || ||_   _||_   _|| || |   /  ___  |  | || | |  _   _  |  | |
                | |  |  (__ \\_|  | || | |_/ | | \\_|  | || |    / /\\ \\    | || |   | |__) |   | || |   | |   `. \\ | || |  | |    | |  | || |  |  (__ \\_|  | || | |_/ | | \\_|  | |
                | |   '.___`-.   | || |     | |      | || |   / ____ \\   | || |   |  __ /    | || |   | |    | | | || |  | '    ' |  | || |   '.___`-.   | || |     | |      | |
                | |  |`\\____) |  | || |    _| |_     | || | _/ /    \\ \\_ | || |  _| |  \\ \\_  | || |  _| |___.' / | || |   \\ `--' /   | || |  |`\\____) |  | || |    _| |_     | |
                | |  |_______.'  | || |   |_____|    | || ||____|  |____|| || | |____| |___| | || | |________.'  | || |    `.__.'    | || |  |_______.'  | || |   |_____|    | |
                | |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |
                | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |
                 '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'\s
                                     .----------------.  .----------------.  .----------------.  .----------------.  .-----------------. .----------------.                    \s
                                    | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |                   \s
                                    | |     ______   | || |      __      | || |    _______   | || |     _____    | || | ____  _____  | || |     ____     | |                   \s
                                    | |   .' ___  |  | || |     /  \\     | || |   /  ___  |  | || |    |_   _|   | || ||_   \\|_   _| | || |   .'    `.   | |                   \s
                                    | |  / .'   \\_|  | || |    / /\\ \\    | || |  |  (__ \\_|  | || |      | |     | || |  |   \\ | |   | || |  /  .--.  \\  | |                   \s
                                    | |  | |         | || |   / ____ \\   | || |   '.___`-.   | || |      | |     | || |  | |\\ \\| |   | || |  | |    | |  | |                   \s
                                    | |  \\ `.___.'\\  | || | _/ /    \\ \\_ | || |  |`\\____) |  | || |     _| |_    | || | _| |_\\   |_  | || |  \\  `--'  /  | |                   \s
                                    | |   `._____.'  | || ||____|  |____|| || |  |_______.'  | || |    |_____|   | || ||_____|\\____| | || |   `.____.'   | |                   \s
                                    | |              | || |              | || |              | || |              | || |              | || |              | |                   \s
                                    | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |                   \s
                                     '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'                   \s
                
                Press Enter to GAMBLE!\n""" + TEXT_RESET);



        try {System.in.read();}
        catch (Exception e) {}

        mainMenu();
    }

    public void mainMenu(){
        final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        final String TEXT_RESET = "\u001B[0m"; // RESET TO DEFAULT
        aa = new ActiveAccount();
        int menuChoice;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("""
                               (( _______
                     _______     /\\O    O\\
                    /O     /\\   /  \\      \\
                   /   O  /O \\ / O  \\O____O\\ ))
                ((/_____O/    \\\\    /O     /
                  \\O    O\\    / \\  /   O  /
                   \\O    O\\ O/   \\/_____O/
                    \\O____O\\/ ))          ))
                  ((
                  
                  
                """);

        System.out.println("Welcome to the " + CYAN_BRIGHT + "STAR" + YELLOW_BRIGHT + "DUST" + TEXT_RESET + " VIP Casino and Lounge!\n");

        while (true) {
            menuChoice = TheScanner.getNumber("Please choose one of the following options by entering it's number: \n" +
                    "1) Play Games\n" +
                    "2) Create New STARDUST VIP Account\n" +
                    "3) Manage Accounts\n" +
                    "4) Go to the Lounge\n" +
                    "5) Leave Casino\n");
            if (menuChoice >= 1 && menuChoice <= 5) {
                break;
            } else System.out.println("That is not a valid choice, please choose a valid menu choice.\n");
        }
        if (menuChoice == 1) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            pickGame();
        } else if (menuChoice == 2) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            createAccount();
        } else if (menuChoice == 3) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            aa.activeAccountManager();
        } else if (menuChoice == 4) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            lounge();
        } else if (menuChoice == 5) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            quit();
        }
    }

    public void createAccount(){
        acct = new Account();
        Scanner scan = new Scanner(System.in);
        System.out.println("Thank you for choosing to create an account with us here at the STARDUST VIP Casino!\n" +
                "Please enter a username for your account!\n");
        String acctName;
        while(true) {
            acctName = scan.nextLine();
            if (!acct.accountExists(acctName)){break;}
            else System.out.println("An account by that name already exists, please choose another name\n");
        }
        System.out.println("Excellent Choice! Welcome to the STARDUST VIP Club " + acctName +
                "Please enter a password for your account.\n\n");
        String password = scan.nextLine();
        System.out.println("Your password is safe with us, " + acctName + ". You can count on us keeping your password (" + password + ") safe.\n\n");
        int balance;
        while(true) {
            balance = TheScanner.getNumber("How much you would like to deposit in your account.\n\n");
            if (balance > 100000){
                System.out.println("Whoa there moneybags, we can't be responsible for THAT much money. Pick something lower.\n");
            }else break;
        }

        System.out.println("Thank you! Your account is now prepared and logged in!\n" +
                "Enjoy your time at the STARDUST VIP Casino and Lounge!!!!");
        Account account = new Account(acctName, password, balance);
        mainMenu();
    }


    public void pickGame(){
        rm = new RouletteMain();
        ngm = new NumberGuessMain();
        bps = new BPSMain();
        hldm = new HighLowDiceMain();
        bjm = new BlackjackMain();
        sm = new SlotMain();
        pokey = new PokerMain(ActiveAccount.activeAccounts.toArray(new Account[0]));

        int menuChoice;
        while (true) {
            menuChoice = TheScanner.getNumber("Enter a number for the game you would like to play below:\n" +
                    "1) Slot Machines\n" +
                    "2) Three Card Poker\n" +
                    "3) Roulette\n" +
                    "4) High-Low Dice\n" +
                    "5) Number Guess Game (No Gambling)\n" +
                    "6) Boulder Parchment Shears\n" +
                    "7) Blackjack\n" +
                    "8) Return to Main Menu\n" +
                    "9) Leave Casino\n");
            if (menuChoice >= 1 && menuChoice <= 8) {
                break;
            } else System.out.println("That is not a valid choice, please choose a number from the menu.\n");
        }
        if (menuChoice == 1) {
            sm.startSlot();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        } else if (menuChoice == 2) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            pokey.run();
        }else if (menuChoice == 3) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            rm.playRoulette();
        }else if (menuChoice == 4) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            hldm.playGame();
        }else if (menuChoice == 5) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            ngm.playGame();
        }else if (menuChoice == 6) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            bps.playBPS();
        }else if (menuChoice == 7) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            bjm.run();
        }else if (menuChoice == 8) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            splashScreen();
        }else if (menuChoice == 9) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            quit();
        }
    }

    public void quit(){
        System.out.println("Thank you for visiting the STARDUST VIP Casino! Please visit again soon!");
        System.exit(0);
    }

    public void lounge(){
        System.out.println("""
                |\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\s
                |. . . . . . . . . . .[___|___|___|___|___|__]. . . . . . . . . . . . . . . .|
                | . . . .  _  . . . . [_|___|___|___|___|___|] . .  _  . . . . . . .  _  . . |
                |. . . .  /_\\  . . . .[__|___|___|___|___|___]. .  /_\\  . . . . . .  /_\\  . .|
                | . . . . =|= . . . . [_|___/          \\___|_] . . =|= . . . . . . . =|= . . |
                |. . . . . . . . . . .[|___| ~ LOUNGE ~ |___|]. . . . . . . . . . . . . . . .|
                |=====================[__|__\\__________/_|___]================____===========|
                |                     [___|___|___|___|___|__]               | |  \\          |
                |           ,         [_|___|___|___|___|___|]               | |   \\_______  |
                |          ,I,    ,;,/________________________\\,;,          _|_|___________) |
                |/|   ____;(;);__;(;);                        ;(;); /|     /   | ,.________) |
                |||__ !!!!!;;;!!!!=;============================;=  ||__  /____|/ .________| |
                ||/_/|!!!!!!;!!!!!![_|_|_]================[_|_|_]___|/_/|_|______/_______)(__lc
                /|' |'  |'     '|  [__|__]       `(       [__|__]   |' |'[|)(            ()   \\
                 '  '   '       '  [_|_|_] o     ) (    o [_|_|_]   '  '   ()                  \s
                                   [__|__] |    ( ) )   | [__|__]                      ,
                                   [_|_|_] |---@@@@@@---| [_|_|_]           /|        ,I,       |\\  \s
                                   [__|__]/!\\ @@@@@@@@ /!\\[__|__]           ||   ____;(;);____  ||
                                  /______________________________\\          ||__ !!!!!;;;!!!!!__||
                   ,             |________________________________|         |/_/|!!!!!!;!!!!!!\\_\\|
                  ,I,       |\\   `================================`         || ||  ||     || || ||
                _;(;);____  ||  `==================================`        |  |   |       |  |  |
                !!;;;!!!!!__|| `====================================`
                !!!;!!!!!!\\_\\|
                ====================================================================================
                 ~@~    Welcome to the Lounge. Relax, have a drink, and press Enter to leave     ~@~
                """);
        try {
            System.in.read();
        } catch (Exception e) {
        } mainMenu();
    }
}
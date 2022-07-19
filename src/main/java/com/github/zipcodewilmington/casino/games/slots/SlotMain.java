package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.ActiveAccount;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessEngine;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.Ascii;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Scanner;

public class SlotMain {
    static IOConsole ioConsole = new IOConsole(AnsiColor.PURPLE);
    private ActiveAccount aa;
    SlotsEngine run = new SlotsEngine();
    private Casino casino;
    static boolean running = true;
    static int input;

    static Scanner scanner = new Scanner(System.in);

    public void startSlot() {
        aa = new ActiveAccount();
        aa.numPlayers(1);
        casino = new Casino();
//        SlotsEngine run = new SlotsEngine();
        run.beginMessage();
        Ascii.printAscii("SLOTS", "\"", 300, 20, 24);
//        run.beginningBalance();
        System.out.println("Hello, welcome to the StarDust's Slot Game\n" +
                "Match 3 numbers across the board, you win your bet amount!\n" +
                "Triple 7 in middle row is *JACKPOT*. You win 500x bet amount!\n" +
                "Good Luck!");

        if (input == 2) {
            running = false;
            casino.splashScreen();
        }
        while (running) {
            run.currentBalance();
            System.out.println("Please Enter Bet amount: ");
            run.betMessage();
            run.inputBet();
            run.clearArray();
            run.spinSlot();
            run.displayBoard();
            run.winConditions(run.slotList);
//            run.winConditions1(run.slotList);
            run.jackPotCondition(run.slotList);
            run.losingCondition();
            run.continuePlaying();
            ioConsole = new IOConsole(AnsiColor.AUTO);
            ioConsole.println("Do you want to continue playing?\n1) Continue 2) Quit\n");
            input = scanner.nextInt();
            //guessEngine.getInput();
            if (input == 1) {
                continue;
            } else if (input == 2) {
                running = false;
                casino.splashScreen();
            }
        }

    }
}

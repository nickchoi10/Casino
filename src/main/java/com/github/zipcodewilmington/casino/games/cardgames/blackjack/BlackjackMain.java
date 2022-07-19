package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.TheScanner;

public class BlackjackMain implements GameInterface {
    BlackjackEngine blackjackEngine;
    ActiveAccount activeAccount;
    boolean gameOn;


    public BlackjackMain() {
        blackjackEngine = new BlackjackEngine();
        activeAccount = new ActiveAccount();
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    public static void main(String[] args) {
        BlackjackMain bm = new BlackjackMain();
        bm.run();
    }
    @Override
    public void run() {
        gameOn = true;
        blackjackEngine.startPrompt();
        blackjackEngine.instructionsPrompt();
        int input = TheScanner.getNumber("Please choose from the following: 1) Play Game 2) Quit \nEnter 1 or 2 \n");
        while(gameOn){
            if(input == 1){
                activeAccount.numPlayers(6);
                System.out.println(ActiveAccount.activeAccounts.size());
                blackjackEngine.startGame();

                for (BlackjackPlayer blackjackPlayer : blackjackEngine.players) {
                    System.out.printf("%s, You currently have: %d%nHow much would you like to wager?%n", blackjackPlayer.getName(), blackjackPlayer.getArcadeAccount().getBalance());
                    blackjackEngine.playerBets.put(blackjackPlayer, blackjackPlayer.placeBet());
                }

                blackjackEngine.printCurrentState();

                if (blackjackEngine.dealerBlackjack()) {
                    blackjackEngine.printFinalState();
                    System.out.println("Dealer BLACKJACK!");
                    for (BlackjackPlayer blackjackPlayer : blackjackEngine.players) {
                        if (blackjackPlayer.getGameState() == GameState.DRAW) {
                            System.out.printf("%s also BLACKJACK! You win your money back", blackjackPlayer.getName());
                            blackjackEngine.rewardWinner(blackjackPlayer);
                        } else {
                            System.out.printf("Sorry %s! You lost your bet.%n", blackjackPlayer.getName());
                        }
                    }
                    blackjackEngine.resetGame();
                    continue;
                }

                for(BlackjackPlayer blackjackPlayer : blackjackEngine.players) {
                    boolean currentTurn = true;
                    while (currentTurn) {
                        System.out.printf("Current turn : %s%n", blackjackPlayer.getName());
                        int choice = TheScanner.getNumber("1 to hit, 2 to stand\n");
                        if (choice == 1) {
                            blackjackEngine.hit(blackjackPlayer);
                            blackjackEngine.printCurrentState();
                            if (blackjackEngine.isBust(blackjackPlayer)) {
                                System.out.println("Sorry you lost!");
                                blackjackPlayer.setGameState(GameState.LOSE);
                                currentTurn = false;
                            }
                        } else if (choice == 2) {
                            currentTurn = blackjackEngine.stand();
                        } else {
                            System.out.println("Not a valid number");
                        }
                    }
                }

                if(blackjackEngine.dealerTurn()) {
                    System.out.println("Dealer BUST!");

                }

                blackjackEngine.printFinalState();

                for (BlackjackPlayer blackjackPlayer : blackjackEngine.players) {
                    if (blackjackPlayer.getGameState().equals(GameState.WIN)) {
                        System.out.printf("%nCONGRATULATIONS %s, you won %d chips!%n", blackjackPlayer.getName(), blackjackEngine.playerBets.get(blackjackPlayer) * 2);
                        blackjackEngine.rewardWinner(blackjackPlayer);
                    } else if (blackjackPlayer.getGameState().equals(GameState.DRAW)) {
                        System.out.printf("%n%s, you draw and get your %d chips back!%n", blackjackPlayer.getName(), blackjackEngine.playerBets.get(blackjackPlayer));
                        blackjackEngine.rewardWinner(blackjackPlayer);
                    } else {
                        System.out.printf("%nSorry %s, you lost %d chips!%n", blackjackPlayer.getName(), blackjackEngine.playerBets.get(blackjackPlayer));
                    }
                }

                blackjackEngine.resetGame();

                int continueChoice = TheScanner.getNumber("Do you want to keep playing? 1 - yes, 2 - no\n");
                if (continueChoice == 1) {
                    input = continueChoice;
                }
                else if (continueChoice == 2) {
                    input = continueChoice;
                } else {
                    System.out.println("Not a valid number");
                }
            } else if (input == 2) {
                gameOn = false;
            } else {
                System.out.println("Not a valid number.");
            }
        }
    }
}


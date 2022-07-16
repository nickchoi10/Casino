package com.github.zipcodewilmington.casino.games.BoulderParchmentShears;

import java.util.Random;

public class BPSEngine {
    Random randy = new Random();
    protected static final String rock = "rock";
    protected static final String paper = "paper";
    protected static final String scissors = "scissor";
    Integer botRoll = 0;
    String botThrow;

    public String getWinningMove(String handSign) {
        if (handSign.equals("rock")) {
            return "paper";
        } else if (handSign.equals("paper")) {
            return "scissor";
        } else return "rock";
    }
    public String getLosingMove(String handSign) {
        if (handSign.equals("rock")) {
            return "scissor";
        } else if (handSign.equals("paper")) {
            return "rock";
        } else return "paper";
    }
    public String getWinner2P(String handSignOfPlayer1, String handSignOfPlayer2) {
        String oneWinner = getLosingMove(handSignOfPlayer1);
        String oneLoser = getWinningMove(handSignOfPlayer1);
        if (handSignOfPlayer2.equals(oneWinner)) {
            return handSignOfPlayer1;
        } else return handSignOfPlayer2;
        //return (handSignOfPlayer1.equals(getWinningMove(handSignOfPlayer2)))
        //        ? handSignOfPlayer1 : handSignOfPlayer2
    }

    public String BPSAI (){
        botRoll = (randy.nextInt(2)+1);
        if (botRoll == 1) {botThrow = "rock";}
        else if (botRoll == 2) {botThrow = "paper";}
        else botThrow = "Scissors";
        return botThrow;
    }

    public String BPS1P(String player1){
        String bot = BPSAI();
        return getWinner2P(player1, bot);
    }


}

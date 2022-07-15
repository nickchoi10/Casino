package com.github.zipcodewilmington.casino.games.slots;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SlotsEngine {

    ArrayList slotList;
    int betAmount;
    int balance =1000;
    boolean play=true;


    public SlotsEngine() {
        this.slotList = new ArrayList<>();
    }

    public static void main(String[] args) {
        SlotsEngine run = new SlotsEngine();
        run.playSlots();
    }

    public void playSlots() {
            beginMessage();
            beginningBalance();
        while (play) {
            currentBalance();
            betMessage();
            inputBet();
            clearArray();
            spinSlot();
            displayBoard();
            winConditions(slotList);
            jackPotCondition(slotList);
            losingCondition();
            continuePlaying();
        }
    }

    public boolean isPlaying() {
        return play;
    }

    public void setPlaying(boolean play) {
        this.play= play;
    }
    public void beginMessage() {
        System.out.println("Hello, welcome to the Slot Game\n" +
                "Match 3 numbers across the board, you win!\n" +
                "Get Triple 7 in the middle row, *JACKPOT*\n" +
                "Good Luck!");
    }

    public void inputBet() {
        Scanner scan = new Scanner(System.in);
        betAmount = scan.nextInt();
    }

    public void betMessage(){
        System.out.println("Please enter Bet Amount: ");
    }
    public void spinSlot() {
        ArrayList spin = new ArrayList();
        Random rand = new Random();
        int slot1 = rand.nextInt(9) + 1;
        slotList.add(0, slot1);
        int slot2 = rand.nextInt(9) + 1;
        slotList.add(1, slot2);
        int slot3 = rand.nextInt(9) + 1;
        slotList.add(2, slot3);
        int slot4 = rand.nextInt(9) + 1;
        slotList.add(3, slot4);
        int slot5 = rand.nextInt(9) + 1;
        slotList.add(4, slot5);
        int slot6 = rand.nextInt(9) + 1;
        slotList.add(5, slot6);
        int slot7 = rand.nextInt(9) + 1;
        slotList.add(6, slot7);
        int slot8 = rand.nextInt(9) + 1;
        slotList.add(7, slot8);
        int slot9 = rand.nextInt(9) + 1;
        slotList.add(8, slot9);
    }

    public void displayBoard(){
        String str = slotList.toString();
        StringBuilder display = new StringBuilder();
        display.append(str.charAt(1)+"|"+str.charAt(4)+"|"+str.charAt(7)+"\n"+
                str.charAt(10)+"|"+str.charAt(13)+"|"+str.charAt(16)+"\n"+
                str.charAt(19)+"|"+str.charAt(22)+"|"+str.charAt(25)+"\n");
        System.out.println(display);
    }

    public void clearArray(){
        slotList.clear();
    }
    public void beginningBalance(){
        System.out.println("Your deposited amount is "+ balance +" dollars");
    }
    public void currentBalance(){
        System.out.println("Your current balance is "+ balance+" dollars");
    }

    public void winConditions(ArrayList slotList){
        if(slotList.get(0)==slotList.get(1) && slotList.get(1)==slotList.get(2)||
                slotList.get(6)==slotList.get(7) && slotList.get(7)==slotList.get(8)||
                slotList.get(0)==slotList.get(3) && slotList.get(3)==slotList.get(6)||
                slotList.get(1)==slotList.get(4) && slotList.get(4)==slotList.get(7)||
                slotList.get(2)==slotList.get(5) && slotList.get(5)==slotList.get(8)||
                slotList.get(0)==slotList.get(4) && slotList.get(4)==slotList.get(8)){
            winMessage();
            balance+=betAmount;
        }else{
            balance-=betAmount;
        }
    }

    public void jackPotCondition(ArrayList slotList){
        if(slotList.get(3)==slotList.get(4)&&slotList.get(4)==slotList.get(5)){
            jackPotMessage();
            balance+=betAmount*500;
        }
    }
    public void losingCondition1(){

    }

    public void losingCondition(){
        if (balance <=0){
            System.out.println("You do not have enough money!");
        }
    }

    public void winMessage(){System.out.println("Congratulations, you have won "+betAmount+" dollars!!");}
    public void jackPotMessage(){System.out.println("WINNER WINNER CHICKEN DINNER!!!, you won "+betAmount*500+" dollars!!");}

    public void continuePlaying(){
        if (balance<=0){
            System.out.println("Do you wish to continue?");
            Scanner scan = new Scanner(System.in);
            String yesOrNo = scan.nextLine();
            if(yesOrNo=="yes"){
                this.play=true;
            }
            else{
                this.play=false;
            }

        }
    }
}

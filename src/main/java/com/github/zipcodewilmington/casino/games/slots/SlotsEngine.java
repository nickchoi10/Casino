package com.github.zipcodewilmington.casino.games.slots;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SlotsEngine {
//add thread.sleep to display board for effects


    ArrayList slotList;
    int betAmount;
    int balance =1000;
    boolean play=true;
    Random rand;


    public void setRand(Random rand) {
        this.rand = rand;
    }

    public SlotsEngine() {
        rand = new Random();
        this.slotList = new ArrayList<>();
    }



    public boolean isPlaying() {
        return play;
    }

    public void setPlaying(boolean play) {
        this.play= play;
    }
    public String beginMessage() {
        return "Hello, welcome to the StarDust's Slot Game\n" +
                "Match 2 numbers across the board, you win 1/4 bet amount!\n" +
                "Match 3 numbers across the board, you win your bet amount!\n" +
                "Triple 7 in middle row is *JACKPOT*. You win 500x bet amount!\n" +
                "Good Luck!";
    }

    public int inputBet() {
        Scanner scan = new Scanner(System.in);
        return betAmount = scan.nextInt();
    }

    public String betMessage(){
        return "Please enter Bet Amount: ";
    }
    public ArrayList spinSlot() {
        ArrayList spin = new ArrayList();
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
        return slotList;
    }

    public void displayBoard() throws InterruptedException {
        String str = slotList.toString();
        StringBuilder row1 = new StringBuilder();
        StringBuilder row2 = new StringBuilder();
        StringBuilder row3 = new StringBuilder();

        row1.append(str.charAt(1)+"|"+str.charAt(4)+"|"+str.charAt(7));
        row2.append(str.charAt(10)+"|"+str.charAt(13)+"|"+str.charAt(16));
        row3.append(str.charAt(19)+"|"+str.charAt(22)+"|"+str.charAt(25));
        System.out.println("Ready??");
        Thread.sleep(1000);
        System.out.println("set");
        Thread.sleep(1000);
        System.out.println("GO!!!!!");
        Thread.sleep(1000);
        System.out.println(row1);
        Thread.sleep(2000);
        System.out.println(row2);
        Thread.sleep(2000);
        System.out.println(row3);
        Thread.sleep(2000);

//        display.append(str.charAt(1)+"|"+str.charAt(4)+"|"+str.charAt(7)+"\n"+
//                str.charAt(10)+"|"+str.charAt(13)+"|"+str.charAt(16)+"\n"+
//                str.charAt(19)+"|"+str.charAt(22)+"|"+str.charAt(25)+"\n");
//        System.out.println(display);
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

    public int winConditions(ArrayList slotList){
        if(slotList.get(0)==slotList.get(1) && slotList.get(1)==slotList.get(2)||
                slotList.get(6)==slotList.get(7) && slotList.get(7)==slotList.get(8)||
                slotList.get(0)==slotList.get(3) && slotList.get(3)==slotList.get(6)||
                slotList.get(1)==slotList.get(4) && slotList.get(4)==slotList.get(7)||
                slotList.get(2)==slotList.get(5) && slotList.get(5)==slotList.get(8)||
                slotList.get(0)==slotList.get(4) && slotList.get(4)==slotList.get(8)){
            winMessage1();
            return balance+=betAmount;
        }else{
            return balance-=betAmount;
        }
    }
    public int winConditions1(ArrayList slotList){
        if(slotList.get(0)==slotList.get(1) && slotList.get(1)!=slotList.get(2)||
                slotList.get(3)==slotList.get(4) && slotList.get(4)!=slotList.get(5)||
                slotList.get(6)==slotList.get(7) && slotList.get(7)!=slotList.get(8)||
                slotList.get(0)==slotList.get(3) && slotList.get(3)!=slotList.get(6)||
                slotList.get(1)==slotList.get(4) && slotList.get(4)!=slotList.get(7)||
                slotList.get(2)==slotList.get(5) && slotList.get(5)!=slotList.get(8)||
                slotList.get(0)==slotList.get(4) && slotList.get(4)!=slotList.get(8)||
                slotList.get(0)!=slotList.get(1) && slotList.get(1)==slotList.get(2)||
                slotList.get(3)!=slotList.get(4) && slotList.get(4)==slotList.get(5)||
                slotList.get(6)!=slotList.get(7) && slotList.get(7)==slotList.get(8)||
                slotList.get(0)!=slotList.get(3) && slotList.get(3)==slotList.get(6)||
                slotList.get(1)!=slotList.get(4) && slotList.get(4)==slotList.get(7)||
                slotList.get(2)!=slotList.get(5) && slotList.get(5)==slotList.get(8)||
                slotList.get(0)!=slotList.get(4) && slotList.get(4)==slotList.get(8)){
            winMessage2();
            return balance+=betAmount/4;
        }else{
            return balance-=betAmount;
        }
    }
    public int jackPotCondition(ArrayList slotList){
        if(slotList.get(3)==slotList.get(4)&&slotList.get(4)==slotList.get(5)){
            jackPotMessage();
        }
        return balance+=betAmount*500;
    }

    public String losingCondition(){
        if (balance <=0){
        }
        return "You do not have enough money!";

    }

    public void winMessage1(){System.out.println("Congratulations, you have won "+betAmount+" dollars!!");}
    public void winMessage2(){System.out.println("Congratulations, you have won "+betAmount/4+" dollars!!");}
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

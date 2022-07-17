package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.PlayerSetup;

public class SlotMain {
    SlotsEngine run = new SlotsEngine();

    public void startSlot() throws InterruptedException {

        run.beginMessage();
        run.beginningBalance();
        while (run.play) {
            run.currentBalance();
            run.betMessage();
            run.inputBet();
            run.clearArray();
            run.spinSlot();
            run.displayBoard();
            run.winConditions(run.slotList);
            run.jackPotCondition(run.slotList);
            run.losingCondition();
            run.continuePlaying();
        }
    }

}

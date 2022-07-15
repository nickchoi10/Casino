package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.PlayerSetup;

public class SlotMain extends SlotsEngine {

    public void startSlot(){

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

}

package com.github.zipcodewilmington.casino.games.BoulderParchmentShears;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;

import java.util.ArrayList;
import java.util.List;

public class BPSMain {
    private BPSEngine engine;
    private ActiveAccount aa;

    public void playBPS(){
        engine = new BPSEngine();
        aa = new ActiveAccount();

        aa.numPlayers(2);

        engine.intro(aa.activeAccounts.size());

    }

}

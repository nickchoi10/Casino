package com.github.zipcodewilmington.casino.games.BoulderParchmentShears;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;

import java.util.ArrayList;
import java.util.List;

public class BPSMain {

    public static void main(String[] args) {playBPS();}

    public static void playBPS(){
//        ActiveAccount.numPlayers(2);

        Account p1 = new Account ("1", "1", "1", 200);
        Account p2 = new Account ("2", "2", "2", 200);
        Account p3 = new Account ("3", "3", "3", 200);
        ActiveAccount.activeAccounts.clear();
        ActiveAccount.addActiveAccount(p1);
        ActiveAccount.addActiveAccount(p2);

        BPSEngine.intro(ActiveAccount.activeAccounts.size());



    }

}

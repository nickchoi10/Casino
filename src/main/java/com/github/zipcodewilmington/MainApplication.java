package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.cardgames.blackjack.BlackjackEngine;

public class MainApplication {
    public static void main(String[] args) {
//        new Casino().run();
        BlackjackEngine run = new BlackjackEngine();
        run.run();

    }
}

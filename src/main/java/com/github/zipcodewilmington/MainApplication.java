package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.cardgames.blackjack.BlackjackMain;

public class MainApplication {
    public static void main(String[] args) {
        Casino casino = new Casino();
        casino.run();
    }
}

package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.Dealer;
import com.github.zipcodewilmington.casino.games.cardgames.StandardDeck;

import java.util.List;

public class PokerMain implements GameInterface {
    private List<PokerPlayer> players;
    private Dealer<PokerHand, StandardDeck> dealer;
    private ThreeCardPokerEngine engine;

    public void add(PlayerInterface player) {

    }

    public void remove(PlayerInterface player) {

    }

    public void run() {}


}

package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class BlackjackPlayer implements PlayerInterface {
    int iD;
    List<PlayingCard> hand = new ArrayList<>();

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

    public BlackjackPlayer(int iD) {
        this.iD = iD;
    }

    public void addToHand(PlayingCard card) {
        hand.add(card);
    }
}

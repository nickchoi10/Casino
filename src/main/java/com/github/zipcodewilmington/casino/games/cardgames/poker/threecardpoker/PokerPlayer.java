package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;

import java.util.List;

public class PokerPlayer implements PlayerInterface {
    CasinoAccount account;
    PokerHand hand;
    int anteBet;
    int pairPlusBet;

    public PokerPlayer() {
        hand = new PokerHand();
    }
    public PokerPlayer(List<PlayingCard> cards) {
        hand = new PokerHand(cards);
    }

    public CasinoAccount getArcadeAccount() {
        return account;
    }
    public Integer play() {
        return null;
    }

    public void setAccount(CasinoAccount account) {
        this.account = account;
    }

    public PokerHand getHand() {
        return hand;
    }

    public void setHand(PokerHand hand) {
        this.hand = hand;
    }

    public int getAnteBet() {
        return anteBet;
    }

    public void setAnteBet(int anteBet) {
        this.anteBet = anteBet;
    }

    public int getPairPlusBet() {
        return pairPlusBet;
    }

    public void setPairPlusBet(int pairPlusBet) {
        this.pairPlusBet = pairPlusBet;
    }
}

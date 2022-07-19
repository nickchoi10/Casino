package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.Gambler;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;

import java.util.List;

public class PokerPlayer extends Gambler {
    PokerHand hand;
    int anteBet;
    int pairPlusBet;
    int playBet;

    public int getPlayBet() {
        return playBet;
    }

    public void setPlayBet(int playBet) {
        this.playBet = playBet;
    }

    public PokerPlayer(String name) {
        this.name = name;
        this.account = new Account();
        hand = new PokerHand();
    }

    public PokerPlayer(Account account) {
        this.name = account.getAccountName();
        this.account = account;
        hand = new PokerHand();
    }

    public PokerPlayer(String name, List<PlayingCard> cards) {
        this.name = name;
        hand = new PokerHand(cards);
    }

    public PokerPlayer(List<PlayingCard> cards) {
        hand = new PokerHand(cards);
    }

    public Account getArcadeAccount() {
        return account;
    }
    public Integer play() {
        return null;
    }

    public void setAccount(Account account) {
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

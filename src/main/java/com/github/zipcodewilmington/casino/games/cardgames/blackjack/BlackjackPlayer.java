package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class BlackjackPlayer {

    //what does a BJ player do?
    //place a bet
    //dealt cards > as the player, i would add it to my hand.
    //dealer would ask me, hit or stand. Player hit > Add card to list Play stand > end turn.
    //if player wins, winPot -> add money to casino account.


    Account casinoAccount;
    Hand hand;
    boolean isWinner;


    public BlackjackPlayer(Account casinoAccount) {
        this.hand = new Hand();
        this.casinoAccount = casinoAccount;
        this.isWinner = false;

        //the player now has a Hand that holds a List<PlayingCard>
        //we are passing the casinoAccount param to retrieve the player's info.
    }

    public void addToHand(PlayingCard card) {
        hand.getCards().add(card);
    }

    public Account getCasinoAccount() {
        return casinoAccount;
    }

    public void setCasinoAccount(Account casinoAccount) {
        this.casinoAccount = casinoAccount;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}

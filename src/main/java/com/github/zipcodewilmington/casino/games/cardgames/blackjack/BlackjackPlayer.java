package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class BlackjackPlayer implements PlayerInterface {

    //what does a BJ player do?
    //place a bet
    //dealt cards > as the player, i would add it to my hand.
    //dealer would ask me, hit or stand. Player hit > Add card to list Play stand > end turn.
    //if player wins, winPot -> add money to casino account.


    CasinoAccount casinoAccount;
    //how do we determine this specific player casino acct?
    //how do we pass that into a player?

    Hand hand;


    public BlackjackPlayer(CasinoAccount casinoAccount) {
        hand = new Hand();
        this.casinoAccount = casinoAccount;
        //the player now has a Hand that holds a List<PlayingCard>
        //we are passing the casinoAccount param to retrieve the player's info.
    }

    public int placeBet(int amount) {
        //would need to check the balance of the player's account
        //to see if they can bet that much.

        //if (amount < balance) {
        // subtract amount from balance
        //   balance -= amount
        //   return amount;
        // else {
        //   sout(Not enough money in Account)
        //   return 0;
        return 0;
    }
    public void addToHand(PlayingCard card) {
        hand.getCards().add(card);
        //this is good for hit (add 1 card) and starting game (add 2 cards)
    }

    public void winPot(int amount) {
        //pass in the total winning, which includes the original bet.
        //supposed to add the winnings into the casino account balance.
        //winnings are calc in the BJ engine Class.
        //
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

}

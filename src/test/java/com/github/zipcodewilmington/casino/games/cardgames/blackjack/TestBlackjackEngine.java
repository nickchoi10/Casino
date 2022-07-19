package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.games.cardgames.CardRank;
import com.github.zipcodewilmington.casino.games.cardgames.CardSuit;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestBlackjackEngine {
    BlackjackEngine blackjackEngine;
    @Before
    public void setUp() {
        this.blackjackEngine = new BlackjackEngine();
    }

    @Test
    //Given
    public void testIsBlackJack() { //write the method you are testing
        Hand<PlayingCard> hand = new Hand<>(Arrays.asList(new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                new PlayingCard(CardSuit.HEARTS, CardRank.JACK)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.updateHandValue();

        Boolean expected = true;

        Boolean actual = blackjackEngine.isBlackJack(blackjackPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    //Given
    public void testIsBlackJackFalse() { //write the method you are testing
        Hand<PlayingCard> hand = new Hand<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.NINE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.HEARTS, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.updateHandValue();

        Boolean expected = false;

        Boolean actual = blackjackEngine.isBlackJack(blackjackPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsBust() { //write the method you are testing
        Hand<PlayingCard> hand = new Hand<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.EIGHT)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.updateHandValue();

        Boolean expected = true;

        Boolean actual = blackjackEngine.isBust(blackjackPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsBustFalse() { //write the method you are testing
        Hand<PlayingCard> hand = new Hand<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.updateHandValue();

        Boolean expected = false;

        Boolean actual = blackjackEngine.isBust(blackjackPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsBustFalseWithAce() { //write the method you are testing
        Hand<PlayingCard> hand = new Hand<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.updateHandValue();

        Boolean expected = false;

        Boolean actual = blackjackEngine.isBust(blackjackPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stand() {
        boolean expected = false;
        boolean actual = blackjackEngine.stand();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerBlackjack() {
        Hand<PlayingCard> hand = new Hand<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN)));
        BlackjackPlayer dealer = new BlackjackPlayer();
        dealer.setHand(hand);
        dealer.setHandValue(21);
        blackjackEngine.setDealer(dealer);

        boolean expected = true;
        boolean actual = blackjackEngine.dealerBlackjack();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerBlackjackFalse() {
        Hand<PlayingCard> hand = new Hand<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN)));
        BlackjackPlayer dealer = new BlackjackPlayer();
        dealer.setHand(hand);
        dealer.setHandValue(15);
        blackjackEngine.setDealer(dealer);

        boolean expected = false;
        boolean actual = blackjackEngine.dealerBlackjack();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerTurn() {
        Hand<PlayingCard> hand = new Hand<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.EIGHT),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN)));
        BlackjackPlayer dealer = new BlackjackPlayer();
        dealer.setHand(hand);
        dealer.setHandValue(18);
        blackjackEngine.setDealer(dealer);

        boolean expected = false;
        boolean actual = blackjackEngine.dealerTurn();

        Assert.assertEquals(expected, actual);
    }

}

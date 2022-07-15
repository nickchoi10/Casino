package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.games.cardgames.CardRank;
import com.github.zipcodewilmington.casino.games.cardgames.CardSuit;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public class TestBlackjackEngine {
    BlackjackEngine blackjackEngine = new BlackjackEngine();

    @Test
    //Given
    public void testIsBlackJack() { //write the method you are testing
        Hand hand = new Hand(Arrays.asList(new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                new PlayingCard(CardSuit.HEARTS, CardRank.JACK)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.initializeHandValue();

        Boolean expected = true;

        Boolean actual = blackjackEngine.isBlackJack(blackjackPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    //Given
    public void testIsBlackJackFalse() { //write the method you are testing
        Hand hand = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.NINE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.HEARTS, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.initializeHandValue();

        Boolean expected = false;

        Boolean actual = blackjackEngine.isBlackJack(blackjackPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsBust() { //write the method you are testing
        Hand hand = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.EIGHT)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.initializeHandValue();

        Boolean expected = true;

        Boolean actual = blackjackEngine.isBust(blackjackPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsBustFalse() { //write the method you are testing
        Hand hand = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.initializeHandValue();

        Boolean expected = false;

        Boolean actual = blackjackEngine.isBust(blackjackPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsBustFalseWithAce() { //write the method you are testing
        Hand hand = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.initializeHandValue();

        Boolean expected = false;

        Boolean actual = blackjackEngine.isBust(blackjackPlayer);

        Assert.assertEquals(expected, actual);
    }

}

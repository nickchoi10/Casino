package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

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

        for (PlayingCard card : hand.getCards()) {
            blackjackEngine.convertValue(card);
        }
        Boolean expected = true;

        Boolean actual = blackjackEngine.isBlackJack(hand);

        Assert.assertEquals(expected, actual);
    }

    @Test
    //Given
    public void testIsBlackJackFalse() { //write the method you are testing
        Hand hand = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.NINE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.HEARTS, CardRank.TWO)));

        for (PlayingCard card : hand.getCards()) {
            blackjackEngine.convertValue(card);
        }
        Boolean expected = false;

        Boolean actual = blackjackEngine.isBlackJack(hand);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsBust() { //write the method you are testing
        Hand hand = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.EIGHT)));

        for (PlayingCard card : hand.getCards()) {
            blackjackEngine.convertValue(card);
        }
        Boolean expected = true;

        Boolean actual = blackjackEngine.isBust(hand);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsBustFalse() { //write the method you are testing
        Hand hand = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));

        for (PlayingCard card : hand.getCards()) {
            blackjackEngine.convertValue(card);
        }
        Boolean expected = false;

        Boolean actual = blackjackEngine.isBust(hand);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsBustFalseWithAce() { //write the method you are testing
        Hand hand = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));

        for (PlayingCard card : hand.getCards()) {
            blackjackEngine.convertValue(card);
        }
        Boolean expected = false;

        Boolean actual = blackjackEngine.isBust(hand);

        Assert.assertEquals(expected, actual);
    }

}

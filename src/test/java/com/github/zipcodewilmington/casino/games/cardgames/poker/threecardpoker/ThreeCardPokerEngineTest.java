package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.games.cardgames.CardRank;
import com.github.zipcodewilmington.casino.games.cardgames.CardSuit;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeCardPokerEngineTest {
    ThreeCardPokerEngine engine;

    @BeforeEach
    public void init() {
        engine = new ThreeCardPokerEngine();
    }

    @Test
    void dealCards() {

    }

    @Test
    void compareHands() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.DIAMONDS, CardRank.FIVE),
                new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE), new PlayingCard(CardSuit.DIAMONDS, CardRank.FOUR));
        List<PlayingCard> cards2 = Arrays.asList(new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE),
                new PlayingCard(CardSuit.HEARTS, CardRank.THREE), new PlayingCard(CardSuit.SPADES, CardRank.THREE));
        Hand hand1 = new PokerHand(cards1);
        Hand hand2 = new PokerHand(cards2);

        int val = engine.compareHands(hand1, hand2);
        Assert.assertTrue(val > 0);
    }

    @Test
    void testGetHandPointValue() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.DIAMONDS, CardRank.FIVE),
                new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE), new PlayingCard(CardSuit.DIAMONDS, CardRank.FOUR));
        PokerHand hand1 = new PokerHand(cards1);

        Integer expected = 600 + 5;

        Integer actual = engine.getHandPointValue(hand1);

        Assert.assertEquals(expected, actual);
    }


    @Test
    void testFlushTieBreaker() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.DIAMONDS, CardRank.FIVE),
                new PlayingCard(CardSuit.DIAMONDS, CardRank.SEVEN), new PlayingCard(CardSuit.DIAMONDS, CardRank.JACK));
        List<PlayingCard> cards2 = Arrays.asList(new PlayingCard(CardSuit.HEARTS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.FIVE), new PlayingCard(CardSuit.HEARTS, CardRank.JACK));
        PokerPlayer player1 = new PokerPlayer(cards1);
        PokerPlayer player2 = new PokerPlayer(cards2);

        PokerPlayer expectedWinner = player1;

        PokerPlayer actualWinner = engine.flushTieBreaker(player1, player2);

        Assert.assertEquals(expectedWinner, actualWinner);
    }

    @Test
    void pairTieBreaker() {
    }

    @Test
    void highCardTieBreaker() {
    }
}
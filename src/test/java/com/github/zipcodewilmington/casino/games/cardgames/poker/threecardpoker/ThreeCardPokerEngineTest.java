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

import java.util.ArrayList;
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
    void computeWinner() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.DIAMONDS, CardRank.FIVE),
                new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE), new PlayingCard(CardSuit.DIAMONDS, CardRank.FOUR));
        List<PlayingCard> cards2 = Arrays.asList(new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE),
                new PlayingCard(CardSuit.HEARTS, CardRank.THREE), new PlayingCard(CardSuit.SPADES, CardRank.THREE));
        PokerPlayer player1 = new PokerPlayer(cards1);
        PokerPlayer player2 = new PokerPlayer(cards2);

        PokerPlayer expectedWinner = player1;
        PokerPlayer actualWinner = engine.computeWinner(player1, player2);

        Assert.assertEquals(expectedWinner, actualWinner);
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
        List<PlayingCard> cards1 = new ArrayList<>(Arrays.asList(new PlayingCard(CardSuit.DIAMONDS, CardRank.FIVE),
                new PlayingCard(CardSuit.DIAMONDS, CardRank.SEVEN), new PlayingCard(CardSuit.DIAMONDS, CardRank.JACK)));
        List<PlayingCard> cards2 = new ArrayList<>(Arrays.asList(new PlayingCard(CardSuit.HEARTS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.FIVE), new PlayingCard(CardSuit.HEARTS, CardRank.JACK)));
        PokerPlayer player1 = new PokerPlayer(cards1);
        PokerPlayer player2 = new PokerPlayer(cards2);

        PokerPlayer expectedWinner = player1;

        PokerPlayer actualWinner = engine.flushTieBreaker(player1, player2);

        Assert.assertEquals(expectedWinner, actualWinner);
    }

    @Test
    void pairTieBreaker() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.DIAMONDS, CardRank.TWO),
                new PlayingCard(CardSuit.DIAMONDS, CardRank.TWO), new PlayingCard(CardSuit.HEARTS, CardRank.JACK));
        List<PlayingCard> cards2 = Arrays.asList(new PlayingCard(CardSuit.HEARTS, CardRank.TWO),
                new PlayingCard(CardSuit.CLUBS, CardRank.TWO), new PlayingCard(CardSuit.CLUBS, CardRank.TEN));
        PokerPlayer player1 = new PokerPlayer(cards1);
        PokerPlayer player2 = new PokerPlayer(cards2);

        Assert.assertTrue(player1.getHand().hasPair(player1.getHand()));

        PokerPlayer expectedWinner = player1;

        PokerPlayer actualWinner = engine.pairTieBreaker(player1, player2);

        Assert.assertEquals(expectedWinner, actualWinner);
    }

    @Test
    void highCardTieBreaker() {
        List<PlayingCard> cards1 = new ArrayList(Arrays.asList(new PlayingCard(CardSuit.DIAMONDS, CardRank.TWO),
                new PlayingCard(CardSuit.DIAMONDS, CardRank.FIVE), new PlayingCard(CardSuit.HEARTS, CardRank.JACK)));
        List<PlayingCard> cards2 = new ArrayList(Arrays.asList(new PlayingCard(CardSuit.HEARTS, CardRank.TWO),
                new PlayingCard(CardSuit.HEARTS, CardRank.SIX), new PlayingCard(CardSuit.CLUBS, CardRank.JACK)));
        PokerPlayer player1 = new PokerPlayer(cards1);
        PokerPlayer player2 = new PokerPlayer(cards2);

        Assert.assertTrue(player1.getHand().getRank() == ThreePokerHandRank.HIGH_CARD);

        PokerPlayer expectedWinner = player2;

        PokerPlayer actualWinner = engine.highCardTieBreaker(player1, player2);

        Assert.assertEquals(expectedWinner, actualWinner);
    }
}
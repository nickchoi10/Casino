package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.games.cardgames.CardRank;
import com.github.zipcodewilmington.casino.games.cardgames.CardSuit;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeCardPokerEngineTest {
    ThreeCardPokerEngine engine;

    @Before
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
    void addAnteWager() {
    }

    @Test
    void addPairPlusWager() {
    }

    @Test
    void getHandPointValue() {
    }
}
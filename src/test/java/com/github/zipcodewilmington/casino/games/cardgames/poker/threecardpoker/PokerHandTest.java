package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.games.cardgames.CardRank;
import com.github.zipcodewilmington.casino.games.cardgames.CardSuit;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokerHandTest {
    PokerHand hand;

    @BeforeEach
    public void init() {
        List<PlayingCard> cards = Arrays.asList(new PlayingCard(CardSuit.DIAMONDS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.FIVE), new PlayingCard(CardSuit.DIAMONDS, CardRank.FOUR));
        hand = new PokerHand(cards);
    }
    @Test
    void isPair() {
        Assert.assertTrue(hand.hasPair(this.hand));
    }

    @Test
    void testGetPairRanking() {
        Integer expectedRank = 5;

        Integer actualRank = hand.getPairRanking(hand);

        Assert.assertEquals(expectedRank, actualRank);
    }

    @Test
    void testgetPairOddRanking() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.FIVE), new PlayingCard(CardSuit.DIAMONDS, CardRank.FOUR));
        List<PlayingCard> cards2 = Arrays.asList(new PlayingCard(CardSuit.DIAMONDS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.FIVE), new PlayingCard(CardSuit.DIAMONDS, CardRank.JACK));
        PokerHand hand1 = new PokerHand(cards1);
        PokerHand hand2 = new PokerHand(cards2);

        Integer expectedRankValue1 = 4;
        Integer expectedRankValue2 = 11;

        Integer actual1 = hand.getPairOddRanking(hand1);
        Integer actual2 = hand.getPairOddRanking(hand2);

        Assert.assertEquals(expectedRankValue1, actual1);
        Assert.assertEquals(expectedRankValue2, actual2);
    }

    @Test
    void isFlush() {
        PlayingCard diamondCard = new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE);
        hand.swapCard(diamondCard, 1);

        Assert.assertTrue(hand.hasFlush(this.hand));
    }

    @Test
    void testIsStraightFlush() {
        PlayingCard diamondCard = new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE);
        hand.swapCard(diamondCard, 1);

        Assert.assertTrue(hand.isStraightFlush(this.hand));
    }

    @Test
    void testIsStraight() {
        PlayingCard diamondCard = new PlayingCard(CardSuit.HEARTS, CardRank.THREE);
        hand.swapCard(diamondCard, 1);

        Assert.assertTrue(hand.hasStraight(this.hand));
    }

    @Test
    void testIsStraightHighestCombo() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                new PlayingCard(CardSuit.HEARTS, CardRank.QUEEN), new PlayingCard(CardSuit.DIAMONDS, CardRank.KING));
        hand = new PokerHand(cards1);

        Boolean expected = true;

        Boolean actual = hand.hasStraight(this.hand);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testIsStraightLowestCombo() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TWO), new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE));
        hand = new PokerHand(cards1);

        Boolean expected = true;

        Boolean actual = hand.hasStraight(this.hand);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testIsStraightNotAStraight() {
        Boolean expected = false;

        Boolean actual = hand.hasStraight(this.hand);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testHasThreeOfAKind() {
        PlayingCard threeCard1 = new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE);
        PlayingCard threeCard2 = new PlayingCard(CardSuit.HEARTS, CardRank.THREE);
        PlayingCard threeCard3 = new PlayingCard(CardSuit.SPADES, CardRank.THREE);
        hand = new PokerHand(Arrays.asList(threeCard1, threeCard2, threeCard3));

        Assert.assertTrue(hand.hasThreeOfAKind(this.hand));
    }

    @Test
    void getHighestCard() {
        PlayingCard expectedCard = hand.getCard(0);

        PlayingCard actualCard = hand.getHighestCard(this.hand);

        Assert.assertTrue(expectedCard.equals(actualCard));
    }

}
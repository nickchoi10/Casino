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
    void isFlush() {
        PlayingCard diamondCard = new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE);
        hand.swapCard(diamondCard, 1);

        Assert.assertTrue(hand.hasFlush(this.hand));
    }

    @Test
    void isStraightFlush() {
        PlayingCard diamondCard = new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE);
        hand.swapCard(diamondCard, 1);

        Assert.assertTrue(hand.isStraightFlush(this.hand));
    }

    @Test
    void isStraight() {
        PlayingCard diamondCard = new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE);
        hand.swapCard(diamondCard, 1);

        Assert.assertTrue(hand.hasStraight(this.hand));
    }

    @Test
    void isThreeOfAKind() {
        PlayingCard threeCard1 = new PlayingCard(CardSuit.DIAMONDS, CardRank.THREE);
        PlayingCard threeCard2 = new PlayingCard(CardSuit.HEARTS, CardRank.THREE);
        PlayingCard threeCard3 = new PlayingCard(CardSuit.SPADES, CardRank.THREE);
        hand = new PokerHand(Arrays.asList(threeCard1, threeCard2, threeCard3));

        Assert.assertTrue(hand.hasThreeOfAKind(this.hand));
    }

    @Test
    void getHighestCard() {
        
    }

}
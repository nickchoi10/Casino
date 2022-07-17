package com.github.zipcodewilmington.casino.games.cardgames;

import com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker.PokerHand;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TestDealer {
    Dealer<PokerHand, StandardDeck> pokerDealer;

    @BeforeEach
    public void init() {
        PokerHand hand = new PokerHand(Arrays.asList(new PlayingCard(CardSuit.HEARTS, CardRank.JACK)));
        StandardDeck deck = new StandardDeck();

        pokerDealer = new Dealer<>(hand, deck);
    }

    @Test
    public void testDealerConstructor() {

        Integer expectedHandSize = 1;
        Integer expectedDeckSize = 52;
        CardSuit expectedCardSuit = CardSuit.HEARTS;

        Integer actualHandSize = pokerDealer.getHand().getNumberOfCards();
        Integer actualDeckSize = pokerDealer.getDeck().getDeckSize();
        CardSuit actualCardSuit = pokerDealer.getHand().getCard(0).getSuit();

        Assert.assertEquals(expectedHandSize, actualHandSize);
        Assert.assertEquals(expectedDeckSize, actualDeckSize);
        Assert.assertEquals(expectedCardSuit, actualCardSuit);
    }

    @Test
    void dealCardsNoIssue() {
        PokerHand hand = new PokerHand(pokerDealer.dealCards(10));

        Integer expectedCards = 10;
        Integer expectedCardsInDeck = 42;

        Integer actualCards = hand.getNumberOfCards();
        Integer actualCardsInDeck = pokerDealer.getDeck().getDeckSize();

        Assert.assertEquals(expectedCards, actualCards);
        Assert.assertEquals(expectedCardsInDeck, actualCardsInDeck);
    }

    @Test
    void testDealCardsEmptyDeckThrowsException() {
       IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
           new PokerHand(pokerDealer.dealCards(53));
       });

       Assert.assertEquals("NOT ENOUGH CARDS IN THE DECK", e.getMessage());
    }

    @Test
    public void testSetHand() {
        PokerHand hand = new PokerHand(Arrays.asList(new PlayingCard(CardSuit.HEARTS, CardRank.JACK),
                new PlayingCard(CardSuit.SPADES, CardRank.JACK), new PlayingCard(CardSuit.DIAMONDS, CardRank.JACK)));

        Integer expectedHandSize = 3;
        pokerDealer.setHand(hand);

        Integer actualHandSize = pokerDealer.getHand().getNumberOfCards();

        Assert.assertEquals(expectedHandSize, actualHandSize);
    }

    @Test
    public void testSetDeck() {
        PokerHand hand = new PokerHand(pokerDealer.dealCards(10));

        Integer expectedDeckAfterDeal = 42;
        Integer actualDeckSize = pokerDealer.getDeck().getDeckSize();
        Assert.assertEquals(expectedDeckAfterDeal, actualDeckSize);

        pokerDealer.setDeck(new StandardDeck());
        Integer expectedNewDeck = 52;

        Integer actualNewDeck = pokerDealer.getDeck().getDeckSize();

        Assert.assertEquals(expectedNewDeck, actualNewDeck);
    }



}
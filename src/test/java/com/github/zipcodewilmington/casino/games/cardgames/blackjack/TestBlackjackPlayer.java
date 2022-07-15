package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.games.cardgames.CardRank;
import com.github.zipcodewilmington.casino.games.cardgames.CardSuit;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TestBlackjackPlayer {

    @Test
    void addToHand() {
    }

    @Test
    void getCasinoAccount() {
        Account expected = new Account();
        BlackjackPlayer player = new BlackjackPlayer(expected);
        Account actual = player.getCasinoAccount();

        assertEquals(expected, actual);
    }

    @Test
    void setCasinoAccount() {
        Account account = new Account();
        BlackjackPlayer player = new BlackjackPlayer(account);
        Account expected = new Account();
        player.setCasinoAccount(expected);
        Account actual = player.getCasinoAccount();

        assertEquals(expected, actual);
    }

    @Test
    void getHand() {
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        Hand actual = blackjackPlayer.getHand();

        assertNotNull(actual);
    }

    @Test
    void setHand() {
        Hand expected = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(expected);
        Hand actual = blackjackPlayer.getHand();

        assertEquals(expected, actual);
    }

    @Test
    void isWinner() {
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());

        assertFalse(blackjackPlayer.isWinner);
    }

    @Test
    void setWinner() {
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setWinner(true);

        assertTrue(blackjackPlayer.isWinner);
    }

    @Test
    void calculateHandValue() {
        Hand hand = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.initializeHandValue();

        int expected = 17;
        int actual = blackjackPlayer.getHandValue();

        assertEquals(expected, actual);
    }

    @Test
    void calculateHandValueWithAce() {
        Hand hand = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.initializeHandValue();

        int expected = 13;
        int actual = blackjackPlayer.getHandValue();

        assertEquals(expected, actual);
    }

    @Test
    void calculateHandValueWithFaceCard() {
        Hand hand = new Hand(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.JACK),
                new PlayingCard(CardSuit.CLUBS, CardRank.QUEEN),
                new PlayingCard(CardSuit.SPADES, CardRank.KING)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.initializeHandValue();

        int expected = 30;
        int actual = blackjackPlayer.getHandValue();

        assertEquals(expected, actual);
    }
}
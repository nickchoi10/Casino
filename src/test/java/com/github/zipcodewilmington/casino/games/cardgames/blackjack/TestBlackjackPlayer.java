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
        Account actual = player.getArcadeAccount();

        assertEquals(expected, actual);
    }

    @Test
    void setCasinoAccount() {
        Account account = new Account();
        BlackjackPlayer player = new BlackjackPlayer(account);
        Account expected = new Account();
        player.setAccount(expected);
        Account actual = player.getArcadeAccount();

        assertEquals(expected, actual);
    }

    @Test
    void getHand() {
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        Hand<PlayingCard> actual = blackjackPlayer.getHand();

        assertNotNull(actual);
    }

    @Test
    void setHand() {
        Hand<PlayingCard> expected = new Hand<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(expected);
        Hand<PlayingCard> actual = blackjackPlayer.getHand();

        assertEquals(expected, actual);
    }

    @Test
    void calculateHandValue() {
        Hand<PlayingCard> hand = new Hand<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.TEN),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.updateHandValue();

        int expected = 17;
        int actual = blackjackPlayer.getHandValue();

        assertEquals(expected, actual);
    }

    @Test
    void calculateHandValueWithAce() {
        Hand<PlayingCard> hand = new Hand<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                new PlayingCard(CardSuit.SPADES, CardRank.TWO)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.updateHandValue();

        int expected = 13;
        int actual = blackjackPlayer.getHandValue();

        assertEquals(expected, actual);
    }

    @Test
    void calculateHandValueWithFaceCard() {
        Hand<PlayingCard> hand = new Hand<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.JACK),
                new PlayingCard(CardSuit.CLUBS, CardRank.QUEEN),
                new PlayingCard(CardSuit.SPADES, CardRank.KING)));
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(new Account());
        blackjackPlayer.setHand(hand);
        blackjackPlayer.updateHandValue();

        int expected = 30;
        int actual = blackjackPlayer.getHandValue();

        assertEquals(expected, actual);
    }

    @Test
    void getGameStateStart() {
        BlackjackPlayer player = new BlackjackPlayer();
        GameState expected = GameState.START;
        GameState actual = player.getGameState();

        assertEquals(expected, actual);
    }

    @Test
    void setGameState() {
        BlackjackPlayer player = new BlackjackPlayer();
        GameState expected = GameState.WIN;
        player.setGameState(GameState.WIN);
        GameState actual = player.getGameState();

        assertEquals(expected, actual);
    }

    @Test
    void getHandValue() {
        BlackjackPlayer player = new BlackjackPlayer();
        int expected = 0;
        int actual = player.getHandValue();

        assertEquals(expected, actual);
    }

    @Test
    void setHandValue() {
        BlackjackPlayer player = new BlackjackPlayer();
        int expected = 21;
        player.setHandValue(expected);
        int actual = player.getHandValue();

        assertEquals(expected, actual);
    }
}
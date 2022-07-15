package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackPlayerTest {

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
    }

    @Test
    void setHand() {
    }

    @Test
    void isWinner() {
    }

    @Test
    void setWinner() {
    }
}
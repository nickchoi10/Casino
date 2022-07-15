package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.PlayerSetup;
import org.junit.Assert;
import org.junit.Test;

public class PlayerSetupTest {
    @Test
    public void testAddActivePlayer() {
        Account account = new Account();
        PlayerSetup.addActivePlayer(account);
        int expected = 1;
        int actual = PlayerSetup.activePlayers.size();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testRemoveActivePlayer() {
        Account account = new Account();
        PlayerSetup.addActivePlayer(account);

        PlayerSetup.removeActivePlayer(account);
        int expected = 0;
        int actual = PlayerSetup.activePlayers.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testShowActivePlayer() {
        Account account1 = new Account("test1","test1","test1", 1000);
        Account account2 = new Account("test2","test2","test2", 1000);
        PlayerSetup.addActivePlayer(account1);
        PlayerSetup.addActivePlayer(account2);
        String actual = PlayerSetup.showActivePlayers();
        String expected = "Player 1: test1\n" + "Player 2: test2\n";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testShowActivePlayerEmpty() {
        String actual = PlayerSetup.showActivePlayers();
        String expected = "There are no active players.";
        Assert.assertEquals(actual, expected);
    }
}

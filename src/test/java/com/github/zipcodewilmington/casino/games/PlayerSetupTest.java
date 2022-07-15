package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.PlayerSetup;
import org.junit.Assert;
import org.junit.Test;

public class PlayerSetupTest {
    @Test
    public void testAddActivePlayer() {
        PlayerSetup.activeAccounts.clear();
        Account account = new Account();
        PlayerSetup.addActiveAccount(account);
        int expected = 1;
        int actual = PlayerSetup.activeAccounts.size();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testRemoveActivePlayer() {
        PlayerSetup.activeAccounts.clear();
        Account account = new Account();
        PlayerSetup.addActiveAccount(account);
        PlayerSetup.removeActiveAccount(account);
        int expected = 0;
        int actual = PlayerSetup.activeAccounts.size();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testShowActivePlayer() {
        PlayerSetup.activeAccounts.clear();
        Account account1 = new Account("test1","test1","test1", 1000);
        Account account2 = new Account("test2","test2","test2", 1000);
        PlayerSetup.addActiveAccount(account1);
        PlayerSetup.addActiveAccount(account2);
        String actual = PlayerSetup.showActiveAccounts();
        String expected = "Player 1: test1\n" + "Player 2: test2\n";
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testShowActivePlayerEmpty() {
        PlayerSetup.activeAccounts.clear();
        String actual = PlayerSetup.showActiveAccounts();
        String expected = "There are no active players.";
        Assert.assertEquals(actual, expected);
    }
}

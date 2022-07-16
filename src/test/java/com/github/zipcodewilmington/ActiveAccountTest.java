package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
import org.junit.Assert;
import org.junit.Test;

public class ActiveAccountTest {
    @Test
    public void testAddActivePlayer() {
        ActiveAccount.activeAccounts.clear();
        Account account = new Account();
        ActiveAccount.addActiveAccount(account);
        int expected = 1;
        int actual = ActiveAccount.activeAccounts.size();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testRemoveActivePlayer() {
        ActiveAccount.activeAccounts.clear();
        Account account = new Account();
        ActiveAccount.addActiveAccount(account);
        ActiveAccount.removeActiveAccount(account);
        int expected = 0;
        int actual = ActiveAccount.activeAccounts.size();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testShowActivePlayer() {
        ActiveAccount.activeAccounts.clear();
        Account account1 = new Account("test1","test1", 1000);
        Account account2 = new Account("test2","test2", 1000);
        ActiveAccount.addActiveAccount(account1);
        ActiveAccount.addActiveAccount(account2);
        String actual = ActiveAccount.showActiveAccounts();
        String expected = "Account 1: test1\n" + "Account 2: test2\n";
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testShowActivePlayerEmpty() {
        ActiveAccount.activeAccounts.clear();
        String actual = ActiveAccount.showActiveAccounts();
        String expected = "There are no active players.";
        Assert.assertEquals(actual, expected);
    }
}

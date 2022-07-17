package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
import org.junit.Assert;
import org.junit.Test;

public class ActiveAccountTest {
    private Account acct;
    private ActiveAccount aa;
    @Test
    public void testAddActivePlayer() {
        aa = new ActiveAccount();
        acct = new Account();
        aa.activeAccounts.clear();
        Account account = new Account();
        aa.addActiveAccount(account);
        int expected = 1;
        int actual = aa.activeAccounts.size();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testRemoveActivePlayer() {
        aa = new ActiveAccount();
        acct = new Account();
        aa.activeAccounts.clear();
        Account account = new Account();
        aa.addActiveAccount(account);
        aa.removeActiveAccount(account);
        int expected = 0;
        int actual = aa.activeAccounts.size();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testShowActivePlayer() {
        aa = new ActiveAccount();
        acct = new Account();
        aa.activeAccounts.clear();
        Account account1 = new Account("test1","test1", 1000);
        Account account2 = new Account("test2","test2", 1000);
        aa.addActiveAccount(account1);
        aa.addActiveAccount(account2);
        String actual = aa.showActiveAccounts();
        String expected = "Account 1: test1\n" + "Account 2: test2\n";
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testShowActivePlayerEmpty() {
        aa = new ActiveAccount();
        acct = new Account();
        aa.activeAccounts.clear();
        String actual = aa.showActiveAccounts();
        String expected = "There are no active players!";
        Assert.assertEquals(actual, expected);
    }
}

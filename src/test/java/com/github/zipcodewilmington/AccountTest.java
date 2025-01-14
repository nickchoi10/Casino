package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.ActiveAccount;
import org.junit.Assert;
import org.junit.Test;

//8 tests written

public class AccountTest {
    private Account acct;
    private ActiveAccount aa;
    @Test
    public void testSetAccountName(){
        acct = new Account();
        aa = new ActiveAccount();
        Account account = new Account();
        account.setAccountName("Peter");
        String expected = "Peter";
        String actual = account.getAccountName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetPassword(){
        Account account = new Account();
        account.setPassword("123");
        String expected = "123";
        String actual = account.getPassword();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetBalance(){
        Account account = new Account();
        account.setBalance(2000);
        int expected = 2000;
        int actual = account.getBalance();
        Assert.assertEquals(expected, actual);
    }
    @Test
    //Constructor Test
    public void testAcctConstructor() {
        Account account = new Account("Gerald1", "432", 12345);

        String expAcctName = "Gerald1";
        String expPass = "432";
        int expBal = 12345;
        int actBal = account.getBalance();

        Assert.assertEquals(account.getAccountName(), expAcctName);
        Assert.assertEquals(account.getPassword(), expPass);
        Assert.assertEquals(actBal, expBal);
    }
    @Test
    public void testAccountExists(){
        acct = new Account();
        Account account1 = new Account("kyle", "kyle", 100);
        boolean actual = acct.accountExists("kyle");
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testMakeBet(){
        acct = new Account();
        Account account = new Account("acctName", "pass", 500);
        int actual = account.makeBetTest(account, 200);
        int expected = 300;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDeposit(){
        acct = new Account();
        Account account = new Account("troy", "troy", 100);
        account.deposit(account, 100);
        int expected = 200;
        int actual = account.getBalance();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testLogin() {
        acct = new Account();
        Account account = new Account("test", "test", 100);
        aa.activeAccounts.clear();
        acct.loginTest();

        int actual = aa.activeAccounts.size();
        int expected = 1;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetBalance() {
        acct = new Account();
        aa = new ActiveAccount();
        aa.activeAccounts.clear();
        Account account = new Account ("test", "test", 2000);
        int actual = account.getBalance();
        int expected = 2000;
        Assert.assertEquals(actual, expected);
    }
}

package com.github.zipcodewilmington.casino;

public abstract class Gambler implements PlayerInterface {
    String name;
    Account account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getArcadeAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void run() {
    }
}

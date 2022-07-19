package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.games.cardgames.CardRank;
import com.github.zipcodewilmington.casino.games.cardgames.CardSuit;
import com.github.zipcodewilmington.casino.games.cardgames.Dealer;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestPokerMain {
    PokerMain main;
    PokerPlayer player;

    @BeforeEach
    public void init() {
        main = new PokerMain();
        player = new PokerPlayer("Meilinda");
        player.getArcadeAccount().setBalance(1000);
    }

    @Test
    void testHandleFold() {
        player.setAnteBet(20);
        player.setPairPlusBet(20);

        int expectedBalance = 960;
        main.handleFold(player);

        int actualBalance = player.getArcadeAccount().getBalance();

        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    void testHandlePlayBetNotEnoughBal() {
        player.getArcadeAccount().setBalance(0);
        Boolean expectedRes = false;

        Boolean actualRes = main.handlePlayBet(player, 10);

        Assert.assertEquals(expectedRes, actualRes);
    }

    @Test
    void testHandlePlayBet() {
        main.handlePlayBet(player, 200);

        Integer expected = 200;

        Integer actual = player.getPlayBet();

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testHasBalanceInsufficient() {
        Boolean expected = false;

        Boolean actual = main.hasBalance(player, 10, 20);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testSufficientBalance() {
        Boolean expected = true;

        Boolean actual = main.hasBalance(player, 200, 10);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testSetBeforeBets() {
        Integer expectedAnte = 100;
        Integer expectedPairPlus = 100;

        main.setBeforeBets(player, 100, 100);
        Integer actualAnte = player.getAnteBet();
        Integer actualPairPlus = player.getPairPlusBet();

        Assert.assertEquals(expectedAnte, actualAnte);
        Assert.assertEquals(expectedPairPlus, actualPairPlus);
    }

    @Test
    void testState() {
        PokerState expected = PokerState.BETTING;

        main.setState(PokerState.BETTING);
        PokerState actual = main.getState();

        Assert.assertEquals(expected, actual);
    }

    @Test
    void handlePairPlusResultIsPair() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.FIVE), new PlayingCard(CardSuit.DIAMONDS, CardRank.FOUR));

        player.setPairPlusBet(100);
        player.setHand(new PokerHand(cards1));
        main.handlePairPlusResult(player);

        Integer expectedBal = 1100;

        Integer actualBal = player.getArcadeAccount().getBalance();

        Assert.assertEquals(expectedBal, actualBal);
    }

    @Test
    void handlePairPlusResultNotPair() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.SEVEN), new PlayingCard(CardSuit.DIAMONDS, CardRank.FOUR));
        player.setPairPlusBet(100);
        player.setHand(new PokerHand(cards1));
        main.handlePairPlusResult(player);

        Integer expectedBal = 900;

        Integer actualBal = player.getArcadeAccount().getBalance();

        Assert.assertEquals(expectedBal, actualBal);
    }

    @Test
    void deductFromPlayLoser() {
        player.setPlayBet(100);
        player.setAnteBet(100);

        Integer expectedBal = 800;

        main.deductFromPlayLoser(player);

        Integer actualBal = player.getArcadeAccount().getBalance();

        Assert.assertEquals(expectedBal, actualBal);
    }

    @Test
    void handlePlayWinnerDealerQualifies() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.FIVE), new PlayingCard(CardSuit.DIAMONDS, CardRank.FOUR));
        main.getDealer().setHand(new PokerHand(cards1));
        player.setPlayBet(100);
        player.setAnteBet(100);

        main.handlePlayWinner(player);
        Integer expectedBal = 1200;

        Integer actualBal = player.getArcadeAccount().getBalance();

        Assert.assertEquals(expectedBal, actualBal);
    }

    @Test
    void handlePlayWinnerDealerNotQualifies() {
        List<PlayingCard> cards1 = Arrays.asList(new PlayingCard(CardSuit.CLUBS, CardRank.FIVE),
                new PlayingCard(CardSuit.HEARTS, CardRank.SEVEN), new PlayingCard(CardSuit.DIAMONDS, CardRank.FOUR));
        main.getDealer().setHand(new PokerHand(cards1));
        player.setPlayBet(100);
        player.setAnteBet(100);

        main.handlePlayWinner(player);
        Integer expectedBal = 1100;

        Integer actualBal = player.getArcadeAccount().getBalance();

        Assert.assertEquals(expectedBal, actualBal);
    }

    @Test
    void testHandlePlayTie() {
        player.setAnteBet(100);
        player.setPlayBet(200);

        main.handlePlayTie(player);

        Integer expectedAnte = 0;
        Integer expectedPlay = 0;

        Integer actualAnte = player.getAnteBet();
        Integer actualPlay = player.getPairPlusBet();

        Assert.assertEquals(expectedAnte, actualAnte);
        Assert.assertEquals(expectedPlay, actualPlay);
    }

}
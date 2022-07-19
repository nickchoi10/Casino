package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.games.cardgames.CardRank;
import com.github.zipcodewilmington.casino.games.cardgames.CardSuit;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import java.util.*;

public class PokerHand extends Hand<PlayingCard> implements PokerHandChecker {
    ThreePokerHandRank handRank;

    public PokerHand(List<PlayingCard> cards) {
        super(cards);
        handRank = calculateRank(this);
    }


    public PokerHand() {
        this.cards = new ArrayList<>();
    }


    public ThreePokerHandRank getRank() {
        return handRank;
    }


    protected boolean isFullHand(List<PlayingCard> handCards) {
        return handCards.size() == 3;
    }


    public boolean hasPair(Hand hand) {
        return getPairRanking(hand) > 0;
    }


    private Map<CardRank, Integer> getRankOccurrence(Hand<PlayingCard> hand) {
        Map<CardRank, Integer> cardMap = new HashMap<>(3);
        for (PlayingCard c : hand.getCards()) {
            Integer count = cardMap.get(c.getRank());
            if (count == null) {
                cardMap.put(c.getRank(), 1);
                continue;
            }
            cardMap.put(c.getRank(), ++count);
        }
        return cardMap;
    }

    public int getPairRanking(Hand<PlayingCard> hand) {
        if (!isFullHand(hand.getCards())) {
            return 0;
        }
        Map<CardRank, Integer> cardMap = getRankOccurrence(hand);
        for (Map.Entry<CardRank, Integer> e : cardMap.entrySet()) {
            if (e.getValue() > 1) {
                if (e.getKey() == CardRank.ACE) {
                    return 14;
                }
                return e.getKey().getValue();
            }
        }
        return 0;
    }

    public int getPairOddRanking(Hand<PlayingCard> hand) {
        if (!isFullHand(hand.getCards())) {
            return 0;
        }
        Map<CardRank, Integer> cardMap = getRankOccurrence(hand);
        for (Map.Entry<CardRank, Integer> e : cardMap.entrySet()) {
            if (e.getValue() == 1) {
                if (e.getKey() == CardRank.ACE) {
                    return 14;
                }
                return e.getKey().getValue();
            }
        }
        return 0;
    }


    public boolean hasFlush(Hand<PlayingCard> hand) {
        List<PlayingCard> cards = hand.getCards();
        if (!isFullHand(hand.getCards())) {
            return false;
        }
        CardSuit target = cards.get(0).getSuit();
        return (cards.get(1).getSuit() == target && cards.get(2).getSuit() == target);
    }


    public boolean isStraightFlush(Hand<PlayingCard> hand) {
        return (hasStraight(hand) && hasFlush(hand));
    }


    public boolean hasStraight(Hand<PlayingCard> hand){
        List<PlayingCard> cards = new ArrayList(hand.getCards());
        if (!isFullHand(hand.getCards())) {
            return false;
        }
        Collections.sort(cards);

        if (cards.get(0).getRank() == CardRank.ACE
                && cards.get(1).getRank() == CardRank.QUEEN
                && cards.get(2).getRank() == CardRank.KING) {
            return true;
        }

        int middleCardRank = cards.get(1).getRank().getValue();
        return (cards.get(0).getRank().getValue() + 1 == middleCardRank
                    && cards.get(2).getRank().getValue() - 1 == middleCardRank);
    }


    public boolean hasThreeOfAKind(Hand<PlayingCard> hand) {
        CardRank targetRank = null;
        for (PlayingCard card : hand.getCards()) {
            if (targetRank == null) {
                targetRank = card.getRank();
                continue;
            }
            if (card.getRank() != targetRank) {
                return false;
            }
        }
        return true;
    }


    public ThreePokerHandRank calculateRank(PokerHand hand) {
        if (isStraightFlush(hand)) {
            return ThreePokerHandRank.STRAIGHT_FLUSH;
        } else if (hasThreeOfAKind(hand)) {
            return ThreePokerHandRank.THREE_OF_A_KIND;
        } else if (hasStraight(hand)) {
            return ThreePokerHandRank.STRAIGHT;
        } else if (hasFlush(hand)) {
            return ThreePokerHandRank.FLUSH;
        } else if (hasPair(hand)) {
            return ThreePokerHandRank.PAIR;
        } else {
            return ThreePokerHandRank.HIGH_CARD;
        }
    }

    /** getHighestCard returns the card with the highest CardRank value in a Hand **/
    public PlayingCard getHighestCard(Hand<PlayingCard> hand, boolean isAceHighest) {
        PlayingCard max = null;

        for (PlayingCard card : hand.getCards()) {
            if (isAceHighest) {
                if (card.getRank() == CardRank.ACE) {
                    return card;
                }
            }
            if (max == null || (card.getRank().getValue() > max.getRank().getValue())) {
                max = card;
            }
        }
        return max;
    }

    public void printHand() {
        try {
            String utf8 = "UTF-8";
            PrintStream printer = new PrintStream(System.out, true, utf8);
            String lowBorder = "┗┈┈┈┈┈┈┈┈┈┈┈┈┈┈┛  ";
            String topBorder = "┏┈┈┈┈┈┈┈┈┈┈┈┈┈┈┓  ";
            String section = "┊              ┊  ";
            String sectionUtf = new String(section.getBytes(utf8));
        for (PlayingCard card : getCards()) {
            String topUtf = new String(topBorder.getBytes(utf8), utf8);
            printer.print(topUtf);
        }
        printer.println();
        for (PlayingCard card : getCards()) {
            String upper = String.format("┊%-14d┊  ", card.getRank().getValue());
            String upperUtf = new String(upper.getBytes(utf8), utf8);
            printer.print(upperUtf);
        }
        printer.println();
        for (PlayingCard card : getCards()) {
            printer.print(sectionUtf);
        }
        printer.println();
        for (PlayingCard card : getCards()) {
            printer.print(sectionUtf);
        }
        printer.println();
        for (PlayingCard card : getCards()) {
            String middle = String.format("┊%7s%-7s┊%-2s", card.getSuit().getUnicode(), "", "");
            String middleUtf = new String(middle.getBytes(utf8), utf8);
            printer.print(middleUtf);
        }
        printer.println();
        for (PlayingCard card : getCards()) {
            printer.print(sectionUtf);
        }
        printer.println();
        for (PlayingCard card : getCards()) {
            printer.print(sectionUtf);
        }
        printer.println();
        for (PlayingCard card : getCards()) {
            String lower = String.format("┊%14d┊  ", card.getRank().getValue());
            String lowerUtf = new String(lower.getBytes(utf8), utf8);
            printer.print(lowerUtf);
        }

        printer.println();
        for (PlayingCard card : getCards()) {
            String lowBorderUtf = new String(lowBorder.getBytes(utf8), utf8);
            printer.print(lowBorderUtf);
        }
        printer.println();

        } catch (UnsupportedEncodingException e) {
            System.out.println("Encoding not supported");
            return;
        }
    }
}

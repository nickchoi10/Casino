package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.games.cardgames.CardRank;
import com.github.zipcodewilmington.casino.games.cardgames.CardSuit;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;

import java.util.*;

public class PokerHand extends Hand implements PokerHandChecker {
    ThreePokerHandRank handRank;

    public PokerHand(List<PlayingCard> cards) {
        this.cards = cards;
        handRank = calculateRank(this);
    }


    public PokerHand() {
        this.cards = new ArrayList<PlayingCard>();
    }


    public ThreePokerHandRank getRank() {
        return handRank;
    }


    private boolean isFullHand(List<PlayingCard> handCards) {
        return handCards.size() == 3;
    }


    public boolean hasPair(Hand hand) {
        return getPairRanking(hand) > 0;
    }


    private Map<CardRank, Integer> getRankOccurrence(Hand hand) {
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

    public int getPairRanking(Hand hand) {
        if (!isFullHand(hand.getCards())) {
            return 0;
        }
        Map<CardRank, Integer> cardMap = getRankOccurrence(hand);
        for (Map.Entry<CardRank, Integer> e : cardMap.entrySet()) {
            if (e.getValue() > 1) {
                return e.getKey().getValue();
            }
        }
        return 0;
    }

    public int getPairOddRanking(Hand hand) {
        if (!isFullHand(hand.getCards())) {
            return 0;
        }
        Map<CardRank, Integer> cardMap = getRankOccurrence(hand);
        for (Map.Entry<CardRank, Integer> e : cardMap.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey().getValue();
            }
        }
        return 0;
    }


    public boolean hasFlush(Hand hand) {
        List<PlayingCard> cards = hand.getCards();
        if (!isFullHand(hand.getCards())) {
            return false;
        }
        CardSuit target = cards.get(0).getSuit();
        return (cards.get(1).getSuit() == target && cards.get(2).getSuit() == target);
    }


    public boolean isStraightFlush(Hand hand) {
        return (hasStraight(hand) && hasFlush(hand));
    }


    public boolean hasStraight(Hand hand){
        List<PlayingCard> cards = new ArrayList(hand.getCards());
        if (!isFullHand(hand.getCards())) {
            return false;
        }
        Collections.sort(cards);

        int middleCardRank = cards.get(1).getRank().getValue();
        return (cards.get(0).getRank().getValue() + 1 == middleCardRank
                    && cards.get(2).getRank().getValue() - 1 == middleCardRank);
    }


    public boolean hasThreeOfAKind(Hand hand) {
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
    public PlayingCard getHighestCard(Hand hand) {
        PlayingCard max = null;

        for (PlayingCard card : hand.getCards()) {
            if (max == null || (card.getRank().getValue() > max.getRank().getValue())) {
                max = card;
            }
        }
        return max;
    }

}

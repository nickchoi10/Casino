package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

public enum PokerState {
    MAIN_MENU {
        @Override
        public PokerState nextState() {
            return BETTING;
        }
    },
    BETTING {
        @Override
        public PokerState nextState() {
            return DEALING;
        }
    },
    DEALING {
        @Override
        public PokerState nextState() {
            return PLAYCHOICE;
        }
    },
    PLAYCHOICE,
    USERFOLD {
        @Override
        public PokerState nextState() {
            return MAIN_MENU;
        }
    },
    USERPLAY {
        @Override
        public PokerState nextState() {
            return WINNERCALC;
        }
    },
    WINNERCALC {
        @Override
        public PokerState nextState() {
            return RESULT_MENU;
        }
    },
    RESULT_MENU {
        @Override
        public PokerState nextState() {
            return BETTING;
        }
    };
    public PokerState nextState() {
        return this;
    };
}

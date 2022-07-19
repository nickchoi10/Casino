package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.ActiveAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.games.BoulderParchmentShears.BPSEngine;

import java.util.Random;

    public class RouletteMain {
        private RouletteEngine re;
        private ActiveAccount aa;
//        public static void main(String[] args) {
//            RouletteEngine miniRoulette  = new RouletteEngine();
//            miniRoulette.startRouletteGame();
//        }
          public void playRoulette() {
              aa = new ActiveAccount();
              re = new RouletteEngine();
                aa.numPlayers(1);
                re.welcomeMessage();
                re.startRouletteGame();
            }

        }





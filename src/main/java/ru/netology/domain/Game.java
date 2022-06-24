package ru.netology.domain;

import java.util.ArrayList;
import java.util.List;


public class Game {

    protected List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int findReg(String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int round(String name1, String name2) {
        int player1 = findReg(name1);
        int player2 = findReg(name2);

        if (player1 == -1) {
            throw new NotRegisteredException("Player with name: " + name1 + " not register");
        }

        if (player2 == -1) {
            throw new NotRegisteredException("Player with name: " + name2 + " not register");
        }

        int strength1 = players.get(player1).getStrength();
        int strengtn2 = players.get(player2).getStrength();

        if (strength1 == strengtn2) {
            return 0;
        }
        if (strength1 > strengtn2) {
            return 1;
        } else {
            return 2;
        }

    }
}


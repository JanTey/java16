package ru.netology.quamid59;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private List<Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public void register(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findPlayer(playerName1);
        Player player2 = findPlayer(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("One or more players not registered.");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    private Player findPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}
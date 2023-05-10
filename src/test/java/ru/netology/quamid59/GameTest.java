package ru.netology.quamid59;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player_1 = new Player(1, "Player_1", 15);
    Player player_2 = new Player(2, "Player_2", 20);
    Player player_3 = new Player(3, "Player_3", 30);
    Player player_4 = new Player(4, "Player_4", 2);
    Player player_5 = new Player(5, "Player_5", 30);
    Game game = new Game();

    @Test
    public void firstPlayerWon() {
        game.register(player_1);
        game.register(player_2);

        int expected = 1;
        int actual = game.round("Player_2", "Player_1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWon() {
        game.register(player_1);
        game.register(player_2);

        int expected = 2;
        int actual = game.round("Player_1", "Player_2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playersWereEqual() {
        game.register(player_3);
        game.register(player_5);

        int expected = 0;
        int actual = game.round("Player_3", "Player_5");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        game.register(player_1);
        game.register(player_2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player_1", "Player_3"));
    }

    @Test
    public void secondPlayerNotRegistered() {
        game.register(player_1);
        game.register(player_2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player_2", "Player_4"));
    }

    @Test
    public void bothPlayersNotRegistered() {
        game.register(player_4);
        game.register(player_5);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player_3", "Player_2"));
    }
}

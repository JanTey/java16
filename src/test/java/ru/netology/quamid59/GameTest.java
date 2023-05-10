package ru.netology.quamid59;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    public void setUp() {
        game = new Game();
        player1 = new Player(1, "John", 100);
        player2 = new Player(2, "Alice", 50);
        player3 = new Player(3, "Bob", 80);
    }

    @Test
    public void testRoundPlayerNotFound() {
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("John", "Alice"));
    }

    @Test
    public void testRoundTie() throws NotRegisteredException {
        game.register(player1);
        game.register(player2);
        int result = game.round("John", "Alice");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testRoundPlayer1Wins() throws NotRegisteredException {
        game.register(player1);
        game.register(player2);
        int result = game.round("John", "Alice");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testRoundPlayer2Wins() throws NotRegisteredException {
        game.register(player1);
        game.register(player3);
        int result = game.round("John", "Bob");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testGetId() {
        Player player = new Player(1, "Alice", 10);
        int expectedId = 1;
        int actualId = player.getId();
        Assertions.assertEquals(expectedId, actualId);
    }
}

package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    Game game = new Game();
    Player player1 = new Player(11, "AAA", 11);
    Player player2 = new Player(22, "BBB", 22);
    Player player3 = new Player(33, "CCC", 33);
    Player player4 = new Player(44, "DDD", 44);

    @Test
    public void TestStr1() {
        game.register(player1);
        game.register(player3);


        int actual = game.round("AAA", "CCC");
        int expected = 2;

        assertEquals (actual, expected);
    }

    @Test
    public void TestError1() {
        game.register(player1);
        game.register(player2);
        game.register(player4);


        assertThrows(NotRegisteredException.class, () -> {
            game.round("123123A", "dsonggoianv");
        });
    }
}



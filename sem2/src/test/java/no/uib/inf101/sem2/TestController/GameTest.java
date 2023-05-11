package no.uib.inf101.sem2.TestController;

import no.uib.inf101.sem2.controller.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(1);
    }

    @Test
    void testInitialization() {
        assertNotNull(game.getFoods(), "Foods list should not be null");
        assertEquals(game.getRows() * game.getCols(), game.getFoods().size() + game.getScore(), "Initial foods count and score should match the grid size");
    }


}
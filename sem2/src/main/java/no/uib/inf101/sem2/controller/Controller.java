package no.uib.inf101.sem2.controller;

import no.uib.inf101.sem2.model.Snake;

import java.awt.event.KeyEvent;

public class Controller {
    private Snake snakeOne;
    private Snake snakeTwo;
    private Game game;

    public Controller(Game game, Snake snakeOne, Snake snakeTwo) {
        this.game = game;
        this.snakeOne = snakeOne;
        this.snakeTwo = snakeTwo;
    }

    public void handleKeyEvent(int keyCode, boolean isGameOver) {
        // Snake One controls
        switch (keyCode) {
            case KeyEvent.VK_UP:
                snakeOne.setDirection(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                snakeOne.setDirection(0, 1);
                break;
            case KeyEvent.VK_LEFT:
                snakeOne.setDirection(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                snakeOne.setDirection(1, 0);
                break;
            case KeyEvent.VK_ENTER:
                if (isGameOver) {
                    // Call game restart method
                    game.restart();
                }
                break;
            case KeyEvent.VK_SPACE:
                game.togglePause();
                break;
        }

        // Snake Two controls
        if (snakeTwo != null) {
            switch (keyCode) {
                case KeyEvent.VK_W:
                    snakeTwo.setDirection(0, -1);
                    break;
                case KeyEvent.VK_S:
                    snakeTwo.setDirection(0, 1);
                    break;
                case KeyEvent.VK_A:
                    snakeTwo.setDirection(-1, 0);
                    break;
                case KeyEvent.VK_D:
                    snakeTwo.setDirection(1, 0);
                    break;
            }
        }
    }
}

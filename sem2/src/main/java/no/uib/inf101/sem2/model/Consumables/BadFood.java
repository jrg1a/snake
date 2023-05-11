package no.uib.inf101.sem2.model.Consumables;

import no.uib.inf101.sem2.grid.IGrid;
import no.uib.inf101.sem2.model.Consumables.Food;
import no.uib.inf101.sem2.model.Snake;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BadFood extends Food {
    private final int SLOW_DOWN_DURATION = 5000; // 5 seconds in milliseconds
    private Snake affectedSnake;

    /**
     * Constructs a new Food object/instanc with the specified grid and snake.
     *
     * @param grid  The game grid.
     * @param snake The snake that will interact with this food.
     */
    public BadFood(IGrid<Object> grid, Snake snake) {
        super(grid, snake);
    }


    public void consume(Snake snake) {
        // Slow down the snake
        affectedSnake = snake;
        snake.setSpeed(0.5);
        //timer to reset the speed after the duration
        Timer timer = new Timer(SLOW_DOWN_DURATION, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSpeed();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void resetSpeed() {
        if (affectedSnake != null) {
            affectedSnake.setSpeed(1.0);
            affectedSnake = null;
        }
    }
}

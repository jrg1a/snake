package no.uib.inf101.sem2.model;

import no.uib.inf101.sem2.controller.Game;
import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.IGrid;
import no.uib.inf101.sem2.model.Consumables.Food;
import no.uib.inf101.sem2.model.Consumables.SuperFood;

public class Snake_player_two extends Snake {


    public Snake_player_two(IGrid<Object> grid, Game game) {
        super(grid, game);
    }


    @Override
    public void move() {
        if (isDead) {
            return;
        }
        if (body == null || body.isEmpty()) {
            return;
        }
        CellPosition head = body.getFirst();
        CellPosition newHead = new CellPosition(head.row() + dy, head.col() + dx);

        if (!grid.positionIsOnGrid(newHead)) {
            game.gameOver(this);
            return;
        }

        if (grid.get(newHead) instanceof Snake) {
            game.gameOver(this);
            return;
        }

        boolean ateFood = false;
        for (Food food : game.getFoods()) {
            if (food.getPosition().equals(newHead)) {
                food.generate(); // Respawn food at a new random position
                grow(); // Make the snake grow
                ateFood = true;
                // Check if the eaten food is SuperFood
                if (food instanceof SuperFood) {
                    game.increaseScoreSnakeTwo(2); // Double the score for SuperFood
                } else {
                    game.increaseScoreSnakeTwo(1); // Regular score for Food
                }
                break;
            }
        }
        if (!ateFood) {
            CellPosition tail = body.removeLast();
            grid.set(tail, null);
        }
        body.addFirst(newHead);
        grid.set(newHead, this);
    }



}


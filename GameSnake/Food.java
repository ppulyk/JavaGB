/**
 * Java. Classic Game Snake
 * Class Food: minimal building element
 * 
 * @author Pavel Pulyk
 * @version 0.0.1 27.11.2021 
*/

import java.util.Random;
import java.awt.Color;

class Food extends Cell {
	private Random random; 
	private Snake snake;    
	
    public Food(Snake snake) {   
        super(-1, -1, GameSnake.CELL_SIZE, GameSnake.FOOD_COLOR); 
    	random = new Random();
    	this.snake = snake;
    }

    public boolean isFood(int x, int y) {          // if food has x, y, coordinate
    	return (getX() == x) && (getY() == y);
    }

    public boolean isEaten() {          // if food is eaten or not
    	return getX() == -1;
    }

    public void eat() {      // virtual eating
    	set(-1, -1);
    }

    public void appear() {           // show food at new x, y coordinates  это метод заставляет еду появиться на экране.  
    	int x, y;
    	do {
    		x = random.nextInt(GameSnake.CANVAS_WIDTH);
    		y = random.nextInt(GameSnake.CANVAS_HEIGHT);
    	} while (snake.isInSnake(x, y));
    	set(x, y);
    }
}
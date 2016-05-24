/*
 * Implementation of SnakeBrain which does random moves
 * Author: Thomas Stüber
 * */

package Brains;

import java.util.ArrayList;
import java.util.Random;

import Logic.Field.CellType;
import Logic.GameInfo;
import Logic.Point;
import Logic.Snake;
import Logic.Snake.Direction;
import Logic.SnakeBrain;

public class RandomBrain implements SnakeBrain {
	
	public Direction nextDirection(GameInfo gameInfo, Snake snake) {
		
		Random generator = new Random();
	
		int randomInt = generator.nextInt(4);
		
		if (randomInt == 0) {
			return Snake.Direction.LEFT;
		} else if (randomInt == 1) {
			return Snake.Direction.RIGHT;
		} else if (randomInt == 2) {
			return Snake.Direction.UP;
		} else
			return Snake.Direction.DOWN;
	}
	
	public Point getClosestApple(GameInfo gameInfo, Point headPosition) {
		return new Point(0,0);
	}
}

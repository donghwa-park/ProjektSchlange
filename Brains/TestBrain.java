/*
 * Implementation of TestBrain which does custom moves
 * Author: Donghwa Park, Yosra Dziri, Jan Saffert
 * */


/*
 * TODO: 
 * > Calculating Apple Position
 * > Calculating Opponent Position
 * > Find fastest Path to Apple
 * > Find Path to defeat Opponent
 */
		

package Brains;

import java.util.ArrayList;

import Logic.Apple;
import Logic.Field;
import Logic.GameInfo;
import Logic.Point;
import Logic.Snake;
import Logic.Snake.Direction;
import Logic.SnakeBrain;

public class TestBrain implements SnakeBrain {
	
	public Direction nextDirection(GameInfo gameInfo, Snake snake) {

		Point headPosition = snake.headPosition();

		Point up = new Point(headPosition.x,headPosition.y-1);
		Point down = new Point(headPosition.x,headPosition.y+1);
		Point left = new Point(headPosition.x-1,headPosition.y);
		Point right = new Point(headPosition.x+1,headPosition.y);
		
		if (gameInfo.field().cell(up) == Field.CellType.SNAKE || gameInfo.field().cell(up) == Field.CellType.WALL) {
			if (gameInfo.field().cell(down) == Field.CellType.SNAKE || gameInfo.field().cell(down) == Field.CellType.WALL) {
				if (gameInfo.field().cell(left) == Field.CellType.SNAKE || gameInfo.field().cell(left) == Field.CellType.WALL) {
					return Snake.Direction.RIGHT;
				} else if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
					return Snake.Direction.LEFT;
				} else {
					Point apple = getClosestApple(gameInfo, headPosition);
					
					if (apple.x <= headPosition.x) {
						return Snake.Direction.LEFT;
					} else {
						return Snake.Direction.RIGHT;
					}
				}					
			} else if (gameInfo.field().cell(left) == Field.CellType.SNAKE || gameInfo.field().cell(left) == Field.CellType.WALL) {
				if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
					return Snake.Direction.DOWN;
				} else {					
					Point apple = getClosestApple(gameInfo, headPosition);
					
					int calcDistanceRight = Math.abs(headPosition.x+1 - apple.x) + Math.abs(headPosition.y - apple.y);
					int calcDistanceDown = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y+1 - apple.y);
					
					if (calcDistanceDown <= calcDistanceRight) {
						return Snake.Direction.DOWN;
					} else {
						return Snake.Direction.RIGHT;
					}
				}
			} else if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
				Point apple = getClosestApple(gameInfo, headPosition);
				
				int calcDistanceLeft = Math.abs(headPosition.x-1 - apple.x) + Math.abs(headPosition.y - apple.y);
				int calcDistanceDown = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y+1 - apple.y);
								
				if (calcDistanceDown <= calcDistanceLeft) {
					return Snake.Direction.DOWN;
				} else {
					return Snake.Direction.LEFT;
				}
			} else {
				Point apple = getClosestApple(gameInfo, headPosition);
				
				int calcDistanceLeft = Math.abs(headPosition.x-1 - apple.x) + Math.abs(headPosition.y - apple.y);
				int calcDistanceRight = Math.abs(headPosition.x+1 - apple.x) + Math.abs(headPosition.y - apple.y);
				int calcDistanceDown = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y+1 - apple.y);
				
				if (calcDistanceDown <= Math.min(calcDistanceLeft, calcDistanceRight)) {
					return Snake.Direction.DOWN;
				} else if (calcDistanceLeft <= calcDistanceRight) {
					return Snake.Direction.LEFT;
				} else {
					return Snake.Direction.RIGHT;
				}
			}
		} else if (gameInfo.field().cell(down) == Field.CellType.SNAKE || gameInfo.field().cell(down) == Field.CellType.WALL) {
			if (gameInfo.field().cell(left) == Field.CellType.SNAKE || gameInfo.field().cell(left) == Field.CellType.WALL) {
				if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
					return Snake.Direction.UP;
				} else {					
					Point apple = getClosestApple(gameInfo, headPosition);
					
					int calcDistanceRight = Math.abs(headPosition.x+1 - apple.x) + Math.abs(headPosition.y - apple.y);
					int calcDistanceUp = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y-1 - apple.y);
					
					if (calcDistanceUp <= calcDistanceRight) {
						return Snake.Direction.UP;
					} else {
						return Snake.Direction.RIGHT;
					}
				}
			} else if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {					
				Point apple = getClosestApple(gameInfo, headPosition);
				
				int calcDistanceLeft = Math.abs(headPosition.x-1 - apple.x) + Math.abs(headPosition.y - apple.y);
				int calcDistanceUp = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y-1 - apple.y);
				
				if (calcDistanceUp <= calcDistanceLeft) {
					return Snake.Direction.UP;
				} else {
					return Snake.Direction.LEFT;
				}
			} else {
				Point apple = getClosestApple(gameInfo, headPosition);
				
				int calcDistanceLeft = Math.abs(headPosition.x-1 - apple.x) + Math.abs(headPosition.y - apple.y);
				int calcDistanceRight = Math.abs(headPosition.x+1 - apple.x) + Math.abs(headPosition.y - apple.y);
				int calcDistanceUp = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y-1 - apple.y);
				
				if (calcDistanceUp <= Math.min(calcDistanceLeft, calcDistanceRight)) {
					return Snake.Direction.UP;
				} else if (calcDistanceLeft <= calcDistanceRight) {
					return Snake.Direction.LEFT;
				} else {
					return Snake.Direction.RIGHT;
				}
			}
		} else if (gameInfo.field().cell(left) == Field.CellType.SNAKE || gameInfo.field().cell(left) == Field.CellType.WALL) {
			if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
				Point apple = getClosestApple(gameInfo, headPosition);
				
				if (apple.y <= headPosition.y) {
					return Snake.Direction.UP;
				} else {
					return Snake.Direction.DOWN;
				}
			} else {
				Point apple = getClosestApple(gameInfo, headPosition);
				
				int calcDistanceDown = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y+1 - apple.y);
				int calcDistanceRight = Math.abs(headPosition.x+1 - apple.x) + Math.abs(headPosition.y - apple.y);
				int calcDistanceUp = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y-1 - apple.y);
				
				if (calcDistanceUp <= Math.min(calcDistanceDown, calcDistanceRight)) {
					return Snake.Direction.UP;
				} else if (calcDistanceDown <= calcDistanceRight) {
					return Snake.Direction.DOWN;
				} else {
					return Snake.Direction.RIGHT;
				}
			}
		} else if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
			Point apple = getClosestApple(gameInfo, headPosition);
			
			int calcDistanceDown = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y+1 - apple.y);
			int calcDistanceLeft = Math.abs(headPosition.x-1 - apple.x) + Math.abs(headPosition.y - apple.y);
			int calcDistanceUp = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y-1 - apple.y);
			
			if (calcDistanceUp <= Math.min(calcDistanceDown, calcDistanceLeft)) {
				return Snake.Direction.UP;
			} else if (calcDistanceDown <= calcDistanceLeft) {
				return Snake.Direction.DOWN;
			} else {
				return Snake.Direction.LEFT;
			}
		} else {
			Point apple = getClosestApple(gameInfo, headPosition);
			
			int calcDistanceDown = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y+1 - apple.y);
			int calcDistanceLeft = Math.abs(headPosition.x-1 - apple.x) + Math.abs(headPosition.y - apple.y);
			int calcDistanceUp = Math.abs(headPosition.x - apple.x) + Math.abs(headPosition.y-1 - apple.y);
			
			if (apple.x <= headPosition.x) {
				if (calcDistanceUp <= Math.min(calcDistanceDown, calcDistanceLeft)) {
					return Snake.Direction.UP;
				} else if (calcDistanceDown <= calcDistanceLeft) {
					return Snake.Direction.DOWN;
				} else {
					return Snake.Direction.LEFT;
				}
			} else {
				return Snake.Direction.RIGHT;
			}
		}
	}
	
	public Point getClosestApple(GameInfo gameInfo, Point headPosition) {
		
		ArrayList<Point> apples = new ArrayList<Point>();
		
		Point closestApple = new Point(0,0);
		int height = gameInfo.field().height();
		int width = gameInfo.field().width();
		int closeApple = 0;
		
		for (int i = 1; i < width - 1; i++) {
			for (int j = 1; j < height - 1; j++) {
				if (gameInfo.field().cell(new Point(i,j)) == Field.CellType.APPLE) {
					apples.add(new Point(i,j));
				}
			}
		}
		
		for (int i = 0; i < apples.size(); i++) {
			int diff = Math.abs(headPosition.x - apples.get(i).x) + Math.abs(headPosition.y - apples.get(i).y);
			if (closeApple == 0) {
				closeApple = diff;
				closestApple = apples.get(i);
			} else if (diff < closeApple) {
				closeApple = diff;			
				closestApple = apples.get(i);	
			}
		}
		return closestApple;
	}
}

/*
 * Implementation of CustomBrain which does custom moves
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

import java.util.Random;

import Logic.Field.CellType;
import Logic.Field;
import Logic.GameInfo;
import Logic.Point;
import Logic.Snake;
import Logic.Snake.Direction;
import Logic.SnakeBrain;

public class CustomBrain implements SnakeBrain {
	
	public Direction nextDirection(GameInfo gameInfo, Snake snake) {

		Point headPosition = snake.headPosition();
		int height = gameInfo.field().height();
		int width = gameInfo.field().width();

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
					/*----------------------------
					 *should look for apple
					 *replaced for now by random function
					 *--------------------------*/
					int rand = (int)(Math.random()*2);
					if (rand == 0) {
						return Snake.Direction.LEFT;
					} else {
						return Snake.Direction.RIGHT;
					}
					//----------------------------
				}					
			} else if (gameInfo.field().cell(left) == Field.CellType.SNAKE || gameInfo.field().cell(left) == Field.CellType.WALL) {
				if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
					return Snake.Direction.DOWN;
				} else {
					/*----------------------------
					 *should look for apple
					 *replaced for now by random function
					 *--------------------------*/
					int rand = (int)(Math.random()*2);
					if (rand == 0) {
						return Snake.Direction.DOWN;
					} else {
						return Snake.Direction.RIGHT;
					}
					//----------------------------
				}
			} else if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
				/*----------------------------
				 *should look for apple
				 *replaced for now by random function
				 *--------------------------*/
				int rand = (int)(Math.random()*2);
				if (rand == 0) {
					return Snake.Direction.DOWN;
				} else {
					return Snake.Direction.LEFT;
				}
				//----------------------------
			} else {
				/*----------------------------
				 *should look for apple
				 *replaced for now by random function
				 *--------------------------*/
				int rand = (int)(Math.random()*3);
				if (rand == 0) {
					return Snake.Direction.DOWN;
				} else if (rand == 1) {
					return Snake.Direction.LEFT;
				} else {
					return Snake.Direction.RIGHT;
				}
				//----------------------------
			}
		} else if (gameInfo.field().cell(down) == Field.CellType.SNAKE || gameInfo.field().cell(down) == Field.CellType.WALL) {
			if (gameInfo.field().cell(left) == Field.CellType.SNAKE || gameInfo.field().cell(left) == Field.CellType.WALL) {
				if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
					return Snake.Direction.UP;
				} else {
					/*----------------------------
					 *should look for apple
					 *replaced for now by random function
					 *--------------------------*/
					int rand = (int)(Math.random()*2);
					if (rand == 0) {
						return Snake.Direction.UP;
					} else {
						return Snake.Direction.RIGHT;
					}
					//----------------------------
				}
			} else if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
				/*----------------------------
				 *should look for apple
				 *replaced for now by random function
				 *--------------------------*/
				int rand = (int)(Math.random()*2);
				if (rand == 0) {
					return Snake.Direction.UP;
				} else {
					return Snake.Direction.LEFT;
				}
				//----------------------------
			} else {
				/*----------------------------
				 *should look for apple
				 *replaced for now by random function
				 *--------------------------*/
				int rand = (int)(Math.random()*3);
				if (rand == 0) {
					return Snake.Direction.UP;
				} else if (rand == 1) {
					return Snake.Direction.LEFT;
				} else {
					return Snake.Direction.RIGHT;
				}
				//----------------------------
			}
		} else if (gameInfo.field().cell(left) == Field.CellType.SNAKE || gameInfo.field().cell(left) == Field.CellType.WALL) {
			if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
				/*----------------------------
				 *should look for apple
				 *replaced for now by random function
				 *--------------------------*/
				int rand = (int)(Math.random()*2);
				if (rand == 0) {
					return Snake.Direction.UP;
				} else {
					return Snake.Direction.DOWN;
				}
				//----------------------------
			} else {
				/*----------------------------
				 *should look for apple
				 *replaced for now by random function
				 *--------------------------*/
				int rand = (int)(Math.random()*3);
				if (rand == 0) {
					return Snake.Direction.DOWN;
				} else if (rand == 1) {
					return Snake.Direction.UP;
				} else {
					return Snake.Direction.RIGHT;
				} 
				//----------------------------
			}
		} else if (gameInfo.field().cell(right) == Field.CellType.SNAKE || gameInfo.field().cell(right) == Field.CellType.WALL) {
			/*----------------------------
			 *should look for apple
			 *replaced for now by random function
			 *--------------------------*/
			int rand = (int)(Math.random()*3);
			if (rand == 0) {
				return Snake.Direction.DOWN;
			} else if (rand == 1) {
				return Snake.Direction.UP;
			} else {
				return Snake.Direction.LEFT;
			}
			//----------------------------
		} else {
			/*----------------------------
			 *should look for apple
			 *replaced for now by random function
			 *--------------------------*/
			int rand = (int)(Math.random()*4);
			if (rand == 0) {
				return Snake.Direction.DOWN;
			} else if (rand == 1) {
				return Snake.Direction.UP;
			} else if (rand == 2) {
				return Snake.Direction.LEFT;
			} else {
				return Snake.Direction.RIGHT;
			}
			//----------------------------
		}
	}
}


//-------------------TESTSCHLEIFE-----------------------
//
//		for (int i = 0; i < height; i++) {
//			for (int j = 0; j < width; j++) {
//				if (gameInfo.field().cell(new Point(i,j)) == Field.CellType.WALL) {
//					int rand = (int)(Math.random()*2);
//					if (rand == 0) {
//						return Snake.Direction.LEFT;
//					} else if (rand == 1) {
//						return Snake.Direction.RIGHT;
//					}
//					
//				}
//				if (gameInfo.field().cell(new Point(i,j)) == Field.CellType.SNAKE) {
//					int rand = (int)(Math.random()*2);
//					if (rand == 0) {
//						return Snake.Direction.LEFT;
//					} else if (rand == 1) {
//						return Snake.Direction.RIGHT;
//					}
//				}
//			}
//		}		
	


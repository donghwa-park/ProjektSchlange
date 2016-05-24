/*
 * This interface should be implemented if one wants to control the behavior of a snake
 * Author: Thomas Stüber
 * */

package Logic;

import java.util.ArrayList;

public interface SnakeBrain {
	Snake.Direction nextDirection(GameInfo gameInfo, Snake snake);
	
	Point getClosestApple(GameInfo gameInfo, Point headPosition);
}

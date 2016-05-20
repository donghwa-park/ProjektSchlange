/*
 * Represents Monsters
 * Author: Donghwa Park, Yosra Dziri, Jan Saffert
 * */

package Logic;

public class Monsters {
	
	int grow;
	int changeScoreGrow;
	Point position;
	int freezeTime;
	int slowTime;
	
	public Monsters(Point position) {
		this.position = position;
		this.grow = 2;
		this.changeScoreGrow = 100;
		this.freezeTime = 20;
		this.slowTime = 100;
	}
	
	public void applyGrow (Snake snake) {
		snake.changeScore(changeScoreGrow);
		snake.grow(grow);
	}
	
	public void applyFreeze (Snake snake) {
		snake.freeze(freezeTime);
	}
	
	public void applySlow (Snake snake) {
		snake.slow(slowTime);
	}
}

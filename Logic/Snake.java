/*
 * Represents a snake
 * Author: Thomas Stüber
 * */

package Logic;
import java.util.LinkedList;

import javafx.scene.paint.Color;

//added freezeTime + slowTime to apply freeze/slow
public class Snake {
	private int score; //current score of this snake
	private LinkedList<Point> segments; //snake segments, snake head is last element
	public int grow; //tail of the snake isn't deleted while moving as long as grow is > 0
	private GameInfo gameInfo;
	private SnakeBrain brain;
	private boolean alive;
	private Color color;
	private int freezeTime;
	private int slowTime;
	
	//move directions
	public enum Direction {
		LEFT,
		RIGHT,
		UP,
		DOWN
	}
	
	public Snake(Point startPosition, GameInfo gameInfo, SnakeBrain brain, Color color) {
		super();
		this.score = 0;
		this.segments = new LinkedList<Point>();
		this.segments.add(startPosition);
		this.grow = 0;
		this.gameInfo = gameInfo;
		this.brain = brain;
		this.alive = true;
		this.color = color;
		this.freezeTime = 0;
		this.slowTime = 0;
	}
	
	public void changeScore(int delta) {
		score += delta;
	}
	
	public void grow(int n) {
		grow += n;
	}
	
	public void freeze(int n) {
		freezeTime = n;
	}
	
	public void slow(int n) {
		slowTime = n;
	}
	
	public void move() {		 
		if (slowTime % 5 >= 1) {
			slowTime--;
		} else if (freezeTime > 0) {
			freezeTime--;
		}
		else {
			Direction direction = brain.nextDirection(gameInfo, this); //ask user implemented brain for next move
			Point head = segments.getLast();
		
			//calculate new head position
			Point newHead = new Point(head.x, head.y);
			switch(direction) {
			case DOWN:
				newHead.y++;
				break;
			case LEFT:
				newHead.x--;
				break;
			case RIGHT:
				newHead.x++;
				break;
			case UP:
				newHead.y--;
				break;
			default:
				break;
			}
			if (newHead.x == -1) {
				newHead.x = gameInfo.field().width()-1;
			}
			if (newHead.x == gameInfo.field().width()) {
				newHead.x = 0;
			}
			if (newHead.y == -1) {
				newHead.y = gameInfo.field().height()-1;
			}
			if (newHead.y == gameInfo.field().height()) {
				newHead.y = 0;
			}
			
			segments.addLast(newHead);
			
			if (grow == 0) { //don't grow, delete tail
				Point rp = segments.removeFirst();
				gameInfo.field().setCell(Field.CellType.SPACE, rp);
			} else { //tail isn't deleted, snake grew one field
				grow--;
			}
			slowTime--;
		}
	}
	
	public Point headPosition() {
		return segments.getLast();
	}
	
	public LinkedList<Point> segments() {
		return segments;
	}
	
	public boolean alive() {
		return alive;
	}
	
	public void kill() {
		alive = false;
	}
	
	public Color color() {
		return color;
	}
}

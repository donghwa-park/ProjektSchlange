/*
 * Stores the current state of the field
 * Author: Thomas Stüber
 * */

package Logic;
import java.util.Arrays;
import java.util.HashMap;

// Added Fields
public class Field {
	public enum CellType {
		SNAKE,
		WALL,
		APPLE,
		SPACE,
		FREEZE,
		SHRINK,
		SLOW,
		KILL,
		GROW
	}

	private CellType[][] cells;
	private int width;
	private int height;
	private HashMap<Point, Apple> apples;
	private HashMap<Point, Monsters> monsters;
	
	public Field(int width, int height) {
		cells = new CellType[width][height];
		this.width = width;
		this.height = height;
		apples = new HashMap<Point, Apple>();
		monsters = new HashMap<Point, Monsters>();
	}
	
	public static Field defaultField(int width, int height) {
		Field f = new Field(width, height);
		for (int x = 0;x < width;x++) {
			for (int y = 0;y < height;y++) {
				if (x == 0 || x == width-1 || y == 0 || y == height-1) {
					f.cells[x][y] = CellType.WALL;
				} else {
					f.cells[x][y] = CellType.SPACE;
				}
			}
		}
		return f;
	}
	
	public static Field defaultFieldWithoutBorders(int width, int height) {
		Field f = new Field(width, height);
		for (int x = 0;x < width;x++) {
			for (int y = 0;y < height;y++) {
				f.cells[x][y] = CellType.SPACE;
			}
		}
		return f;
	}
	
	public void addMonsters(Monsters monster, Point position, int number) {
		monsters.put(position, monster);
		if (number == 0) 
			cells[position.x][position.y] = CellType.SLOW;
		else if (number == 1) 
			cells[position.x][position.y] = CellType.FREEZE;
		else if (number == 2) 
			cells[position.x][position.y] = CellType.GROW;
		else if (number == 3) 
			cells[position.x][position.y] = CellType.KILL;
		else if (number == 4) 
			cells[position.x][position.y] = CellType.SHRINK;
		
	}
	
	public Monsters getMonsters(Point position) {
		return monsters.get(position);
	}
	
	public void removeMonsters(Point position) {
		monsters.remove(position);
		cells[position.x][position.y] = CellType.SPACE;
	}
	
	public void addApple(Apple apple, Point position) {
		apples.put(position,  apple);
		cells[position.x][position.y] = CellType.APPLE;
	}
	
	public Apple getApple(Point position) {
		return apples.get(position);
	}
	
	public void removeApple(Point position) {
		apples.remove(position);
		cells[position.x][position.y] = CellType.SPACE;
	}
	
	public void draw() {
		System.out.println(this);
	}
	
	public void setCell(CellType type, Point point) {
		cells[point.x][point.y] = type;
	}
	
	public CellType cell(Point point) {
		return cells[point.x][point.y];
	}
	
	public int width() {
		return width;
	}
	
	public int height() {
		return height;
	}

	@Override
	public String toString() {
		String s = "";
		for (int y = 0;y < height;y++) {
			for (int x = 0;x < width;x++) {
				switch(cells[x][y]) {
				case APPLE:
					s += "*";
					break;
				case SNAKE:
					s += "#";
					break;
				case SPACE:
					s += " ";
					break;
				case WALL:
					s += "X";
					break;
				case FREEZE:
					s += "F";
					break;
				case SLOW:
					s += "S";
					break;
				case KILL:
					s += "K";
					break;
				case GROW:
					s += "G";
					break;
				case SHRINK:
					s += "s";
					break;
				default:
					break;
				
				}
			}
			if (y < height-1) {
				s += "\n";
			}
		}
		return s;
	}
}

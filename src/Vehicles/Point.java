package Vehicles;

/**
 * class Point containing x and y and getter and setters
 * @author Yoav Yung id:203127329 ,Lidor zaguri id:205622814.
 */
public class Point {
	
	private int x;
	private int  y;
	
	
	public Point() {
		
		
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Point constructor 
	 * @param x the point of x.
	 * @param y the point of y.
	 */
	public Point(int x, int y) {
		
		
		this.x = x;
		this.y = y;
	}

	public Point(Point p) {
		this(p.getX(), p.getY());
	}

	/**
	 * getX function.
	 * @return x
	 */
	public int getX() {
		
		
		return x;
	}

	/**
	 * getY
	 * @return y
	 */
	public int getY() {
		
		
		return y;
	}

	/**
	 * setX
	 * @param num number of  x
	 * @return true or false
	 */
	public boolean setX(int num) {
		
		
		if (this.x != num) {
			this.x = num;
			return true;
		}
		return false;
	}

	/**
	 * setY function.
	 * @param num number of y
	 * @return true or false
	 */
	public boolean setY(int num) {
		if (this.y != num) {
			this.y = num;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
package Vehicles;

/**
 * 
 * @author Yoav Yung id:203127329 ,Lidor zaguri id:205622814.
 *
 */
public class Location {
	
	private Point p;
	private direction dir;
	
	
	
	public Location() {
		
		
		this.p = new Point(0,0);
		this.dir = direction.EAST;
	}

	/**
	 * Location constructor.
	 * @param p of point  
	 */
	public Location(Point p) {
		
		
		this.p = new Point(p);
		this.dir = direction.NORTH;
	}

	/**
	 * getPoint function.
	 * @return p
	 */
	public Point getPoint() {
		
		
		return p;
	}

	/**
	 * getDir
	 * @return dir
	 */
	public direction getDir() {
		
		
		return dir;
	}

	/**
	 * setPoint function
	 * @param p point 
	 * @return true
	 */
	public boolean setPoint(Point p) {
		
		
		this.p.setX(p.getX());
		this.p.setY(p.getY());
		return true;
	}

	/**
	 * 
	 * @param d the direction.
	 * @return true or false
	 */
	public boolean setDir(direction d) {
		
		
		if (d != this.dir) {
			this.dir = d;
			return true;
		}
		return false;
	}

	public String toString() {
		return "\nLocation at : " + p.toString() + " at " + dir;
	}
}

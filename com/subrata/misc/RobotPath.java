package com.subrata.misc;

import java.util.ArrayList;
import java.util.Hashtable;

public class RobotPath {

	public static void main(String[] args) {

		Hashtable<Point, Boolean> cache = new Hashtable<Point, Boolean>();
		ArrayList<Point> allPoints = new ArrayList<Point>();

		RobotPath path = new RobotPath();
		path.findNextPointOnThePath(3, 2, allPoints, cache);

		StringBuffer sb = new StringBuffer();
		
		if(allPoints.size()!= 0){
			sb.append("(0,0)");
		}
		
		for (Point p : allPoints) {
			sb.append("->(").append(p.getX()).append(",").append(p.getY())
					.append(")");

		}
		System.out.println("*************** Subrata path is :: "
				+ sb.toString());
	}

	private boolean findNextPointOnThePath(int x, int y, ArrayList<Point> path,
			Hashtable<Point, Boolean> cache) {

		Point p = new Point(x, y);
		if (cache.containsKey(p)) {
			return cache.get(p);
		}

		if (x == 0 && y == 0) {
			// yes we have reached to the termination point.
			return true;
		}

		boolean pathFound = false;
		if (x >= 1 && canMove(x - 1, y)) {
			pathFound = findNextPointOnThePath(x - 1, y, path, cache);
		}

		if (!pathFound && y >= 1 && canMove(x, y - 1)) {
			pathFound = findNextPointOnThePath(x, y - 1, path, cache);
		}

		if (pathFound) {
			path.add(p);
		}

		cache.put(p, pathFound);
		return pathFound;
	}

	/**
	 * Assuming the robot operates only on 2nd quadrant.
	 * 
	 * @param pt
	 * @return
	 */
	private static boolean canMove(int x, int y) {
		boolean canMove = true;

		if (x < 0 || y < 0) {
			canMove = false;
		}
		return canMove;
	}

	/**
	 * The class point.
	 * 
	 * @author subratas
	 * 
	 */
	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		// better we implement hascode and equal impl as we are going to put in
		// hastable for comparing.
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		private RobotPath getOuterType() {
			return RobotPath.this;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]\n";
		}
	}
}

package com.subrata.challenging;

import java.util.ArrayList;


public class EightQueenSubrata {
	
	static int GRID_SIZE = 3;
	
	 class Quadrant {
		int x,y;
		Quadrant(int x, int y){
			this.x = x;
			this.y = y;
		}
		
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
			Quadrant other = (Quadrant) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		
		private EightQueenSubrata getOuterType() {
			return EightQueenSubrata.this;
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList cache = new ArrayList();
		ArrayList<EightQueenSubrata.Quadrant> initialCache = new ArrayList<EightQueenSubrata.Quadrant>();
		
		EightQueenSubrata eightQueenSubrata = new EightQueenSubrata();
		eightQueenSubrata.prepareData(initialCache);
		
		
	}
	
	private void placeQueen(ArrayList<Quadrant> initialCache,ArrayList<EightQueenSubrata.Quadrant> cache){
		
		if(initialCache.size() > 0){
			Quadrant quadrant = initialCache.get(0);
			
			boolean foundInRows = false;
			boolean foundInCols = false;
			boolean foundInDiagonals = false;
				
				
			if(!foundInRows && !foundInCols && !foundInDiagonals){
				cache.add(quadrant);
				//remove all cache
				
			
				
			}else{
				// remove the particular from the cache
				initialCache.remove(quadrant);
			}
			placeQueen(initialCache,cache);
		}
	}
	
	
	private  void  prepareData(ArrayList initialCache) {
		for(int x = 0;x<GRID_SIZE;x++){
			for(int y = 0;y<GRID_SIZE;y++){
				Quadrant quadrant = new Quadrant(x,y);
				initialCache.add(quadrant);
			}
		}
	}
	
}

package search;

import java.util.ArrayList;

public class Knight {
	
	public static final int DIMENSIONS = 10;
	public static final int[] DELTA = {-1, 1};
	public static final int[] DISTS = {1, 2};

	public static ArrayList<int[]> possible_moves(int[] position) {
		
		ArrayList<int[]> moves = new ArrayList<int[]>();
		int delta_x, delta_y;
		int[] coord = new int[2];
		
		
		for(int i : DELTA) {
			for(int j : DELTA) {
				for(int k = 0; k < 2; ++k) {
					delta_x = DISTS[k] * DELTA[i];
					delta_y = DISTS[(k + 1) % 2] * DELTA[j];
					
					coord[0] = position[0] + delta_x;
					coord[1] = position[1] + delta_y;
					if(isValid(coord[0], coord[1])) {
						moves.add(coord);
					}
				}
			}
		}
		return moves;
	}
	
	public static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < DIMENSIONS && y < DIMENSIONS;
	}
}

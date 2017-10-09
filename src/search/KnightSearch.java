package search;

import java.util.ArrayList;

public class KnightSearch {

	/*
	 * Get an initial position
	 * while(solution not found) {
	 * queue positions & add to visited;
	 * create new positions (should be on board bc Knight checks);
	 * dequeue old postions;
	 * delete if already visited new positions;
	 * check if new positions contain solution;
	 * 
	 */


	private static final int DIMENSIONS = 10;

	private ArrayList<int []> queue;
	private boolean[][] not_visited;
	private int[] target;

	public KnightSearch(int[] coords) {
		queue = new ArrayList<int []>();
		not_visited = new boolean[DIMENSIONS][DIMENSIONS];

		enqueue(coords);
		for(int i = 0; i < DIMENSIONS; ++i) {
			for(int j = 0; j < DIMENSIONS; ++j) {
				not_visited[i][j] = true;
			}
		}
	}

	public int[] knight_BFS() {
		int[] coords = new int [2];
		ArrayList<int[]> new_moves;

		while(true) {
			coords = dequeue();
			new_moves = Knight.possible_moves(coords);
			for(int i = 0; i < new_moves.size(); ++i) {
				if(target[0] == new_moves.get(i)[0] && target[1] == new_moves.get(i)[1]) {
					return new_moves.get(i);
				}
				if(not_visited[new_moves.get(i)[0]][])
			}
		}
	}

	public void enqueue(int[] coords) {
		queue.add(coords);
	}
	public int[] dequeue() {
		return queue.remove(0);
	}
}

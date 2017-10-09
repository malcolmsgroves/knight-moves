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

	private ArrayList<KnightMove> move_queue;
	private boolean[][] not_visited;
	private int[] target;
	private KnightMove root;

	// constructor takes a starting position and a target position
	public KnightSearch(int[] start, int[] target) {
		move_queue = new ArrayList<KnightMove>();
		not_visited = new boolean[DIMENSIONS][DIMENSIONS];
		this.target = target;
		this.root = new KnightMove(start);

		// instantiate not_visited board to true
		for(int i = 0; i < DIMENSIONS; ++i) {
			for(int j = 0; j < DIMENSIONS; ++j) {
				not_visited[i][j] = true;
			}
		}

		enqueue(root);
		not_visited[start[0]][start[1]] = false;
	}

	/*
     Perform a breadth-first search (BFS) through the graph
     of all possible positions for the knight in order to find
     the shortest path to the target position. Check if the position
     has already been visited and if it is in bounds
	 */
	public ArrayList<KnightMove> knight_BFS() {



		while(true) {
			KnightMove move = dequeue();
			
			//System.out.println(move.to_string());
			
			ArrayList<KnightMove> new_moves = move.get_children();
			
			for(int i = 0; i < new_moves.size(); ++i) {

				KnightMove potential_move = new_moves.get(i);
				
				//System.out.println("PotMove: " + potential_move.to_string());
				// if the move is on board and unvisited
				if(is_valid(potential_move)) {

					// check if we have reached the target
					if(target[0] == potential_move.get_coords()[0] && 
							target[1] == potential_move.get_coords()[1]) {
						return potential_move.shortest_path();
					}
					
					// add move to queue and mark as visited
					enqueue(new_moves.get(i));
					not_visited[potential_move.get_coords()[0]][potential_move.get_coords()[1]] = false;
				}

			}
		}
	}

	// check if the move is in bounds and has not been done yet
	private boolean is_valid(KnightMove move) {
		int[] coords = move.get_coords();
		boolean in_bounds = coords[0] >= 0 && coords[1] >= 0 &&
				coords[0] < DIMENSIONS && coords[1] < DIMENSIONS;
		return in_bounds && not_visited[coords[0]][coords[1]];
	}


	private void enqueue(KnightMove move) {
		move_queue.add(move);
	}
	private KnightMove dequeue() {
		return move_queue.remove(0);
	}
}

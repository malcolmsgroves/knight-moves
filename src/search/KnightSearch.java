package search;

import java.util.ArrayList;

/*
 	KnightSearch implements a breadth-first search algorithm
 	to find the shortest path for a chess knight between two
 	coordinates on a chess board size DIMENSIONS x DIMENSIONS.

 	The graph was implemented with OOP and the class has-a
 	KnightMove instance root node. Moves are stored in a queue
 	and dequeued when the algorithm moves to the next level
 	in the graph.
 */
public class KnightSearch {

	private static final int DIMENSIONS = 10;

	private ArrayList<KnightMove> move_queue;
	private boolean[][] not_visited;
	private int[] target;
	private KnightMove root;


	/* Constructor
	 * 		Takes a start and an end position for the
	 * search. Sets the root of the KnightMove instance
	 * and instantiates the not_visited array.
	 */
	public KnightSearch(int[] start, int[] target) throws Exception {
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


		if(!is_valid(root) || !is_valid(new KnightMove(target))) {
			throw new Exception("Error: Index out of bounds");
		}



		// visit the root node
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

			// take a move off the queue and use it to generate
			// new moves
			KnightMove move = dequeue();
			ArrayList<KnightMove> new_moves = move.get_children();

			for(int i = 0; i < new_moves.size(); ++i) {

				KnightMove potential_move = new_moves.get(i);

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

	// add a move to the end of the queue
	private void enqueue(KnightMove move) {
		move_queue.add(move);
	}

	// remove a move from the front of the queue and return it
	private KnightMove dequeue() {
		return move_queue.remove(0);
	}
}

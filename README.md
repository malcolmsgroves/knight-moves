# Knight Moves
Given an initial position and a final position, find the shortest path a knight can take to move between the two. The positions exist on a 10 x 10 chess board.

## Running
Download the project from github and cd into the directory.
To build the project, open terminal and enter the following into the command line:
```
ant compile
ant jar
```
To run the program, enter
```
ant run
```
You will be prompted to enter start and end coordinates.

Finally, to clean the directory, enter
```
ant clean
```

## Search
This program performs a breadth-first search for the shortest path. The graph is created using OOP with nodes that point to a parent and children nodes. During breadth-first search, the root node is the starting position. Moves are queued when created and dequeued when the children are created. Additionally, previously visited positions are avoided in future moves by indexing into a 2D array.

## Improvements
In order to improve scalability, the graph could be implemented with a hash table that holds adjacency lists.

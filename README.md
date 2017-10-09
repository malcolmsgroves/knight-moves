# Knight Moves
Given an initial position and a final position, find the shortest path a knight can take to move between the two. The positions exist on a 10 x 10 chess board

## Running
Download, compile, etc. 

## Search
This program performs a breadth-first search for the shortest path. Moves are queued when created and dequeued when the knight moves from the position. Additionally, previously visited positions are avoided in future moves.
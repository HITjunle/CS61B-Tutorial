package lab11.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        // Add more variables here!
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        marked[s] = true;
        while (!queue.isEmpty()){
            int r = queue.remove();
            for (int w : maze.adj(r)){
                if (w == t){
                    marked[w] = true;
                    edgeTo[w] = r;
                    distTo[w] = distTo[r]+1;
                    announce();
                    return;
                }
                if (!marked[w]){
                    queue.add(w);
                    marked[w] = true;
                    edgeTo[w] = r;
                    distTo[w] = distTo[r]+1;
                    announce();
                }
            }
        }

    }


    @Override
    public void solve() {
         bfs();
    }
}


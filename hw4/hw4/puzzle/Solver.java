package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;

/**
 * Created by junle
 */
public class Solver {
    private Stack<WorldState> worldStates = new Stack<>();
    private MinPQ<SearchNode> pq = new MinPQ<>();
    public Solver(WorldState initial){
        SearchNode s = new SearchNode(initial,0,null);
        pq.insert(s);
        while (!pq.isEmpty()){
            SearchNode searchNode = pq.delMin();
            if (searchNode.state.isGoal()){
                worldStates.push(searchNode.state);
                while (searchNode.pNode!=null){
                    searchNode = searchNode.pNode;
                    worldStates.push(searchNode.state);
                }
                return;
            }
            for (WorldState w : searchNode.state.neighbors()){
                if (searchNode.pNode == null ||!w.equals(searchNode.pNode.state) ){
                    SearchNode r = new SearchNode(w,searchNode.moves+1,searchNode);
                    pq.insert(r);
                }

            }
        }
    }

    private class SearchNode implements Comparable<SearchNode>{
        private WorldState state;
        private int moves;
        private SearchNode pNode;
        private int priority;
        SearchNode(WorldState initial, int move, SearchNode Node) {
            state = initial;
            moves = move;
            pNode = Node;
            priority = state.estimatedDistanceToGoal() + move;
        }

        @Override
        public int compareTo(SearchNode o) {
            return this.priority-o.priority;
        }
    }

    public Iterable<WorldState> solution(){
        return worldStates;
    }
    public int moves(){
        return worldStates.size()-1;
    }
}

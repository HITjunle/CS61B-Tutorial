package hw4.puzzle;
import edu.princeton.cs.algs4.Queue;
public class Board implements WorldState{
    private int size;
    private final int BLANK = 0;
    private int [][] tile;
    public Board(int[][] tiles){
        size = tiles.length;
        tile =new int[size][size];
        for (int i = 0 ;i<size;i++){
            for (int j = 0;j<size;j++){
                tile[i][j] = tiles[i][j];
            }
        }
    }
    public int tileAt(int i, int j){
        if (i>=0 && i<tile.length && j>=0 && j<tile[i].length)
            return tile[i][j];
        throw new IndexOutOfBoundsException("the given data is out of the bound");
    }
    public int size(){
        return size;
    }
    public Iterable<WorldState> neighbors(){
        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == BLANK) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = BLANK;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = BLANK;
                }
            }
        }
        return neighbors;
    }
    public int hamming(){
        int res = 0;
        for (int i = 0;i<size;i++){
            for (int j = 0;j<size;j++){
                if (tile[i][j] != i*size+j+1 && tile[i][j] != BLANK)
                    res = res+1;
            }
        }
        return res;
    }

    public int manhattan(){
        int res = 0;
        for (int i = 0; i<size;i++){
            for (int j = 0; j<size;j++){
                if (tile[i][j] != BLANK){
                    res = res + Math.abs(toX(tile[i][j])-i)+Math.abs(toY(tile[i][j])-j);
                }
            }
        }
        return res;
    }
    private int toX(int tile){
        return (tile-1)/size;
    }
    private int toY(int tile){
        return (tile-1)%size;
    }
    public int estimatedDistanceToGoal(){
        return manhattan();
    }
    public boolean equals(Object y){
        if (y.getClass() != this.getClass())
            return false;
        if (((Board) y).size != size && ((Board) y).tile[0].length != size)
            return false;
        for (int i = 0; i < size; i++){
            for (int j= 0; j<size;j++){
                if (this.tile[i][j] != ((Board) y).tile[i][j])
                    return false;
            }
        }
        return true;
    }
    /** Returns the string representation of the board.
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}

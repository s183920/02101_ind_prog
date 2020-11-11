import javax.print.DocFlavor;
import java.awt.*;
import java.util.Random;

public class GameOfLife {
//    private int size;
    private int[][] state;
    private int n;


//    Constructor
    public GameOfLife(int n){
        int[][] state = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                Random rand = new Random();
                state[i][j] = rand.nextInt(2);
            }
        }
        this.state = state;
        this.n = n;
    }

    public GameOfLife(int[][] initialState){
        // Check all inputs are 0 or 1
        this.n = initialState.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (initialState[i][j] != 0 && initialState[i][j] != 1){throw new IllegalArgumentException("State had an illegal value, must be 0 or 1!");}
            }
        }
        this.state = initialState;
    }

    // set state method, sets the state of given cell to newState
    public void setState(int x, int y, int newState){
        if (newState != 0 && newState != 1){throw new IllegalArgumentException("State had an illegal value, must be 0 or 1!");}
        if (x >= n || y >= n){throw new IllegalArgumentException("State " + x + ", " + y + "out of bounds for grid of size " + n + "x" + n);}
        this.state[x][y] = newState;
    }

    //    toString method
    public String toString(){
        String printVal = "";
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n-1; j++){
                printVal += this.state[i][j] + " ";
            }
            printVal += this.state[i][n-1] + "\n";
        }
        return printVal;
    }

    // get number of alive neighbors
    private int liveNeighbors(int x, int y){
        int sum = 0;
        for (int i = x-1; i <= x+1; i++){
            for (int j = y-1; j <= y+1; j++){
                // check that value is within boundaries as values outside ofgrid does not count towards live neighbors
                if ((i != x || j != y) && i >= 0 && j >= 0 && i < n && j < n){
                    sum += state[i][j];
                }
            }
        }
        return sum;
    }

    // Method to overwrite state with next state given by the rules of the game
    public void nextState(){
        // get number of neighbors before overwriting state values
        int[][] neighbors = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                neighbors[i][j] = liveNeighbors(i, j);
            }
        }

        // change states due to rules of the game
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (state[i][j] == 1 && (neighbors[i][j] < 2 || neighbors[i][j] > 3)){
                    setState(i, j, 0);
                } else if (state[i][j] == 0 && neighbors[i][j] == 3){
                    setState(i, j, 1);
                }
            }
        }
    }

    public void drawState(){
//        StdDraw.setCanvasSize(1000,1000);
        double rad = 1./(n*2+1);
        StdDraw.setPenRadius(rad);
        StdDraw.setPenColor(Color.PINK);
        StdDraw.setXscale(-1, n);
        StdDraw.setYscale(-1, n);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (state[i][j] == 1){StdDraw.point((double)(j), (double)(n-1-i));}
            }
        }
    }

    // function to simulate n steps forward, with sleepTime time between each step
    public void drawSimulation(int steps, int sleepTime){
        StdDraw.setCanvasSize(500, 500);
        drawState();
        StdDraw.show(sleepTime);
        for (int i = 0; i < steps; i++){
            nextState();
            StdDraw.clear();
            drawState();
            StdDraw.show(sleepTime);
        }
        StdDraw.show();
    }
}

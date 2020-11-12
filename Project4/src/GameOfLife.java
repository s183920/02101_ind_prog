import javax.print.DocFlavor;
import java.awt.*;
import java.io.*;
import java.util.*;

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

    public GameOfLife(String fileName) {
        int[][] state = readState(fileName);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (state[i][j] != 0 && state[i][j] != 1){throw new IllegalArgumentException("State had an illegal value, must be 0 or 1!");}
            }
        }
        if (state == null){throw new IllegalArgumentException("File was empty");}
        this.state = state;
        this.n = state.length;
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
    public void drawSimulation(int sleepTime){
        StdDraw.setCanvasSize(500, 500);
        drawState();
        StdDraw.show(sleepTime);
        while(true){
            int[][] prevState = state.clone(); // copy previous state before overwriting with next state
            nextState();
            StdDraw.clear();
            drawState();
            StdDraw.show(sleepTime);
            // break loop when board does not change
            if (prevState == this.state){
                break;
            }
        }
//        StdDraw.clear();
//        StdDraw.show();
    }

    public int[][] readState(String fileName){
        int[][] state;
        try {
            File f = new File(fileName);
            Scanner fScanner = new Scanner(f);


            if (fScanner.hasNextLine()){
                // get first row of matrix, to determine n and init state matrix
                String[] row1 = fScanner.nextLine().split(" ");
                state = new int[row1.length][row1.length];
                for (int i = 0; i < row1.length; i++){
                    state[0][i] = Integer.parseInt(row1[i]);
                }
                // read final n-1 lines
                int rowIdx = 1;
                while (fScanner.hasNextLine()) {
                    String[] row = fScanner.nextLine().split(" ");
                    for (int i = 0; i < row.length; i++){
                        state[rowIdx][i] = Integer.parseInt(row[i]);
                    }
                    rowIdx++;
                }
                fScanner.close();
                return state;
            }
            // return null array if file did not have any lines
            return null;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}

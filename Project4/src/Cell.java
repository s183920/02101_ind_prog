import java.util.*;

public class Cell {
    private int[][] state;
    private int[] neighbors;

    //    Constructors
//    Random init
    public Cell(){
        int[][] state = new int[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                Random rand = new Random();
                state[i][j] = rand.nextInt(2);
            }
        }
        setState(state);
    }
//    Init given state
    public Cell(int[][] state){
        setState(state);
    }

//    toString method
    public String toString(){
        String printVal = "";
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 2; j++){
                printVal += this.state[i][j] + " ";
            }
            printVal += this.state[i][2] + "\n";
        }
        return printVal;
    }

//    get state of Cell
    public int[][] getState(){
        return state;
    }

//    get value of cell (0 or 1 if dead or alive)
    public int getVal(){
        return this.state[1][1];
    }

//    modify state value
    public void setState(int[][] state){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (state[i][j] != 0 && state[i][j] != 1){throw new IllegalArgumentException("State had an illegal value, must be 0 or 1!");}
            }
        }
        this.state = state;
        updateNeighbors();

    }


//    Get neighbors of cell
    public void updateNeighbors(){
        int[] neighbors = new int[8];
        int idx = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (i != 1 || j != 1){
                    neighbors[idx] = this.state[i][j];
                    idx++;
                }
            }
        }
        this.neighbors = neighbors;
    }

    public int[] getNeighbors(){
        return neighbors;
    }

//    update state of cell due to rules of GOL
    public void updateState(int[] neighbors){
//        System.out.println(Arrays.toString(getNeighbors()));
        int sumNeighbors = 0;
        for (int N : neighbors){sumNeighbors += N;}
        if (getVal() == 1 && (sumNeighbors < 2) || sumNeighbors > 3){
            this.state[1][1] = 0;
        } else if (getVal() == 0 && sumNeighbors == 3){
            this.state[1][1] = 1;
        }
    }
}

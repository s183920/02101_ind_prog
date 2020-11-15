import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class GameOfLifeMain {
    public static void main(String[] args) {
        // check simple example of 3x3 game
//        int[][] state = {{1, 0, 1}, {0, 1, 1}, {0, 1, 0}};
//        GameOfLife gol = new GameOfLife(state);

//        GameOfLife gol = new GameOfLife(5);
//        gol.drawSimulation(1000);
//        int[][] state = readState("gol/toad.gol");
//        for (int i = 0; i < state.length; i++){
//            System.out.println(Arrays.toString(state[i]));
//        }

        GameOfLife gol2 = new GameOfLife("gol/pentadecathlon.gol");
////        System.out.println(gol2);
        gol2.drawSimulation(100);
    }
}



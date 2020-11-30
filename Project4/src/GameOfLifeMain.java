import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class GameOfLifeMain {
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);
        System.out.print("Please enter the number of a test case. If none of the below integers are chosen, a random n x n grid is used, where n is between 3 and 10 \n" +
                "1 : 3x3 board from description \n" +
                "2 : acorn example \n" +
                "3 : glider_gun example \n" +
                "4 : pentadecathlon example \n" +
                "5 : pulsar example \n" +
                "6 : toad example \n" +
                "Choice: ");

        while (choice.hasNextInt()){
            int chosen = choice.nextInt();
            GameOfLife gol;
           if (chosen == 1){
                int[][] state = {{1, 0, 1}, {0, 1, 1}, {0, 1, 0}};
                gol = new GameOfLife(state);
            } else if (chosen == 2){
                gol = new GameOfLife("gol/acorn.gol");
            } else if (chosen == 3){
                gol = new GameOfLife("gol/glider_gun.gol");
            } else if (chosen == 4){
                gol = new GameOfLife("gol/pentadecathlon.gol");
            } else if (chosen == 5){
                gol = new GameOfLife("gol/pulsar.gol");
            } else if (chosen == 6){
                gol = new GameOfLife("gol/toad.gol");
            } else {
                Random rand = new Random();
                int n = rand.nextInt(7)+3;
                gol = new GameOfLife(n);
                System.out.println("A " + n + " x " + n + " grid was used!");
            }
            gol.drawSimulation(100);
        }
    }
}



public class GameOfLifeMain {
    public static void main(String[] args) {
        // check simple example of 3x3 game
//        int[][] state = {{1, 0, 1}, {0, 1, 1}, {0, 1, 0}};
//        GameOfLife gol = new GameOfLife(state);

        GameOfLife gol = new GameOfLife(10);
        gol.drawSimulation(10, 100);


    }
}

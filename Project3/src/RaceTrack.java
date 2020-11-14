import java.util.Scanner;

public class RaceTrack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("size of map:");
         int xlength = input.nextInt();
         int ylength = xlength;
        initiate_map(xlength, ylength);
        StdDraw.point(xlength/2,ylength-2);
        int[] carPosition = {xlength/2, ylength-2};
        int[] speed = {0,0};
        int moves = 0;
        boolean running = true;
        while (running)
        {
            System.out.println("Which direction do you want to go?:");
            int direction = input.nextInt();
            moves += 1;
            moveCar(direction, carPosition, speed);
            running = checkStatus(xlength, ylength, carPosition, moves);
        }
         // System.exit(0);
    }
    public static void initiate_map(int x0, int y0) {
        StdDraw.setXscale(-5, x0+5);
        StdDraw.setYscale(-5, y0+5);
        StdDraw.setPenColor(StdDraw.GRAY);
        int n = x0;
        StdDraw.filledSquare(x0/2,y0/2,x0/2);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                StdDraw.square(i, j, 1);
            }
        }
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.line(x0/2,y0/2,x0/2,y0);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(x0/2,y0/2,x0/4);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.square(x0/2,x0/2,x0/4);
        StdDraw.square(x0/2,y0/2,x0/2);
    }
    public static void moveCar(int direction, int[] carPosition, int[] speed) {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.005);
        if (direction == 1) {
            speed[0] -= 1;
            speed[1] -= 1;
            StdDraw.line(carPosition[0],carPosition[1],carPosition[0] + speed[0],carPosition[1] + speed[1]);
            carPosition[0] += speed[0];
            carPosition[1] += speed[1];
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(carPosition[0],carPosition[1]);
        }
        if (direction == 2) {
            speed[1] -= 1;
            StdDraw.line(carPosition[0],carPosition[1],carPosition[0] + speed[0],carPosition[1] + speed[1]);
            carPosition[0] += speed[0];
            carPosition[1] += speed[1];
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(carPosition[0],carPosition[1]);
        }
        if (direction == 3) {
            speed[0] += 1;
            speed[1] -= 1;
            StdDraw.line(carPosition[0],carPosition[1],carPosition[0] + speed[0],carPosition[1] + speed[1]);
            carPosition[0] += speed[0];
            carPosition[1] += speed[1];
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(carPosition[0],carPosition[1]);
        }
        if (direction == 6) {
            speed[0] += 1;
            StdDraw.line(carPosition[0],carPosition[1],carPosition[0] + speed[0],carPosition[1] + speed[1]);
            carPosition[0] += speed[0];
            carPosition[1] += speed[1];
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(carPosition[0],carPosition[1]);
        }
        if (direction == 9) {
            speed[0] += 1;
            speed[1] += 1;
            StdDraw.line(carPosition[0],carPosition[1],carPosition[0] + speed[0],carPosition[1] + speed[1]);
            carPosition[0] += speed[0];
            carPosition[1] += speed[1];
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(carPosition[0],carPosition[1]);
        }
        if (direction == 8) {
            speed[1] += 1;
            StdDraw.line(carPosition[0],carPosition[1],carPosition[0] + speed[0],carPosition[1] + speed[1]);
            carPosition[0] += speed[0];
            carPosition[1] += speed[1];
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(carPosition[0],carPosition[1]);
        }
        if (direction == 7) {
            speed[0] -= 1;
            speed[1] += 1;
            StdDraw.line(carPosition[0],carPosition[1],carPosition[0] + speed[0],carPosition[1] + speed[1]);
            carPosition[0] += speed[0];
            carPosition[1] += speed[1];
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(carPosition[0],carPosition[1]);
        }
        if (direction == 4) {
            speed[0] -= 1;
            StdDraw.line(carPosition[0],carPosition[1],carPosition[0] + speed[0],carPosition[1] + speed[1]);
            carPosition[0] += speed[0];
            carPosition[1] += speed[1];
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(carPosition[0],carPosition[1]);
        }
    }
    public static boolean checkStatus(int x0, int y0, int[] carPosition, int moves){
        if (carPosition[0] < 0) {
            System.out.println("You crashed in " + moves + " moves!");
            return false;
        }
        if (carPosition[1] < 0) {
            System.out.println("You crashed in " + moves + " moves!");
            return false;
        }
        if (carPosition[0] > x0) {
            System.out.println("You crashed in " + moves + " moves!");
            return false;
        }
        if (carPosition[1] > y0) {
            System.out.println("You crashed in " + moves + " moves!");
            return false;
        }
        if (carPosition[1] < 3*y0/4 && carPosition[1] > y0/4) {
            if (carPosition[0] < 3*x0/4 && carPosition[0] > x0/4) {
                System.out.println("You crashed in " + moves + " moves!");
                return false;
            }
        }
        if (carPosition[0] > x0/2 && y0/2 < carPosition[1] && moves > 5) {
            System.out.println("You won in " + moves + " moves!");
            return false;
        }
        return true;
    }
}
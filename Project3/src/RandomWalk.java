import java.util.*;

public class RandomWalk {
    public static void main(String[] args) {
        simpleWalk(getN());
    }

    public static int getN(){
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of grid (must be a positive integer): ");
        while (!input.hasNextInt()){
            System.out.print("Please enter an integer as size of grid: ");
            input.next();
        }
        n = input.nextInt();
        if (n < 1){
            n = getN();
        }
        return n;
    }

    public static void simpleWalk(int n){
        int x = 0, y = 0, total = 0;
        Random stepGen = new Random();

//        Setup StdDraw window
        StdDraw.setXscale(-n, n);
        StdDraw.setYscale(-n, n);
        StdDraw.setPenRadius(2./1000); //kan man justere størrelsen smart?


        System.out.printf("Position = (%d, %d)\n", x, y);
        while (Math.abs(x) != n+1 && Math.abs(y) != n+1){
            int step = stepGen.nextInt(4);
            if (step == 0){y++;}
            if (step == 1){y--;}
            if (step == 2){x++;}
            if (step == 3){x--;}
            total ++;
            System.out.printf("Position = (%d, %d)\n", x, y);
            StdDraw.point((double)x, (double)y);
        }
        System.out.println("Total number of steps = " + total);
    }

}

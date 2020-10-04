import java.util.*;

public class BuffonsNeedle {
    public static void main(String[] args) {
        // define variables
        long iter, succes = 0;
        Random distance = new Random(), angle = new Random();
        float d, a;

        // get number of iterations and make sure it is a positive integer
        Scanner console = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        if (console.hasNextLong()) {
            iter = console.nextLong();
            if (iter <= 0){
                throw new IllegalArgumentException("Number of iterations must be a positive integer");
            }
        } else {
            throw new IllegalArgumentException("Only integers can be used for number of iterations.");
        }

        // calculate pi
        for (int i = 0; i < iter; i++){
            d = distance.nextFloat()*2;
            a = angle.nextInt(181);
            if (d+Math.sin(Math.toRadians(a)) >= 2){
                succes += 1;
            }
        }
        System.out.printf("%d / %d = %f", iter, succes, (float)iter/succes);
    }
}


import java.util.Scanner;

public class Mandelbrot {
    private static final int MAX = 20;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Reeldeal:");
        if (input.hasNextInt()) {
           int re = input.nextInt();
        }
        System.out.println("Enter Imaginærdeal");
        if (input.hasNextInt()) {
            int im = input.nextInt();
        }
        System.out.println("Enter sidelength");
        if (input.hasNextInt()) {
            int sdl = input.nextInt();
        }
        
    }
    public static int iterate(Complex z0) {
        Complex z = new Complex(z0);
        for (int i = 0; i < MAX; i++) {
            if (z.abs() > 2.0) {
                return i;
            }
            z = z.times(z).plus(z0);
        }
        return MAX;
    }
}

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mandelbrot {
    private static final int MAX = 255;
    private static final int g = 1000;

    public static void main(String[] args) {
        int[][] grid = getGrid(getCenter());
        drawMandelbrot(grid, "blues");
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

    public static Complex getCenter(){
//        Get the center
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double re=0, im=0;
//        read real part
        System.out.print("Enter the real part of the center: ");
        if (input.hasNextDouble()) {
            re = input.nextDouble();
            System.out.print("Enter the imaginary part of the center: ");
        } else {
            throw new IllegalArgumentException("Only double values separated by \".\" or integers can be used, center was set to the default value 0");
        }
//        Read imaginary part
        if (input.hasNextDouble()) {
            im = input.nextDouble();
        } else {
            throw new IllegalArgumentException("Only double values separated by \".\" or integers can be used, center was set to the default value 0");
        }

        Complex center = new Complex(re, im);
        return center;
    }

    public static int[][] getGrid(Complex center){
//        Returns a matrix with the iterate number indicating the field should be colored
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double s = 0;
        System.out.print("Enter the diameter/sidelength: ");

        if (input.hasNextDouble()) {
            s = input.nextDouble();
        }else {
            throw new IllegalArgumentException("Only double values separated by \".\" or integers can be used, center was set to the default value 0");
        }

//        Calculate grid
        int[][] grid = new int[g][g];
        for (int j = 0; j < g; j++){
            for (int k = 0; k < g; k++){
                double re = center.getRe() - s/2 + s*j/(g-1);
                double im = center.getIm() - s/2 + s*k/(g-1);
                grid[j][k] = iterate(new Complex(re, im));
            }
        }
        return grid;
    }

    public static void drawMandelbrot(int[][] grid, String colorScheme){
        double rad = 1./(g*2+1);
        StdDraw.setCanvasSize(g, g);
        StdDraw.setPenRadius(rad);
        StdDraw.setXscale(-1, g);
        StdDraw.setYscale(-1, g);
        Color[] palette = getColorPalette("mnd/" + colorScheme + ".mnd");

        StdDraw.show(0);
        for (int i = 0; i < g; i++){
            for (int j = 0; j < g; j++){
                StdDraw.setPenColor(getColor(palette,grid[i][j]));
                StdDraw.point((double)(i), (double)(j));
            }
        }
        StdDraw.show(0);
    }

    public static Color getColor(int value){
//        Returns a random color given the an integer value, usually the value of iterate
        Random rand = new Random();
        rand.setSeed(value);
        return new Color(rand.nextInt(MAX+1), rand.nextInt(MAX+1), rand.nextInt(MAX+1));
    }

    public static Color[] getColorPalette(String fileName){
//        Returns an array opf the colors in the given file
        int color[][] = new int[MAX+1][3];
        Color[] palette = new Color[MAX+1];
        try {
            File f = new File(fileName);
            Scanner fScanner = new Scanner(f);

            int rowIdx = 0;
            int endWhile = 0;
            while (fScanner.hasNextLine()) {
                for (int i = 0; i < 3; i++){
                    if (fScanner.hasNextInt()){
                        color[rowIdx][i] = fScanner.nextInt();
                    } else {
                        endWhile = 1;
                    }
                }
                if (endWhile == 1){break;}
                palette[rowIdx] = new Color(color[rowIdx][0], color[rowIdx][1], color[rowIdx][2]);
                rowIdx++;
            }
            fScanner.close();
            return palette;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    public static Color getColor(Color[] palette, int value){
//        returns the color specified in the color palette
        return palette[value];
    }
}

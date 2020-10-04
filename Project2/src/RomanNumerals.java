import java.util.Scanner;

public class RomanNumerals {
    public static void main(String[] args) {
        String ones = "IXCM ";
        String fives = "VLD ";
        String numeral;
        System.out.print("Enter positive integer to convert: ");
        Scanner numeralConsole = new Scanner(System.in);
        if (numeralConsole.hasNextInt()){
            numeral = numeralConsole.next();
            if(Integer.parseInt(numeral) <= 0){throw new IllegalArgumentException("The input must be a positive integer!");}
        } else {
            throw new IllegalArgumentException("The input must be an integer!");
        }

        int l = numeral.length()-1;
        int thousands = Integer.parseInt(numeral.substring(0, l-2));
        if (thousands > 3){
            for (int i = 0; i < thousands-3; i++){
                System.out.print("M");
            }
            numeral = String.valueOf(Integer.parseInt(numeral)-(thousands-3)*1000);
        }
        for (int i = 0; i <= l; i++){
            sub(""+numeral.charAt(i), ""+ ones.charAt(l-i) + fives.charAt(l-i) + ones.charAt(l-i+1));
        }
    }

    public static void sub(String num, String letters){
//        System.out.println(letters);
        char low = letters.charAt(0), middle = letters.charAt(1), high = letters.charAt(2);
        int N = Integer.parseInt(num);
        if (N <= 3){
            printChar(N, low);
        } else if (N == 4){
            printChar(N-3, low);
            printChar(N-3, middle);
        } else if (N <= 8){
            printChar(1, middle);
            printChar(N-5, low);
        } else {
            printChar(1, low);
            printChar(1, high);
        }
    }

    public static void printChar(int N, char c){
        for (int i = 1; i <= N; i++){
            System.out.print(c);
        }
    }

}

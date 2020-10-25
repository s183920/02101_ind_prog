import java.util.*;

public class PrimeFactors {
    public static void main(String[] args) {
//        Get input value
        long num = getNum();

//        Print prime factors
        while (num != 0){
            printPrime(num);
            num = getNum();
        }
    }

    public static void printPrime(long number){
        System.out.print("List of prime factors: ");
        int count = 1;
        for (long i = 2; i <= number; i++){
            while (number % i == 0){
                if (count == 1){
                    System.out.print(i);
                    count ++;
                } else {
                    System.out.print(", " + i);
                }
                number /= i;
            }
        }
        System.out.println();
    }

    public static long getNum(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integer greater than 1 (0 to terminate): ");
        while (!input.hasNextLong()){
            System.out.print("Input must be an integer greater than 1 (0 to terminate): ");
            input.next();
        }
        long num = input.nextLong();
        if (num <= 1 && num != 0){
            num = getNum();
        }
        return num;
    }
}

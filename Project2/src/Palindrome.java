import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter line to check: ");
        String sentence = input.nextLine();
        Process_palindrome(sentence);
    }
    public static void Process_palindrome(String sentence) { //Ryd vores dug. Ret dog netgardinet. Tak, Egil. Viggo, gid da denne dame så de samer af dem, der red med fare, mase dåsemaden ned ad dig. Og giv lige katten i dragten godter. Gud se, rovdyr!
        String result = sentence.replaceAll("[-+.^:,!]","").toLowerCase();
        final int mid = result.length() / 2; //get the middle of the String
        if (mid == 0) {
            System.out.print("You did not input anything... try again");
        }
        else {
            if (mid % 2 == 0) {
                String[] parts = {result.substring(0, mid), result.substring(mid)};
                String s1 = parts[0].replaceAll("[ ]", "");
                String s2 = parts[1].replaceAll("[ ]", "");
                String s3 = new StringBuilder(s2).reverse().toString();
                Check_palindrome(sentence, s1, s3);
            } else {
                String[] parts = {result.substring(0, mid + 1), result.substring(mid)};
                String s1 = parts[0].replaceAll("[ ]", "");
                String s2 = parts[1].replaceAll("[ ]", "");
                String s3 = new StringBuilder(s2).reverse().toString();
                Check_palindrome(sentence, s1, s3);
            }
        }
    }
    public static void Check_palindrome(String sentence, String s1, String s2) {
        if (s1.equals(s2)) {
            System.out.print("\"" + sentence + "\" is a palindrome!");
        } else {
            System.out.print("\"" + sentence + "\" is not a palindrome...");
        }
    }
}

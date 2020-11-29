import java.util.*;
public class Main_s183920 {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(40);
        a.add(41);
        a.add(42);
//        System.out.println("Before first myst call: " + a);
        myst(a);
    }
    public static void myst(List<Integer> a) {
        if (a.size() > 0) {
            System.out.println(a.remove(0));
//            System.out.println("Before recursive: " + a);
            myst(a);
        }
    }
}

//s183920
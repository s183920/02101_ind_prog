import java.util.*;
public class Mains180820 {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(40);
        a.add(41);
        a.add(42);
        // a = [40, 41, 42]
        myst(a);
    }
    public static void myst(List<Integer> a) {
        if (a.size() > 0) {
            System.out.println(a.remove(a.size() - 1));
            myst(a);
        }
    }
}

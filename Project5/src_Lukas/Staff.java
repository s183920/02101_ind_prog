public class Staff {
    public static void main(String[] args) {
        Person a = new Person("adam");
        Boss b = new Boss("bill");
        Programmer c = new Programmer("carl");
        JavaProgrammer d = new JavaProgrammer("dean", "Hello World");
        JavaProgrammer e = new JavaProgrammer("eric", "Test program 1");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
//s183920
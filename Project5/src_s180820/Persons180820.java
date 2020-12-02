public class Persons180820 {
    private String name;

    public Persons180820(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.getClass().getName().replace("s180820", " ") + name;
    }
}

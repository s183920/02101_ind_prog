public class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String toString(){
        return this.getClass().getName() + " " + name;
    }
}
//s183920
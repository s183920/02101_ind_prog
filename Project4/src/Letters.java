public class Letters {
    public static void main(String[] args){
        String compiled = "";
        for (String s : args) { //makes all the inputs into a collected string
            compiled += s;
        }
        String outputString = compiled.replaceAll(" ", ""); //replaces all spaces
        System.out.println(outputString.length()); // prints out length of the string
    }
}


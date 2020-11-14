public class Letters {
    public static void main(String[] args){
        String compiled = "";
        for (String s : args) {
            compiled += s;
        }
        String outputString = compiled.replaceAll(" ", "");
        System.out.println(outputString.length());
    }
}


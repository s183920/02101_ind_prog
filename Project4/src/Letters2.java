public class Letters2 {
    public static void main(String[] args) {
        for (String s : args) {
            if (s.contains("()")) {
                s.replace("/","l");
            }
        }

        int count = 0;
        String compiled = "";
        for (String s : args) {
            compiled += s;
        }
        //String outputString = compiled.replaceAll("[^a-zA-Z]", "");
        System.out.println(compiled);
    }
}
public class ArtikelTest {
    public static void main(String[] args) {
        Forlag f = new Forlag("University Press", "Denmark");
        Tidsskrift t1 = new Tidsskrift("Journal of logic", "", f);
        Tidsskrift t2 = new Tidsskrift("Brain", "", f);
        Artikel a = new Artikel(new String[]{"A. Abe", "A. Turing"}, "A", t1);
        Artikel b = new Artikel(new String[]{"B. Bim"}, "B", t1);
        a.setReferenceliste("B");
        b.setReferenceliste("Boogalo");
        System.out.println(f.toString());
        printTidsskrift(t1,t2,f);
        printArtikler(a, b);
        printRef(a, b);
    }
    public static void printTidsskrift(Tidsskrift t1, Tidsskrift t2, Forlag f) {
        System.out.println("Tidskrifterne " + t1.getTitle() + " og " + t2.getTitle() + ". Disse to tidskrifter " +
                "kommer begge fra " + f.getNavn() + ". " + t1.getIssn() + t2.getIssn());
    }
    public static void printArtikler(Artikel a, Artikel b) {
        System.out.println("Følgende to artikler:");
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
    public static void printRef(Artikel a, Artikel b) {
        if (a.getRef().equals(b.getTitel())) {
            System.out.println("Den første af disse artikler har en refrence til den anden.");
        }
        if (b.getRef().equals(a.getTitel())) {
            System.out.println("Den anden af disse artikler har en refrence til den første.");
        }
    }
}

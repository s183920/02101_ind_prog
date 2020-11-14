public class ArtikelTest {
    public static void main(String[] args) {
        Forlag f = new Forlag("University Press", "Denmark");
        Tidsskrift t1 = new Tidsskrift("Journal of logic", "", f);
        Tidsskrift t2 = new Tidsskrift("Brain", "", f);
        Artikel a = new Artikel(new String[]{"A. Abe", "A. Turing"}, "A", t1);
        Artikel b = new Artikel(new String[]{"B. Bim"}, "B", t1);
        System.out.println("Forlaget " + f.getNavn() + f.getSted());
        System.out.println("Tidskrifterne " + t1.getTitle() + " og " + t2.getTitle() + ". Disse to tidskrifter " +
                "kommer begge fra " + f.getNavn() + ". ISSN-numrene kendes ikke.");
        System.out.println("Følgende to artikler:");
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}

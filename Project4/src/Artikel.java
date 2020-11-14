public class Artikel {
    private String[] forfattere;
    private String titel;
    private Tidsskrift t;
    private String ref;

    public Artikel(String[] forfattere, String titel, Tidsskrift t){
        this.forfattere = forfattere;
        this.titel = titel;
        this.t = t;
        this.ref = ref;
    }

    public void newArtikel(String[] newForfattere, String newTitel) {
        this.forfattere = newForfattere;
        this.titel = newTitel;
    }
    public void setReferenceliste(String newRef) {
        ref = newRef;
    }
    public String getForfattere(){
        String result = "- " + forfattere[0];
        if (forfattere.length == 1) {
            result = result;
        }
        else{
            for (int i=1; i < forfattere.length; i++){
                result += " & " + forfattere[i];
            }
        }
        return result + ":";
    }
    public String toString(){
        return getForfattere() + " \"" + this.titel + "\". " + this.t.getTitle();
    }
}
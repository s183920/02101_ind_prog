public class Artikel {
    private String[] forfattere;
    private String titel;
    private Tidsskrift t;
    private String ref;

    // Constructor
    public Artikel(String[] forfattere, String titel, Tidsskrift t){
        this.forfattere = forfattere;
        this.titel = titel;
        this.t = t;
        this.ref = ref;
    }
    // funktion til at opdatere Refrence
    public void setReferenceliste(String newRef) {
        ref = newRef;
    } // Konstrukør til at sætte refrenceliste
    public String getTitel() {return this.titel;} //toString metode til at få titlen
    public String getForfattere(){ //toString metode til at få forfatteren(e)
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
    // toString metoder
    public String toString(){
        return getForfattere() + " \"" + this.titel + "\". " + this.t.getTitle();
    }
    public String getRef(){return this.ref;}
}
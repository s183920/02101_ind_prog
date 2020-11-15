public class Forlag {
    private String navn;
    private String sted;

    // Constructor
    public Forlag(String navn, String sted){
        this.navn = navn;
        this.sted = sted;
    }
    // toString methods
    public String getNavn(){
        return navn;
    }
    public String getSted(){
        return sted;
    }
    public String toString() {return "Forlaget " + navn + ", " + sted + ".";}
}

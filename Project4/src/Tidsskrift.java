public class Tidsskrift {
    private String title;
    private String issn;
    private Forlag f;

    public Tidsskrift(String title, String issn, Forlag f) {
        this.title = title;
        this.issn = issn;
        this.f = f;
    }

    public void setIssn(String newissn){
        this.issn = newissn;
    }
    public void setForlag(String newNavn, String newSted){
        this.f = new Forlag(newNavn, newSted);
    }
    public String getTitle(){
        return title;
    }
}


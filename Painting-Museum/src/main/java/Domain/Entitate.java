package Domain;

public class Entitate extends Entity<Long> {

    private Long id;
    private String titlu;
    private String pictor;
    private String tematica;
    private Double celebritate;

    public Entitate(Long id, String titlu, String pictor, String tematica, Double celebritate) {
        this.id = id;
        this.titlu = titlu;
        this.pictor = pictor;
        this.tematica = tematica;
        this.celebritate = celebritate;
    }

    public Entitate(String titlu, String pictor, String tematica, Double celebritate) {
    this.titlu = titlu;
    this.pictor = pictor;
    this.tematica = tematica;
    this.celebritate = celebritate;

    }
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getPictor() {
        return pictor;
    }

    public void setPictor(String pictor) {
        this.pictor = pictor;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public Double getCelebritate() {
        return celebritate;
    }

    public void setCelebritate(Double celebritate) {
        this.celebritate = celebritate;
    }

    @Override
    public String toString() {
        return "Tablou{" +
                "id=" + id +
                ",titlu='" + titlu + '\'' +
                ",pictor='" + pictor + '\'' +
                ",tematica='" + tematica + '\'' +
                ",celebritate=" + celebritate +
                '}';
    }

    public String pctA(){
        return "Tablou{" +
                "id=" + id +
                ",pictor='" + pictor + '\'' +
                ",titlu='" + titlu + '\'' +

                '}';
    }

    public String pctB() {
        return "Tablou{" +
                "titlu='" + titlu + '\'' +
                ",pictor='" + pictor + '\'' +
                ",tematica='" + tematica + '\'' +

                '}';
    }

    public String pctC() {
        return "Tablou{" +
                "id=" + id +
                ",celebritate=" + celebritate +
                '}';
    }
}

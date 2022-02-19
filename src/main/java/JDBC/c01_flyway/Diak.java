package JDBC.c01_flyway;

public class Diak {
    private int id;
    private String name;
    private String szulIdo;
    private String taj;

    public Diak(int id, String name, String szulIdo, String taj) {
        this.id = id;
        this.name = name;
        this.szulIdo = szulIdo;
        this.taj = taj;
    }

    public Diak() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSzulIdo() {
        return szulIdo;
    }

    public void setSzulIdo(String szulIdo) {
        this.szulIdo = szulIdo;
    }

    public String getTaj() {
        return taj;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    @Override
    public String toString() {
        return "Diak{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", szulIdo='" + szulIdo + '\'' +
                ", taj='" + taj + '\'' +
                '}';
    }
}

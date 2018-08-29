package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;


@NamedQuery(name=Adresse.GET , query = "SELECT a " +
                    "FROM Adresse a WHERE a.strasse = ?1 AND " +
                    "a.plz = ?2 ")
@Entity
public class Adresse {
    private int adrId;
    private String plz;
    private String strasse;
    private Ort ortById;

    public static final  String GET = "Adresse.get";

    public Adresse() {
    }

    public Adresse(int adrId, String plz, String strasse) {
        this.adrId = adrId;
        this.plz = plz;
        this.strasse = strasse;
    }

    @Id
    @Column(name = "Adr_ID", nullable = false)
    public int getAdrId() {
        return adrId;
    }

    public void setAdrId(int adrId) {
        this.adrId = adrId;
    }

    @Basic
    @Column(name = "PLZ", nullable = true, length = 10)
    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    @Basic
    @Column(name = "Strasse", nullable = true, length = 100)
    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return adrId == adresse.adrId &&
                Objects.equals(plz, adresse.plz) &&
                Objects.equals(strasse, adresse.strasse);
    }

    @ManyToOne
    @JoinColumn(name = "O_ID", referencedColumnName = "O_ID", nullable = false)
    public Ort getOrtById() {
        return ortById;
    }

    public void setOrtById(Ort ortById) {
        this.ortById = ortById;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adrId, plz, strasse);
    }
}

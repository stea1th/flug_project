package flug.project.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Adresse {
    private int adrId;
    private String plz;
    private String strasse;

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

    @Override
    public int hashCode() {
        return Objects.hash(adrId, plz, strasse);
    }
}

package flug.project.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Anrede {
    private int aId;
    private String bezeichnung;

    @Id
    @Column(name = "A_ID", nullable = false)
    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    @Basic
    @Column(name = "Bezeichnung", nullable = false, length = 40)
    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anrede anrede = (Anrede) o;
        return aId == anrede.aId &&
                Objects.equals(bezeichnung, anrede.bezeichnung);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aId, bezeichnung);
    }
}

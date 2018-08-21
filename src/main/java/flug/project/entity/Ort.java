package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name= Ort.GET_ALL, query = "SELECT o FROM Ort o ")
})

@Entity
public class Ort {
    private int oId;
    private String bezeichnung;
    private Land landByLId;

    public static final String GET_ALL = "Ort.getAll";

    public Ort() {
    }

    public Ort(int oId, String bezeichnung) {
        this.oId = oId;
        this.bezeichnung = bezeichnung;
    }

    @Id
    @Column(name = "O_ID", nullable = false)
    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    @Basic
    @Column(name = "Bezeichnung", nullable = false, length = 100)
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
        Ort ort = (Ort) o;
        return oId == ort.oId &&
                Objects.equals(bezeichnung, ort.bezeichnung);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oId, bezeichnung);
    }

    @ManyToOne
    @JoinColumn(name = "L_ID", referencedColumnName = "L_ID", nullable = false)
    public Land getLandByLId() {
        return landByLId;
    }

    public void setLandByLId(Land landByLId) {
        this.landByLId = landByLId;
    }
}

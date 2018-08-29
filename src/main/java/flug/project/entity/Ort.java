package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ort {
    private String oId;
    private Land landByLId;

    public Ort() {
    }

    public Ort(String oId) {
        this.oId = oId;
    }

    @Id
    @Column(name = "O_ID", nullable = false)
    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ort)) return false;
        Ort ort = (Ort) o;
        return Objects.equals(oId, ort.oId) &&
                Objects.equals(landByLId, ort.landByLId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(oId, landByLId);
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

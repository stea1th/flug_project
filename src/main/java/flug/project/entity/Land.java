package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;
@NamedQueries({
        @NamedQuery(name= Land.GET, query = "SELECT l FROM Land l WHERE l.bezeichnung = ?1 ")
})
@Entity
public class Land {
    private int lId;
    private String bezeichnung;

    public static final String GET = "Land.get";

    public Land() {
    }

    public Land(int lId, String bezeichnung) {
        this.lId = lId;
        this.bezeichnung = bezeichnung;
    }

    @Id
    @Column(name = "L_ID", nullable = false)
    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
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
        Land land = (Land) o;
        return Objects.equals(bezeichnung, land.bezeichnung);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lId, bezeichnung);
    }
}

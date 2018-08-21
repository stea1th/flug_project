package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;
@NamedQueries({
        @NamedQuery(name= Land.GET_ALL, query = "SELECT l FROM Land l ")
})
@Entity
public class Land {
    private int lId;
    private String bezeichnung;

    public static final String GET_ALL = "Land.getAll";

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
        return lId == land.lId &&
                Objects.equals(bezeichnung, land.bezeichnung);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lId, bezeichnung);
    }
}

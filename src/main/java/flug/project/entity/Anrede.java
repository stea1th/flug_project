package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;

@NamedQuery(name=Anrede.GET, query = "SELECT an FROM Anrede an WHERE an.bezeichnung = ?1 ")
@Entity
public class Anrede {
    private int aId;
    private String bezeichnung;

    public Anrede() {
    }

    public Anrede(int aId, String bezeichnung) {
        this.aId = aId;
        this.bezeichnung = bezeichnung;
    }

    public static final String GET = "Anrede.get";

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

package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;

@NamedQuery(name= Fluggesellschaft.GET_ALL, query = "SELECT flg.fgId FROM Fluggesellschaft flg ")
@Entity
public class Fluggesellschaft {
    private String fgId;
    private String name;

    public static final String GET_ALL = "Fluggeselschaft.getAll";

    public Fluggesellschaft() {
    }

    public Fluggesellschaft(String fgId, String name) {
        this.fgId = fgId;
        this.name = name;
    }

    @Id
    @Column(name = "FG_ID", nullable = false, length = 2)
    public String getFgId() {
        return fgId;
    }

    public void setFgId(String fgId) {
        this.fgId = fgId;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fluggesellschaft that = (Fluggesellschaft) o;
        return Objects.equals(fgId, that.fgId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fgId, name);
    }
}

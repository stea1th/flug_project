package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Anrede {
    private String aId;

    public Anrede() {
    }

    public Anrede(String aId) {
        this.aId = aId;
    }

    @Id
    @Column(name = "A_ID", nullable = false)
    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anrede)) return false;
        Anrede anrede = (Anrede) o;
        return Objects.equals(aId, anrede.aId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aId);
    }
}

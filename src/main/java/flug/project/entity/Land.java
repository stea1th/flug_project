package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Land {
    private String lId;

    public Land() {
    }

    public Land(String lId) {
        this.lId = lId;
    }

    @Id
    @Column(name = "L_ID", nullable = false)
    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Land)) return false;
        Land land = (Land) o;
        return Objects.equals(lId, land.lId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lId);
    }
}

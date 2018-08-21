package flug.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Flughafen {
    private String fhId;

    @Id
    @Column(name = "FH_ID", nullable = false, length = 3)
    public String getFhId() {
        return fhId;
    }

    public void setFhId(String fhId) {
        this.fhId = fhId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flughafen flughafen = (Flughafen) o;
        return Objects.equals(fhId, flughafen.fhId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fhId);
    }
}

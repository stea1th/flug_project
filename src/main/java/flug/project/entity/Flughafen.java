package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;

@NamedQuery(name = Flughafen.GET_ALL_IDS, query = "SELECT f.fhId FROM Flughafen f ")
@Entity
public class Flughafen {
    private String fhId;
    private Ort ortById;

    public static final String GET_ALL_IDS = "Flughafen.getAllIds";

    public Flughafen() {
    }

    public Flughafen(String fhId) {
        this.fhId = fhId;
    }

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

    @ManyToOne
    @JoinColumn(name = "O_ID", referencedColumnName = "O_ID", nullable = false)
    public Ort getOrtById() {
        return ortById;
    }

    public void setOrtById(Ort ortById) {
        this.ortById = ortById;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fhId);
    }
}

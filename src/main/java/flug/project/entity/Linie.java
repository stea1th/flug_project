package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Linie {
    private int liId;
    private Object dauer;
    private Flughafen flughafenByVon;
    private Flughafen flughafenByNach;
    private Fluggesellschaft fluggesellschaftByFgId;

    @Id
    @Column(name = "LI_ID", nullable = false)
    public int getLiId() {
        return liId;
    }

    public void setLiId(int liId) {
        this.liId = liId;
    }

    @Basic
    @Column(name = "Dauer", nullable = false)
    public Object getDauer() {
        return dauer;
    }

    public void setDauer(Object dauer) {
        this.dauer = dauer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linie linie = (Linie) o;
        return liId == linie.liId &&
                Objects.equals(dauer, linie.dauer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liId, dauer);
    }

    @ManyToOne
    @JoinColumn(name = "Von", referencedColumnName = "FH_ID", nullable = false)
    public Flughafen getFlughafenByVon() {
        return flughafenByVon;
    }

    public void setFlughafenByVon(Flughafen flughafenByVon) {
        this.flughafenByVon = flughafenByVon;
    }

    @ManyToOne
    @JoinColumn(name = "Nach", referencedColumnName = "FH_ID", nullable = false)
    public Flughafen getFlughafenByNach() {
        return flughafenByNach;
    }

    public void setFlughafenByNach(Flughafen flughafenByNach) {
        this.flughafenByNach = flughafenByNach;
    }

    @ManyToOne
    @JoinColumn(name = "FG_ID", referencedColumnName = "FG_ID", nullable = false)
    public Fluggesellschaft getFluggesellschaftByFgId() {
        return fluggesellschaftByFgId;
    }

    public void setFluggesellschaftByFgId(Fluggesellschaft fluggesellschaftByFgId) {
        this.fluggesellschaftByFgId = fluggesellschaftByFgId;
    }
}

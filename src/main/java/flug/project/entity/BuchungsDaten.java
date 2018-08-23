package flug.project.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class BuchungsDaten {
    private int nummer;
    private int pId;
    private int flId;
    private Date datum;

    @Id
    @Column(name = "Nummer", nullable = false)
    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Id
    @Column(name = "P_ID", nullable = false)
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Id
    @Column(name = "FL_ID", nullable = false)
    public int getFlId() {
        return flId;
    }

    public void setFlId(int flId) {
        this.flId = flId;
    }

    @Basic
    @Column(name = "Datum", nullable = false)
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuchungsDaten that = (BuchungsDaten) o;
        return nummer == that.nummer &&
                pId == that.pId &&
                flId == that.flId &&
                Objects.equals(datum, that.datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nummer, pId, flId, datum);
    }
}

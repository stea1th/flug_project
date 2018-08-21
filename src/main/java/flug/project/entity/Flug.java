package flug.project.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Flug {
    private int flId;
    private Date datum;
    private BigDecimal preis;

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

    @Basic
    @Column(name = "Preis", nullable = false, precision = 2)
    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flug flug = (Flug) o;
        return flId == flug.flId &&
                Objects.equals(datum, flug.datum) &&
                Objects.equals(preis, flug.preis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flId, datum, preis);
    }
}

package flug.project.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Flug {
    private int flId;
    private LocalDate datum;
    private BigDecimal preis;
    private Linie linie;
    private FlugzeugTyp flugzeugTyp;

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
    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
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

    @ManyToOne
    @JoinColumn(name = "LI_ID", referencedColumnName = "LI_ID", nullable = false)
    public Linie getLinie() {
        return linie;
    }

    public void setLinie(Linie linie) {
        this.linie = linie;
    }

    @ManyToOne
    @JoinColumn(name = "FT_ID", referencedColumnName = "FT_ID", nullable = false)
    public FlugzeugTyp getFlugzeugTyp() {
        return flugzeugTyp;
    }

    public void setFlugzeugTyp(FlugzeugTyp flugzeugTyp) {
        this.flugzeugTyp = flugzeugTyp;
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

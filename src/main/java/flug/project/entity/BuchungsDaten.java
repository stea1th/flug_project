package flug.project.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@NamedQuery(name = BuchungsDaten.GET_ALL, query = "SELECT bd.nummer FROM BuchungsDaten bd ")
public class BuchungsDaten {
    private int bdId;
    private int nummer;
    private LocalDate datum;
    private Passagier passagier;
    private Flug flug;

    public static final String GET_ALL = "BuchungsDaten.getAll";

    public BuchungsDaten() {
    }

    public BuchungsDaten(int bdId, int nummer, LocalDate datum) {
        this.bdId = bdId;
        this.nummer = nummer;
        this.datum = datum;
    }

    @Id
    @Column(name = "BD_ID", nullable = false)
    public int getBdId() {
        return bdId;
    }

    public void setBdId(int bdId) {
        this.bdId = bdId;
    }

    @Column(name = "Nummer", nullable = false)
    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Basic
    @Column(name = "Datum", nullable = false)
    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    @ManyToOne
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    public Passagier getPassagierById() {
        return passagier;
    }

    public void setPassagierById(Passagier passagier) {
        this.passagier = passagier;
    }

    @ManyToOne
    @JoinColumn(name = "FL_ID", referencedColumnName = "FL_ID")
    public Flug getFlugById() {
        return flug;
    }

    public void setFlugById(Flug flug) {
        this.flug = flug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuchungsDaten that = (BuchungsDaten) o;
        return bdId == that.bdId &&
                nummer == that.nummer &&
                Objects.equals(datum, that.datum) &&
                Objects.equals(passagier, that.passagier) &&
                Objects.equals(flug, that.flug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bdId, nummer, datum, passagier, flug);
    }
}

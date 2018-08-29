package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;

@NamedQuery(name =FlugzeugTyp.GET, query="SELECT ft FROM FlugzeugTyp ft " +
        "WHERE ft.typ = ?1 AND ft.kapaz =?2 AND ft.hersteller=?3 ")
@Entity
public class FlugzeugTyp {
    private int ftId;
    private String typ;
    private int kapaz;
    private String hersteller;

    public static final String GET = "FlugzeugTyp.get";

    public FlugzeugTyp() {
    }

    public FlugzeugTyp(int ftId, String typ, int kapaz, String hersteller) {
        this.ftId = ftId;
        this.typ = typ;
        this.kapaz = kapaz;
        this.hersteller = hersteller;
    }

    @Id
    @Column(name = "FT_ID", nullable = false)
    public int getFtId() {
        return ftId;
    }

    public void setFtId(int ftId) {
        this.ftId = ftId;
    }

    @Column(name = "Typ", nullable = false, length = 15)
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }


    @Column(name = "Kapaz", nullable = false)
    public int getKapaz() {
        return kapaz;
    }

    public void setKapaz(int kapaz) {
        this.kapaz = kapaz;
    }

    @Basic
    @Column(name = "Hersteller", nullable = false, length = 50)
    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlugzeugTyp that = (FlugzeugTyp) o;
        return kapaz == that.kapaz &&
                Objects.equals(typ, that.typ) &&
                Objects.equals(hersteller, that.hersteller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typ, kapaz, hersteller);
    }
}

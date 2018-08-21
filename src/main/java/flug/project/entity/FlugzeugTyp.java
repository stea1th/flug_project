package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(FlugzeugTypPK.class)
public class FlugzeugTyp {
    private String typ;
    private int kapaz;
    private String hersteller;

    @Id
    @Column(name = "Typ", nullable = false, length = 15)
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Id
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

package flug.project.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FlugzeugTypPK implements Serializable {
    private String typ;
    private int kapaz;

    @Column(name = "Typ", nullable = false, length = 15)
    @Id
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Column(name = "Kapaz", nullable = false)
    @Id
    public int getKapaz() {
        return kapaz;
    }

    public void setKapaz(int kapaz) {
        this.kapaz = kapaz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlugzeugTypPK that = (FlugzeugTypPK) o;
        return kapaz == that.kapaz &&
                Objects.equals(typ, that.typ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typ, kapaz);
    }
}

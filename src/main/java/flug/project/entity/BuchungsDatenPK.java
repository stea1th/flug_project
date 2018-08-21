package flug.project.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BuchungsDatenPK implements Serializable {
    private int nummer;
    private int pId;
    private int flId;

    @Column(name = "Nummer", nullable = false)
    @Id
    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Column(name = "P_ID", nullable = false)
    @Id
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Column(name = "FL_ID", nullable = false)
    @Id
    public int getFlId() {
        return flId;
    }

    public void setFlId(int flId) {
        this.flId = flId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuchungsDatenPK that = (BuchungsDatenPK) o;
        return nummer == that.nummer &&
                pId == that.pId &&
                flId == that.flId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nummer, pId, flId);
    }
}

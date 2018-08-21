package flug.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Passagier {
    private int pId;
    private String name;
    private Anrede anredeByAId;
    private Adresse adresseByAdrId;

    @Id
    @Column(name = "P_ID", nullable = false)
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passagier passagier = (Passagier) o;
        return pId == passagier.pId &&
                Objects.equals(name, passagier.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pId, name);
    }

    @ManyToOne
    @JoinColumn(name = "A_ID", referencedColumnName = "A_ID")
    public Anrede getAnredeByAId() {
        return anredeByAId;
    }

    public void setAnredeByAId(Anrede anredeByAId) {
        this.anredeByAId = anredeByAId;
    }

    @ManyToOne
    @JoinColumn(name = "Adr_ID", referencedColumnName = "Adr_ID", nullable = false)
    public Adresse getAdresseByAdrId() {
        return adresseByAdrId;
    }

    public void setAdresseByAdrId(Adresse adresseByAdrId) {
        this.adresseByAdrId = adresseByAdrId;
    }
}

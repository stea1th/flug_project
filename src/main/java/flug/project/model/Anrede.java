package flug.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Anrede.ALL_UNSORTED, query = "SELECT a FROM Anrede a ")
})
@Entity
@Table
public class Anrede {

    public static final String ALL_UNSORTED = "Anrede.getAll";

    @Id
    @Column(name = "A_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Bez")
    @NotBlank
    private String bezeichnung;

    @OneToMany(mappedBy = "anrede", fetch = FetchType.EAGER)
    private List<Passagier> passagiers;

    public Anrede() {
    }

    public Anrede(@NotBlank String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public List<Passagier> getPassagiers() {
        return passagiers;
    }

    public void setPassagiers(List<Passagier> passagiers) {
        this.passagiers = passagiers;
    }

    @Override
    public String toString() {
        return "Anrede{" +
                "bezeichnung='" + bezeichnung + '\'' +
                '}';
    }
}

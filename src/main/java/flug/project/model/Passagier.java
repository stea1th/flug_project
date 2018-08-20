package flug.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = Passagier.ALL_IDS, query = "SELECT p.id FROM Passagier p ")
})
@Entity
@Table(name = "Passagier")
public class Passagier {

    public static final String ALL_IDS = "Passagier.getAllIds";

    @Id
    @NotNull
    @Column(name="P_ID")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "Name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "A_ID")
    private Anrede anrede;


    public Passagier() {
    }

//    public Passagier(@NotBlank String name) {
//        this.name = name;
//    }


    public Passagier(@NotNull Integer id, @NotBlank String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Anrede getAnrede() {
        return anrede;
    }

    public void setAnrede(Anrede anrede) {
        this.anrede = anrede;
    }

    @Override
    public String toString() {
        return "Passagier{" +
                "anrede='" + anrede + '\'' +
                ", name=" + name +
                '}';
    }
}

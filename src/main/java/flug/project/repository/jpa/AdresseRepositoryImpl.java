package flug.project.repository.jpa;

import flug.project.entity.Adresse;
import flug.project.entity.Ort;
import flug.project.repository.AdresseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AdresseRepositoryImpl implements AdresseRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Adresse save(Adresse adresse, String... ortId) {
        adresse.setOrtById(em.getReference(Ort.class, ortId[0]));
        em.persist(adresse);
        return adresse;
    }

    @Override
    public List<Adresse> get(String... arr) {
        return em.createNamedQuery(Adresse.GET, Adresse.class)
                .setParameter(1, arr[0])
                .setParameter(2, arr[1])
                .getResultList();
    }

    @Override
    public Adresse getById(String... arr) {
        return null;
    }


}

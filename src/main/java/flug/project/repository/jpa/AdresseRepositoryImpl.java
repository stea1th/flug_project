package flug.project.repository.jpa;

import flug.project.entity.Adresse;
import flug.project.entity.Ort;
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
    public Adresse save(Adresse adresse, Integer... ortId) {
        adresse.setOrtById(em.getReference(Ort.class, ortId[0]));
        em.persist(adresse);
        return adresse;
    }

    @Override
    public List<Adresse> getAll() {
        return em.createNamedQuery(Adresse.GET_ALL, Adresse.class)
                .getResultList();
    }
}

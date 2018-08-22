package flug.project.repository;

import flug.project.entity.Flughafen;
import flug.project.entity.Ort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional(readOnly = true)
@Repository
public class FlughafenRepositoryImpl implements FlughafenRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Flughafen save(Flughafen flughafen, Integer... arr) {
        flughafen.setOrtById(em.getReference(Ort.class, arr[0]));
        em.persist(flughafen);
        return flughafen;
    }

    @Override
    public List<String> getAll() {
        return em.createNamedQuery(Flughafen.GET_ALL_IDS, String.class)
                .getResultList();
    }

}

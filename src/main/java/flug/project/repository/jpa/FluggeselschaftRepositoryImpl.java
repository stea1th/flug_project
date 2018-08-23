package flug.project.repository.jpa;

import flug.project.entity.Fluggesellschaft;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class FluggeselschaftRepositoryImpl implements FluggeselschaftRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Fluggesellschaft save(Fluggesellschaft fluggesellschaft) {
        em.persist(fluggesellschaft);
        return fluggesellschaft;
    }

    @Override
    public Fluggesellschaft save(Fluggesellschaft fluggesellschaft, Integer... arr) {
        return null;
    }

    @Override
    public List<String> getAll() {
        return em.createNamedQuery(Fluggesellschaft.GET_ALL, String.class)
                .getResultList();
    }
}

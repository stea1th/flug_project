package flug.project.repository.jpa;

import flug.project.entity.Fluggesellschaft;
import flug.project.repository.FluggeselschaftRepository;
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
    public Fluggesellschaft getById(String... arr) {
        return em.find(Fluggesellschaft.class, arr[0]);
    }

    @Override
    public Fluggesellschaft save(Fluggesellschaft fluggesellschaft, Integer... arr) {
        return null;
    }

    @Override
    public List<Fluggesellschaft> get(String... arr) {
        return null;
    }


}

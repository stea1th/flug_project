package flug.project.repository;

import flug.project.entity.Land;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class LandRepositoryImpl implements LandRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Land save(Land land) {
        em.persist(land);
        return land;
    }

    @Override
    public List<Land> getAll() {
        return em.createNamedQuery(Land.GET_ALL, Land.class)
                .getResultList();
    }
}

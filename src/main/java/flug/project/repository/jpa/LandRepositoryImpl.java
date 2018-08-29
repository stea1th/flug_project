package flug.project.repository.jpa;

import flug.project.entity.Land;
import flug.project.repository.LandRepository;
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
    public Land save(Land land, Integer... arr) {
        return null;
    }

    @Override
    public List<Land> get(String... arr) {
        return em.createNamedQuery(Land.GET, Land.class)
                .setParameter(1, arr[0])
                .getResultList();
    }


}

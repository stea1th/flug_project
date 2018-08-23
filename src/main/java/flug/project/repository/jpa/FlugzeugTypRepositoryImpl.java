package flug.project.repository.jpa;

import flug.project.entity.FlugzeugTyp;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class FlugzeugTypRepositoryImpl implements FlugzeugTypRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public FlugzeugTyp save(FlugzeugTyp flugzeugTyp) {
        em.persist(flugzeugTyp);
        return flugzeugTyp;
    }

    @Override
    public FlugzeugTyp save(FlugzeugTyp flugzeugTyp, String... arr) {
        return null;
    }

    @Override
    public List<FlugzeugTyp> getAll() {
        return em.createNamedQuery(FlugzeugTyp.GET_ALL, FlugzeugTyp.class)
                .getResultList();
    }


}

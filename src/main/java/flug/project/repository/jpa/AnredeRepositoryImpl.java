package flug.project.repository.jpa;

import flug.project.entity.Anrede;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AnredeRepositoryImpl implements AnredeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Anrede save(Anrede anrede) {
        em.persist(anrede);
        return anrede;
    }

    @Override
    public Anrede save(Anrede anrede, Integer... arr) {
        return null;
    }

    @Override
    public List<Anrede> getAll() {
        return em.createNamedQuery(Anrede.GET_ALL, Anrede.class)
                .getResultList();
    }
}

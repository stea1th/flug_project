package flug.project.repository.jpa;

import flug.project.entity.Anrede;
import flug.project.repository.AnredeRepository;
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
    public List<Anrede> get(String... arr) {
        return em.createNamedQuery(Anrede.GET, Anrede.class)
                .setParameter(1, arr[0])
                .getResultList();
    }

    @Override
    public Anrede getById(String... arr) {
        return null;
    }
}

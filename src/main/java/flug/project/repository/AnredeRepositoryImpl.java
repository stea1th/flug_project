package flug.project.repository;

import flug.project.model.Anrede;
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
    public Anrede get(int id) {
        return null;
    }

    @Override
    public Anrede save(Anrede anrede) {
        return null;
    }

    @Override
    public List<Anrede> getAll() {
        return em.createNamedQuery(Anrede.ALL_UNSORTED, Anrede.class).getResultList();
    }
}

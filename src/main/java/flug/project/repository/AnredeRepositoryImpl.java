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
        return em.getReference(Anrede.class, id);
    }

    @Override
    @Transactional
    public Anrede save(Anrede anrede) {
        Anrede oldAnrede = get(anrede.getId());
        if(oldAnrede!=null)
            return oldAnrede;
        em.persist(anrede);
        return anrede;
    }

    @Override
    public List<Anrede> getAll() {
        return em.createNamedQuery(Anrede.ALL_UNSORTED, Anrede.class).getResultList();
    }
}

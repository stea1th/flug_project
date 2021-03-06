package flug.project.mock.repository;

import flug.project.mock.model.Passagier;
import flug.project.mock.model.Anrede;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class PassagierRepositoryImpl implements PassagierRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Passagier get(int id) {
        return em.getReference(Passagier.class, id);
    }

    @Override
    @Transactional
    public Passagier save(Passagier passagier, int anredeId) {
        passagier.setAnrede(em.getReference(Anrede.class, anredeId));
        em.persist(passagier);
        return passagier;
    }

    @Override
    public List<Integer> getAllIds() {
        return em.createNamedQuery(Passagier.ALL_IDS, Integer.class)
                    .getResultList();
    }
}

package flug.project.repository.jpa;

import flug.project.entity.BuchungsDaten;
import flug.project.entity.Flug;
import flug.project.entity.Passagier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class BuchungsDatenRepositoryImpl implements BuchungsDatenRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public BuchungsDaten save(BuchungsDaten buchungsDaten, Integer... arr) {
        buchungsDaten.setFlugById(em.getReference(Flug.class, arr[1]));
        buchungsDaten.setPassagierById(em.getReference(Passagier.class, arr[0]));
        em.persist(buchungsDaten);
        return buchungsDaten;
    }

    @Override
    public List<Integer> getAll() {
        return em.createNamedQuery(BuchungsDaten.GET_ALL, Integer.class)
                .getResultList();
    }
}

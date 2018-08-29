package flug.project.repository.jpa;

import flug.project.entity.BuchungsDaten;
import flug.project.entity.Flug;
import flug.project.entity.Passagier;
import flug.project.repository.BuchungsDatenRepository;
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
    public List<BuchungsDaten> get(Integer... arr) {
        return null;
    }

    @Override
    public List<BuchungsDaten> getBuchungsDaten(Integer nummer, String flugId) {
        return em.createNamedQuery(BuchungsDaten.GET_BD_WITH_FLUGG, BuchungsDaten.class)
                .setParameter(1, nummer)
                .setParameter(2, flugId)
                .getResultList();
    }
}

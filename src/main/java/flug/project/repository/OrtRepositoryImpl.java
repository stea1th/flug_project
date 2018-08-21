package flug.project.repository;

import flug.project.entity.Land;
import flug.project.entity.Ort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class OrtRepositoryImpl implements OrtRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Ort save(Ort ort, int landId) {
        ort.setLandByLId(em.getReference(Land.class, landId));
        em.persist(ort);
        return ort;
    }

    @Override
    public List<Ort> getAll() {
        return em.createNamedQuery(Ort.GET_ALL, Ort.class)
                .getResultList();
    }
}

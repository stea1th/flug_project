package flug.project.repository.jpa;

import flug.project.entity.Land;
import flug.project.entity.Ort;
import flug.project.repository.OrtRepository;
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
    public Ort save(Ort ort, String... landId) {
        ort.setLandByLId(em.getReference(Land.class, landId[0]));
        em.persist(ort);
        return ort;
    }

    @Override
    public List<Ort> get(String... arr) {
        return null;
    }

    @Override
    public Ort getById(String... arr) {
        return em.find(Ort.class, arr[0]);
    }


}

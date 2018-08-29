package flug.project.repository.jpa;

import flug.project.entity.Fluggesellschaft;
import flug.project.entity.Flughafen;
import flug.project.entity.Linie;
import flug.project.repository.LinieRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class LinieRepositoryImpl implements LinieRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Linie save(Linie linie, String... arr) {
        linie.setFlughafenByVon(em.getReference(Flughafen.class, arr[0]));
        linie.setFlughafenByNach(em.getReference(Flughafen.class, arr[1]));
        linie.setFluggesellschaftByFgId(em.getReference(Fluggesellschaft.class, arr[2]));
        em.persist(linie);
        return linie;
    }

    @Override
    public List<Linie> get(Integer... arr) {
        return null;
    }

    @Override
    public Linie getById(Integer... arr) {
        return em.find(Linie.class, arr[0]);
    }
}

package flug.project.repository.jpa;

import flug.project.entity.Flug;
import flug.project.entity.FlugzeugTyp;
import flug.project.entity.Linie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class FlugRepositoryImpl implements FlugRepository {

    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public Flug save(Flug flug, Integer... Ids) {
        flug.setFlugzeugTyp(em.getReference(FlugzeugTyp.class, Ids[0]));
        flug.setLinie(em.getReference(Linie.class, Ids[1]));
        em.persist(flug);
        return flug;
    }


    @Override
    public List<Flug> getAll() {
        return em.createNamedQuery(Flug.GET_ALL, Flug.class)
                .getResultList();
    }
}

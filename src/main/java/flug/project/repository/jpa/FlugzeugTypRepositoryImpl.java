package flug.project.repository.jpa;

import flug.project.entity.FlugzeugTyp;
import flug.project.repository.FlugzeugTypRepository;
import flug.project.utils.ConverterUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class FlugzeugTypRepositoryImpl implements FlugzeugTypRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public FlugzeugTyp save(FlugzeugTyp flugzeugTyp) {
        em.persist(flugzeugTyp);
        return flugzeugTyp;
    }

    @Override
    public FlugzeugTyp save(FlugzeugTyp flugzeugTyp, String... arr) {
        return null;
    }

    @Override
    public List<FlugzeugTyp> get(String... arr) {
        return em.createNamedQuery(FlugzeugTyp.GET, FlugzeugTyp.class)
                .setParameter(1, arr[0])
                .setParameter(2, ConverterUtil.convertInt(arr[1]))
                .setParameter(3, arr[2])
                .getResultList();
    }


}

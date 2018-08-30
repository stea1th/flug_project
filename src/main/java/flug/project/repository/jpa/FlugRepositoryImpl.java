package flug.project.repository.jpa;

import flug.project.entity.Flug;
import flug.project.entity.FlugzeugTyp;
import flug.project.entity.Linie;
import flug.project.repository.FlugRepository;
import flug.project.utils.ConverterUtil;
import flug.project.utils.DateTimeUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
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
    public List<Flug> get(String... arr) {
        return em.createNamedQuery(Flug.GET, Flug.class)
                .setParameter(1, DateTimeUtil.transformToDate(arr[0]))
                .setParameter(2, BigDecimal.valueOf(Double.parseDouble(arr[1])))
                .setParameter(3, ConverterUtil.convertToInt(arr[2]))
                .getResultList();

    }

    @Override
    public Flug getById(String... arr) {
        return null;
    }


}

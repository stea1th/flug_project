package flug.project.repository.jpa;

import flug.project.entity.Adresse;
import flug.project.entity.Anrede;

import flug.project.entity.Passagier;
import flug.project.repository.PassagierRepository;
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
    @Transactional
    public Passagier save(Passagier passagier, Integer... arr) {
        passagier.setAnredeByAId(em.getReference(Anrede.class, arr[0]));
        passagier.setAdresseByAdrId(em.getReference(Adresse.class, arr[1]));
        em.persist(passagier);
        return passagier;
    }

    @Override
    public List<Passagier> get(Integer... arr) {
        return null;
    }

    @Override
    public Passagier getById(Integer... arr) {
        return em.find(Passagier.class, arr[0]);
    }
}

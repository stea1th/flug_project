package flug.project.repository;

import flug.project.model.Passagier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class PassagierRepositoryImpl implements PassagierRepository {
    @Override
    public Passagier get(int id) {
        return null;
    }

    @Override
    public Passagier save(Passagier passagier, int anredeId) {
        return null;
    }

    @Override
    public List<Passagier> getAll() {
        return null;
    }
}

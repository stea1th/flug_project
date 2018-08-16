package flug.project.repository;

import flug.project.model.Passagier;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PassagierRepository {

    Passagier get(int id);

    Passagier save(Passagier passagier, int anredeId);

    List<Passagier> getAll();

}

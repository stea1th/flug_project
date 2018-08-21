package flug.project.mock.repository;

import flug.project.mock.model.Passagier;

import java.util.List;


public interface PassagierRepository {

    Passagier get(int id);

    Passagier save(Passagier passagier, int anredeId);

    List<Integer> getAllIds();

}

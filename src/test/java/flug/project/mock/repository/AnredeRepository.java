package flug.project.mock.repository;

import flug.project.mock.model.Anrede;

import java.util.List;


public interface AnredeRepository {

    Anrede get(int id);

    Anrede save(Anrede anrede);

    List<Anrede> getAll();

}

package flug.project.repository;

import flug.project.model.Anrede;

import java.util.List;


public interface AnredeRepository {

    Anrede get(int id);

    Anrede save(Anrede anrede);

    List<Anrede> getAll();

}

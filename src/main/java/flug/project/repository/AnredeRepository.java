package flug.project.repository;

import flug.project.entity.Anrede;

import java.util.List;

public interface AnredeRepository {

    Anrede save(Anrede anrede);

    List<Anrede> getAll();
}

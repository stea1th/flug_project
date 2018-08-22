package flug.project.repository;

import flug.project.entity.Anrede;
import flug.project.repository.interfaces.MainRepositoryInterface;

public interface AnredeRepository extends MainRepositoryInterface<Anrede, Integer, Anrede> {

    Anrede save(Anrede anrede);
}

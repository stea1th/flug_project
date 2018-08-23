package flug.project.repository.jpa;

import flug.project.entity.Anrede;
import flug.project.repository.MainRepositoryInterface;

public interface AnredeRepository extends MainRepositoryInterface<Anrede, Integer, Anrede> {

    Anrede save(Anrede anrede);
}

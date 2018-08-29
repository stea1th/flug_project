package flug.project.repository;

import flug.project.entity.Anrede;
import flug.project.repository.MainRepositoryInterface;

public interface AnredeRepository extends MainRepositoryInterface<Anrede, Integer, String> {

    Anrede save(Anrede anrede);
}

package flug.project.repository;

import flug.project.entity.FlugzeugTyp;
import flug.project.repository.MainRepositoryInterface;

public interface FlugzeugTypRepository extends MainRepositoryInterface<FlugzeugTyp, String, String> {

    FlugzeugTyp save(FlugzeugTyp flugzeugTyp);
}

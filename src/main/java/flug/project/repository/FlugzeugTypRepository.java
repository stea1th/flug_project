package flug.project.repository;

import flug.project.entity.FlugzeugTyp;
import flug.project.repository.interfaces.MainRepositoryInterface;

public interface FlugzeugTypRepository extends MainRepositoryInterface<FlugzeugTyp, String, FlugzeugTyp> {

    FlugzeugTyp save(FlugzeugTyp flugzeugTyp);
}

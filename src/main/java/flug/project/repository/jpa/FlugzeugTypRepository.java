package flug.project.repository.jpa;

import flug.project.entity.FlugzeugTyp;
import flug.project.repository.MainRepositoryInterface;

public interface FlugzeugTypRepository extends MainRepositoryInterface<FlugzeugTyp, String, FlugzeugTyp> {

    FlugzeugTyp save(FlugzeugTyp flugzeugTyp);
}

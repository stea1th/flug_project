package flug.project.repository.jpa;

import flug.project.entity.Fluggesellschaft;
import flug.project.repository.MainRepositoryInterface;

public interface FluggeselschaftRepository extends MainRepositoryInterface<Fluggesellschaft, Integer, String> {


    Fluggesellschaft save(Fluggesellschaft fluggesellschaft);
}

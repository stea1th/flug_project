package flug.project.repository;

import flug.project.entity.Fluggesellschaft;
import flug.project.repository.MainRepositoryInterface;

import java.util.List;

public interface FluggeselschaftRepository extends MainRepositoryInterface<Fluggesellschaft, Integer, String> {


    Fluggesellschaft save(Fluggesellschaft fluggesellschaft);


    Fluggesellschaft getById(String... arr);
}

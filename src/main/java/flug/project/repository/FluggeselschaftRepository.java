package flug.project.repository;

import flug.project.entity.Fluggesellschaft;
import flug.project.repository.interfaces.MainRepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface FluggeselschaftRepository extends MainRepositoryInterface<Fluggesellschaft, Integer, String> {


    Fluggesellschaft save(Fluggesellschaft fluggesellschaft);
}

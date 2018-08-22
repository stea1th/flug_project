package flug.project.repository;

import flug.project.entity.Land;
import flug.project.repository.interfaces.MainRepositoryInterface;


public interface LandRepository extends MainRepositoryInterface<Land, Integer, Land> {

    Land save(Land land);
}

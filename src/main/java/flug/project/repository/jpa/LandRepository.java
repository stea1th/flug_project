package flug.project.repository.jpa;

import flug.project.entity.Land;
import flug.project.repository.MainRepositoryInterface;


public interface LandRepository extends MainRepositoryInterface<Land, Integer, Land> {

    Land save(Land land);
}

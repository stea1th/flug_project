package flug.project.repository;

import flug.project.entity.Land;
import flug.project.repository.MainRepositoryInterface;


public interface LandRepository extends MainRepositoryInterface<Land, Integer, String> {

    Land save(Land land);

}

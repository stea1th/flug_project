package flug.project.repository;

import flug.project.entity.Land;

import java.util.List;

public interface LandRepository {

    Land save(Land land);

    List<Land> getAll();
}

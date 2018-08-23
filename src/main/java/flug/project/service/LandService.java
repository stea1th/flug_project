package flug.project.service;

import flug.project.entity.Land;

public interface LandService extends MainServiceInterface<Land, String, Integer> {

    Land create(Land land);
}

package flug.project.service;

import flug.project.entity.Land;
import flug.project.service.interfaces.MainServiceInterface;

public interface LandService extends MainServiceInterface<Land, String, Integer> {

    Land create(Land land);
}

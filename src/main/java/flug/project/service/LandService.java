package flug.project.service;

import flug.project.entity.Land;
import flug.project.service.interfaces.InterfaceWithMap;

public interface LandService extends InterfaceWithMap<Land, String, Integer> {

    Land create(Land land);
}

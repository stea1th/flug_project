package flug.project.service;

import flug.project.entity.Land;

import java.util.Map;

public interface LandService {
    Map<String, Integer> getAll();

    Land create(Land land);
}

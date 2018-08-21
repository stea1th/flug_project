package flug.project.service;

import flug.project.entity.Ort;

import java.util.Map;

public interface OrtService {
    Map<String, Integer> getAll();

    Ort save(Ort ort, int landId);
}

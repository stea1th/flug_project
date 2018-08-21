package flug.project.service;

import flug.project.entity.Anrede;

import java.util.Map;

public interface AnredeService {

    Map<String, Integer> getAll();

    Anrede create(Anrede anrede);
}

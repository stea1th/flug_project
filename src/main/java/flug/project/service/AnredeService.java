package flug.project.service;

import flug.project.entity.Anrede;

public interface AnredeService extends MainServiceInterface<Anrede, String, Integer> {

    Anrede create(Anrede anrede);
}

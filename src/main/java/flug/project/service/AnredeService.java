package flug.project.service;

import flug.project.entity.Anrede;
import flug.project.service.interfaces.MainServiceInterface;

public interface AnredeService extends MainServiceInterface<Anrede, String, Integer> {

    Anrede create(Anrede anrede);
}

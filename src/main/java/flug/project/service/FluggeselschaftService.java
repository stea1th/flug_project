package flug.project.service;

import flug.project.entity.Fluggesellschaft;
import flug.project.service.interfaces.MainServiceInterface;

import java.util.List;

public interface FluggeselschaftService extends MainServiceInterface<Fluggesellschaft, String, String> {
    List<String> getAllIds();

    Fluggesellschaft create(Fluggesellschaft fluggesellschaft);
}

package flug.project.service;

import flug.project.entity.Fluggesellschaft;

public interface FluggeselschaftService extends MainServiceInterface<Fluggesellschaft, String, String> {


    Fluggesellschaft create(Fluggesellschaft fluggesellschaft);
}

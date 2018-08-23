package flug.project.service;

import flug.project.entity.FlugzeugTyp;
import flug.project.service.interfaces.MainServiceInterface;

public interface FlugzeugTypService extends MainServiceInterface<FlugzeugTyp, String, Integer> {

    FlugzeugTyp create(FlugzeugTyp flugzeugTyp);
}

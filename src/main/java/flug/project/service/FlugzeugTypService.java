package flug.project.service;

import flug.project.entity.FlugzeugTyp;

public interface FlugzeugTypService extends MainServiceInterface<FlugzeugTyp, String, Integer> {

    FlugzeugTyp create(FlugzeugTyp flugzeugTyp);
}

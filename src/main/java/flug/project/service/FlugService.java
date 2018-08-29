package flug.project.service;

import flug.project.entity.Flug;

import java.time.LocalDate;

public interface FlugService extends MainServiceInterface<Flug, String, Integer>  {

    Flug create(Flug flug, Integer s, Integer id);
}

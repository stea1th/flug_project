package flug.project.service;

import flug.project.entity.Flug;
import flug.project.service.interfaces.MainServiceInterface;

import java.time.LocalDate;

public interface FlugService extends MainServiceInterface<Flug, LocalDate, Integer>  {

    Flug create(Flug flug, Integer s, Integer id);
}

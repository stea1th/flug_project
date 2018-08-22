package flug.project.service;

import flug.project.entity.Flughafen;
import flug.project.service.interfaces.MainServiceInterface;

import java.util.List;

public interface FlughafenService extends MainServiceInterface<Flughafen, String, Integer> {

    List<String> getAllIds();
}

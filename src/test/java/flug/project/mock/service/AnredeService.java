package flug.project.mock.service;

import flug.project.mock.model.Anrede;

import java.util.List;

public interface AnredeService {

    List<Anrede> getAll();

    Anrede create(Anrede anrede);
}

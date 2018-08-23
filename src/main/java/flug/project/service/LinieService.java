package flug.project.service;

import flug.project.entity.Linie;

public interface LinieService extends MainServiceInterface<Linie, Integer, String> {

    Linie create(Linie linie, String vonId, String nachId, String fluggId);
}

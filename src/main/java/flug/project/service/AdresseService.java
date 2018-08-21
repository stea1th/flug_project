package flug.project.service;

import flug.project.entity.Adresse;

import java.util.Map;

public interface AdresseService {

    Map<String, Integer> getAll();

    Adresse create(Adresse adresse, int ortId);
}

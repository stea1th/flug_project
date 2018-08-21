package flug.project.repository;


import flug.project.entity.Adresse;

import java.util.List;

public interface AdresseRepository {

    Adresse save(Adresse adresse, int ortId);

    List<Adresse> getAll();
}

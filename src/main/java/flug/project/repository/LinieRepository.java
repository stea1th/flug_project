package flug.project.repository;

import flug.project.entity.Linie;
import flug.project.repository.MainRepositoryInterface;

import java.util.List;

public interface LinieRepository extends MainRepositoryInterface<Linie, String, Integer > {

    Linie getById(Integer... arr);
}

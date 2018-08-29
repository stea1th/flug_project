package flug.project.repository;

import flug.project.entity.Flughafen;
import flug.project.repository.MainRepositoryInterface;

import java.util.List;

public interface FlughafenRepository extends MainRepositoryInterface<Flughafen, String, String> {

    Flughafen getById(String... arr);
}

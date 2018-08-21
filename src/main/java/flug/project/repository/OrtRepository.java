package flug.project.repository;

import flug.project.entity.Ort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface OrtRepository {


    Ort save(Ort ort, int landId);

    List<Ort> getAll();
}

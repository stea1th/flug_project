package flug.project.repository;


import flug.project.entity.Passagier;
import flug.project.repository.MainRepositoryInterface;

import java.util.List;

public interface PassagierRepository extends MainRepositoryInterface<Passagier, Integer, Integer> {

    Passagier save(Passagier passagier, String anr, Integer adr);
}

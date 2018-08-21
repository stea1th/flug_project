package flug.project.repository;



import flug.project.entity.Passagier;

import java.util.List;

public interface PassagierRepository {

    Passagier save(Passagier passagier, int anrId, int adrId);

    List<Integer> getAllIds();
}

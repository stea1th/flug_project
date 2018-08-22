package flug.project.service;

import flug.project.entity.Passagier;
import flug.project.service.interfaces.InterfaceWithMap;

import java.util.List;

public interface PassagierService {

    Passagier create(Passagier passagier, int anrId, int adrId);

    List<Integer> getAllIds();
}

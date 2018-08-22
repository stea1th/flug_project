package flug.project.service;

import flug.project.entity.Passagier;
import flug.project.service.interfaces.MainServiceInterface;

public interface PassagierService extends MainServiceInterface<Passagier, Integer, String> {

    Passagier create(Passagier passagier, int anrId, int adrId);

}

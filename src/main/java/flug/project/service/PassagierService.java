package flug.project.service;

import flug.project.entity.Passagier;

public interface PassagierService extends MainServiceInterface<Passagier, Integer, String> {

    Passagier create(Passagier passagier, String anrId, int adrId);

}

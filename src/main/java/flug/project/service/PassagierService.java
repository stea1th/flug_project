package flug.project.service;

import flug.project.model.Passagier;

import java.util.List;

public interface PassagierService {

    List<Passagier> getAll();

    Passagier create(Passagier passagier, int id);
}

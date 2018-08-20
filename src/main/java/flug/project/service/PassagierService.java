package flug.project.service;

import flug.project.model.Passagier;

import java.util.List;

public interface PassagierService {

    List<Integer> getAllIds();

    Passagier create(Passagier passagier, int id);
}

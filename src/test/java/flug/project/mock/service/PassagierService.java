package flug.project.mock.service;

import flug.project.mock.model.Passagier;

import java.util.List;

public interface PassagierService {

    List<Integer> getAllIds();

    Passagier create(Passagier passagier, int id);
}

package flug.project.mock.service;

import flug.project.mock.model.Passagier;
import flug.project.mock.repository.PassagierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagierServiceImpl implements PassagierService {


    private final PassagierRepository repository;

    @Autowired
    public PassagierServiceImpl(PassagierRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Integer> getAllIds() {
        return repository.getAllIds();
    }

    @Override
    public Passagier create(Passagier passagier, int id) {
        return repository.save(passagier, id);
    }
}

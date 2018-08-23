package flug.project.service;

import flug.project.entity.Passagier;
import flug.project.repository.jpa.PassagierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PassagierServiceImpl implements PassagierService {

    private PassagierRepository repository;

    @Autowired
    public PassagierServiceImpl(PassagierRepository repository) {
        this.repository = repository;
    }

    @Override
    public Passagier create(Passagier passagier, int anrId, int adrId) {
        return repository.save(passagier, anrId, adrId);
    }

    @Override
    public Map<Integer, String> getAll() {
        return null;
    }

    @Override
    public Passagier create(Passagier passagier, String id) {
        return null;
    }

    @Override
    public List<Integer> getAllIds() {
        return repository.getAll();
    }
}

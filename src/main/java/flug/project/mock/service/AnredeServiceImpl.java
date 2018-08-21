package flug.project.mock.service;

import flug.project.mock.model.Anrede;
import flug.project.mock.repository.AnredeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnredeServiceImpl implements AnredeService {

    private final AnredeRepository repository;

    @Autowired
    public AnredeServiceImpl(AnredeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Anrede> getAll() {
        return repository.getAll();
    }

    @Override
    public Anrede create(Anrede anrede) {
        return repository.save(anrede);
    }
}

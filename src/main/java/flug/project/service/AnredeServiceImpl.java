package flug.project.service;

import flug.project.model.Anrede;
import flug.project.repository.AnredeRepository;
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
}

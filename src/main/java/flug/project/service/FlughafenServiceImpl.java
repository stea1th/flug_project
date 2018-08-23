package flug.project.service;

import flug.project.entity.Flughafen;
import flug.project.repository.jpa.FlughafenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FlughafenServiceImpl implements FlughafenService {

    private FlughafenRepository repository;

    @Autowired
    public FlughafenServiceImpl(FlughafenRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> getAllIds() {
        return repository.getAll();
    }

    @Override
    public Map<String, Integer> getAll() {
        return null;
    }

    @Override
    public Flughafen create(Flughafen flughafen, Integer id) {
        return repository.save(flughafen, id);
    }
}

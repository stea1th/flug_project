package flug.project.service;

import flug.project.entity.Flughafen;
import flug.project.repository.FlughafenRepository;
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
    public Flughafen create(Flughafen flughafen, String id) {
        return repository.save(flughafen, id);
    }

    @Override
    public Flughafen get(String... arr) {
        return repository.getById(arr);
    }
}

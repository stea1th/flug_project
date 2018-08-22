package flug.project.service;

import flug.project.entity.Fluggesellschaft;
import flug.project.repository.FluggeselschaftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FluggeselschaftServiceImpl implements FluggeselschaftService {

    private FluggeselschaftRepository repository;

    @Autowired
    public FluggeselschaftServiceImpl(FluggeselschaftRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> getAllIds() {
        return repository.getAll();
    }

    @Override
    public Map<String, String> getAll() {
        return null;
    }

    @Override
    public Fluggesellschaft create(Fluggesellschaft fluggesellschaft, String id) {
        return null;
    }

    @Override
    public Fluggesellschaft create(Fluggesellschaft fluggesellschaft) {
        return repository.save(fluggesellschaft);
    }
}

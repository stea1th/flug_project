package flug.project.service;

import flug.project.entity.Land;
import flug.project.repository.LandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LandServiceImpl implements LandService {

    private LandRepository repository;

    public LandServiceImpl(LandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Land create(Land land, Integer id) {
        return null;
    }

    @Override
    public Land get(String... arr) {
        return repository.getById(arr);
    }

    @Override
    public Land create(Land land) {
        return repository.save(land);
    }
}

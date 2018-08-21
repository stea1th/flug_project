package flug.project.service;

import flug.project.entity.Land;
import flug.project.repository.LandRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LandServiceImpl implements LandService {

    private LandRepository repository;

    public LandServiceImpl(LandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, Integer> getAll() {
        return repository.getAll()
                .stream()
                .collect(Collectors.toMap(Land::getBezeichnung, Land::getlId));
    }

    @Override
    public Land create(Land land) {
        return null;
    }
}

package flug.project.service;

import flug.project.entity.Ort;
import flug.project.repository.jpa.OrtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrtServiceImpl implements OrtService {

    private OrtRepository repository;

    @Autowired
    public OrtServiceImpl(OrtRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, Integer> getAll() {
        return repository.getAll()
                .stream()
                .collect(Collectors.toMap(Ort::getBezeichnung, Ort::getoId));
    }

    @Override
    public Ort create(Ort ort, Integer landId) {
        return repository.save(ort, landId);
    }

    @Override
    public List<String> getAllIds() {
        return null;
    }
}

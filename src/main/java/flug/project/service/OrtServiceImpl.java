package flug.project.service;

import flug.project.entity.Ort;
import flug.project.repository.OrtRepository;
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
    public Ort create(Ort ort, Integer landId) {
        return repository.save(ort, landId);
    }

    @Override
    public Ort get(String... arr) {
        List<Ort> orts = repository.get(arr[0]);
        if(orts.isEmpty())
            return null;
        return orts.get(0);
    }


}

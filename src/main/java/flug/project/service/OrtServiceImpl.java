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


    public Ort create(Ort ort, String id) {
        return repository.save(ort, id);
    }


    public Ort get(String... arr) {
        return repository.getById(arr);
    }


    @Override
    public String saveIt(String... arr) {
        if(get(arr[0]) == null){
            create(new Ort(arr[0]), arr[1]);
        }
        return arr[0];
    }

    @Override
    public String saveIt(String[] t, String... arr) {
        return null;
    }
}

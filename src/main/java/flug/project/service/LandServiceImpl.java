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


    public Land get(String... arr) {
        return repository.getById(arr);
    }


    public Land create(Land land) {
        return repository.save(land);
    }


    @Override
    public String saveIt(String... arr) {
        if(get(arr[0]) == null){
            create(new Land(arr[0]));
        }
        return arr[0];
    }

    @Override
    public String saveIt(String[] t, String... arr) {
        return null;
    }
}

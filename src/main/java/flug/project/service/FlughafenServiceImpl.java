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


    public Flughafen create(Flughafen flughafen, String id) {
        return repository.save(flughafen, id);
    }


    public Flughafen get(String... arr) {
        return repository.getById(arr);
    }

    @Override
    public String saveIt(String... arr) {
        if(get(arr[0])==null){
            create(new Flughafen(arr[0]), arr[1]);
        }
        return arr[0];
    }

    @Override
    public String saveIt(String[] t, String... arr) {
        return null;
    }
}

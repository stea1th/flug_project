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


    public Fluggesellschaft get(String... arr) {
        return repository.getById(arr);
    }


    public Fluggesellschaft create(Fluggesellschaft fluggesellschaft) {
        return repository.save(fluggesellschaft);
    }

    @Override
    public String saveIt(String... arr) {
        if(get(arr[0])==null){
            create(new Fluggesellschaft(arr[0], arr[1]));
        }
        return arr[0];
    }

    @Override
    public String saveIt(String[] t, String... arr) {
        return null;
    }
}

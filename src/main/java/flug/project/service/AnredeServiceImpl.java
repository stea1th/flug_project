package flug.project.service;

import flug.project.entity.Anrede;
import flug.project.repository.AnredeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnredeServiceImpl implements AnredeService {

    private AnredeRepository repository;

    @Autowired
    public AnredeServiceImpl(AnredeRepository repository) {
        this.repository = repository;
    }

    public Anrede get(String... arr) {
        return repository.getById(arr);
    }

    public Anrede create(Anrede anrede) {
        return repository.save(anrede);
    }

    @Override
    public String saveIt(String... arr) {
        if(get(arr[0]) == null){
            create(new Anrede(arr[0]));
        }
        return arr[0];
    }

    @Override
    public String saveIt(String[] t, String... arr) {
        return null;
    }
}

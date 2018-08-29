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

    @Override
    public Anrede create(Anrede anrede, Integer id) {
        return null;
    }

    @Override
    public Anrede get(String... arr) {
        return repository.getById(arr);
    }

    public Anrede create(Anrede anrede) {
        return repository.save(anrede);
    }


}

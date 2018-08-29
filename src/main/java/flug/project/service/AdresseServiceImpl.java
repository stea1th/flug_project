package flug.project.service;

import flug.project.entity.Adresse;
import flug.project.repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdresseServiceImpl implements AdresseService {

    @Autowired
    private AdresseRepository repository;

    @Override
    public Adresse create(Adresse adresse, String id) {
        return repository.save(adresse, id);
    }

    @Override
    public Adresse get(String... arr) {
        List<Adresse> adresses = repository.get(arr);
        return adresses.isEmpty()? null : adresses.get(0);
    }


}

package flug.project.service;

import flug.project.entity.Adresse;
import flug.project.repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdresseServiceImpl implements AdresseService {

    private AdresseRepository repository;

    @Autowired
    public AdresseServiceImpl(AdresseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, Integer> getAll() {
        StringBuilder builder = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        repository.getAll().forEach(adresse -> {
            builder.append(adresse.getStrasse()).append(" ").append(adresse.getPlz());
            map.put(builder.toString(), adresse.getAdrId());
        });
        return map;
    }

    @Override
    public Adresse create(Adresse adresse, Integer id) {
        return repository.save(adresse, id);
    }

    @Override
    public List<String> getAllIds() {
        return null;
    }
}

package flug.project.service;

import flug.project.entity.Linie;
import flug.project.repository.LinieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LinieServiceImpl implements LinieService {

    private LinieRepository repository;

    @Autowired
    public LinieServiceImpl(LinieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Linie create(Linie linie, String vonId, String nachId, String fluggId) {
        return repository.save(linie, vonId, nachId, fluggId);
    }

    @Override
    public Linie create(Linie linie, String id) {
        return null;
    }

    @Override
    public Linie get(Integer... arr) {
        return repository.getById(arr);
    }


}

package flug.project.service;

import flug.project.entity.Flug;
import flug.project.repository.jpa.FlugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FlugServiceImpl implements FlugService {

    private FlugRepository repository;

    @Autowired
    public FlugServiceImpl(FlugRepository repository) {
        this.repository = repository;
    }



    @Override
    public Map<LocalDate, Integer> getAll() {
        return repository.getAll()
                .stream()
                .collect(Collectors.toMap(Flug::getDatum, Flug::getFlId));
    }

    @Override
    public Flug create(Flug flug, Integer id) {
        return null;
    }

    @Override
    public List<LocalDate> getAllIds() {
        return null;
    }


    @Override
    public Flug create(Flug flug, Integer s, Integer id) {
        return repository.save(flug, s, id);
    }
}

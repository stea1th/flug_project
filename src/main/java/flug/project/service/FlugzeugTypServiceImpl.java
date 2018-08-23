package flug.project.service;

import flug.project.entity.FlugzeugTyp;
import flug.project.repository.jpa.FlugzeugTypRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlugzeugTypServiceImpl implements FlugzeugTypService {

    private FlugzeugTypRepository repository;

    @Autowired
    public FlugzeugTypServiceImpl(FlugzeugTypRepository repository) {
        this.repository = repository;
    }


    @Override
    public FlugzeugTyp create(FlugzeugTyp flugzeugTyp) {
        return repository.save(flugzeugTyp);
    }

    @Override
    public Map<String, Integer> getAll() {
        StringBuilder builder = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        repository.getAll().forEach(flugzeugTyp -> {
            builder.append(flugzeugTyp.getTyp()).append(" ").append(flugzeugTyp.getKapaz());
            map.put(builder.toString(), flugzeugTyp.getFtId());
        });
        return map;
    }

    @Override
    public FlugzeugTyp create(FlugzeugTyp flugzeugTyp, Integer id) {
        return null;
    }

    @Override
    public List<String> getAllIds() {
        return null;
    }
}

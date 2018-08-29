package flug.project.service;

import flug.project.entity.FlugzeugTyp;
import flug.project.repository.FlugzeugTypRepository;
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
    public FlugzeugTyp create(FlugzeugTyp flugzeugTyp, Integer id) {
        return null;
    }

    @Override
    public FlugzeugTyp get(String... arr) {
        List<FlugzeugTyp> flugzeugTyps = repository.get(arr);
        return flugzeugTyps.isEmpty()? null : flugzeugTyps.get(0);
    }


}

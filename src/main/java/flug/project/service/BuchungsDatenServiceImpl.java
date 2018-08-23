package flug.project.service;

import flug.project.entity.BuchungsDaten;
import flug.project.repository.BuchungsDatenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuchungsDatenServiceImpl implements BuchungsDatenService {

    private BuchungsDatenRepository repository;

    @Autowired
    public BuchungsDatenServiceImpl(BuchungsDatenRepository repository) {
        this.repository = repository;
    }

    @Override
    public BuchungsDaten create(BuchungsDaten buchungsDaten, Integer passId, Integer flugId) {
        return repository.save(buchungsDaten, passId, flugId);
    }

    @Override
    public Map<Integer, Integer> getAll() {
        return null;
    }

    @Override
    public BuchungsDaten create(BuchungsDaten buchungsDaten, Integer id) {
        return null;
    }

    @Override
    public List<Integer> getAllIds() {
        return repository.getAll();
    }
}

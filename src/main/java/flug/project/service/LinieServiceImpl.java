package flug.project.service;

import flug.project.entity.Linie;
import flug.project.repository.LinieRepository;
import flug.project.utils.ConverterUtil;
import flug.project.utils.DateTimeUtil;
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

    public Linie create(Linie linie, String vonId, String nachId, String fluggId) {
        return repository.save(linie, vonId, nachId, fluggId);
    }

    public Linie get(Integer... arr) {
        return repository.getById(arr);
    }


    @Override
    public Integer saveIt(String... arr) {
        Integer id = ConverterUtil.convertInt(arr[0]);
        if(get(id)==null){
            create(new Linie(id, DateTimeUtil.transformToTime(arr[1])), arr[2], arr[3], arr[4]);
        }
        return id;
    }

    @Override
    public Integer saveIt(Integer[] t, String... arr) {
        return null;
    }
}

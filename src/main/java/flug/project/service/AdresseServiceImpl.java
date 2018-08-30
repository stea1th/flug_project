package flug.project.service;

import flug.project.entity.Adresse;
import flug.project.repository.AdresseRepository;
import flug.project.utils.ConverterUtil;
import flug.project.utils.CountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdresseServiceImpl implements AdresseService {

    @Autowired
    private AdresseRepository repository;


    public Adresse create(Adresse adresse, String id) {
        return repository.save(adresse, id);
    }


    public Adresse get(String... arr) {
        List<Adresse> adresses = repository.get(arr);
        return adresses.isEmpty()? null : adresses.get(0);
    }


    @Override
    public Integer saveIt(String... arr) {
        String plz = ConverterUtil.splitNull(arr[1]);
        Adresse a = get(arr[2], plz);
        if(a == null){
            a = new Adresse(CountUtil.getNewId(), plz, arr[1]);
            create(a, arr[0]);
        }
        return a.getAdrId();
    }

    @Override
    public Integer saveIt(Integer[] t, String... arr) {
        return null;
    }
}

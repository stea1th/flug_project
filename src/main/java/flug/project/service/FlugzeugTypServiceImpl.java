package flug.project.service;

import flug.project.entity.FlugzeugTyp;
import flug.project.repository.FlugzeugTypRepository;
import flug.project.utils.ConverterUtil;
import flug.project.utils.CountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static flug.project.utils.ConverterUtil.convertToInt;
import static flug.project.utils.CountUtil.getNewId;

@Service
public class FlugzeugTypServiceImpl implements FlugzeugTypService {

    private FlugzeugTypRepository repository;

    @Autowired
    public FlugzeugTypServiceImpl(FlugzeugTypRepository repository) {
        this.repository = repository;
    }

    public FlugzeugTyp create(FlugzeugTyp flugzeugTyp) {
        return repository.save(flugzeugTyp);
    }


    public FlugzeugTyp get(String... arr) {
        List<FlugzeugTyp> flugzeugTyps = repository.get(arr);
        return flugzeugTyps.isEmpty()? null : flugzeugTyps.get(0);
    }


    @Override
    public Integer saveIt(String... arr) {
        FlugzeugTyp ft = get(arr);
        if(ft==null){
            ft = new FlugzeugTyp(getNewId(), arr[0], convertToInt(arr[1]), arr[2]);
            create(ft);
        }
        return ft.getFtId();
    }

    @Override
    public Integer saveIt(Integer[] t, String... arr) {
        return null;
    }
}

package flug.project.service;

import flug.project.entity.Passagier;
import flug.project.repository.PassagierRepository;
import flug.project.utils.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassagierServiceImpl implements PassagierService {

    private PassagierRepository repository;

    @Autowired
    public PassagierServiceImpl(PassagierRepository repository) {
        this.repository = repository;
    }


    public Passagier create(Passagier passagier, String anrId, int adrId) {
        return repository.save(passagier, anrId, adrId);
    }

    public Passagier get(Integer... arr) {
        return repository.getById(arr);
    }


    @Override
    public Integer saveIt(String... arr) {
        return null;
    }

    @Override
    public Integer saveIt(Integer[] t, String... arr) {
        Integer id = ConverterUtil.convertInt(arr[1]);
        if(get(id)== null){
            create(new Passagier(id, arr[2]), arr[0], t[0]);
        }
        return id;
    }
}

package flug.project.service;

import flug.project.entity.BuchungsDaten;
import flug.project.repository.BuchungsDatenRepository;
import flug.project.utils.ConverterUtil;
import flug.project.utils.CountUtil;
import flug.project.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static flug.project.utils.ConverterUtil.convertToInt;
import static flug.project.utils.CountUtil.getNewId;
import static flug.project.utils.DateTimeUtil.transformToDate;

@Service
public class BuchungsDatenServiceImpl implements BuchungsDatenService {

    private BuchungsDatenRepository repository;

    @Autowired
    public BuchungsDatenServiceImpl(BuchungsDatenRepository repository) {
        this.repository = repository;
    }

    public BuchungsDaten create(BuchungsDaten buchungsDaten, Integer passId, Integer flugId) {
        return repository.save(buchungsDaten, passId, flugId);
    }

    public BuchungsDaten get(Integer nummer, String flugId) {
        List<BuchungsDaten> buchungsDatens = repository.getBuchungsDaten(nummer, flugId);
        return buchungsDatens.isEmpty()? null : buchungsDatens.get(0);
    }

    @Override
    public Integer saveIt(String... arr) {
        return null;
    }

    @Override
    public Integer saveIt(Integer[] t, String... arr) {
        Integer num = convertToInt(arr[1]);
        BuchungsDaten bd = get(num, arr[0]);
        if(bd==null){
            bd = new BuchungsDaten(getNewId(), num, transformToDate(arr[2]));
            create(bd, t[0], t[1]);
        }
        return bd.getBdId();
    }
}

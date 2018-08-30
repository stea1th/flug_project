package flug.project.service;

import flug.project.entity.Flug;
import flug.project.repository.FlugRepository;
import flug.project.utils.ConverterUtil;
import flug.project.utils.CountUtil;
import flug.project.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public Flug get(String... arr) {
        List<Flug> flugs = repository.get(arr);
        return flugs.isEmpty()? null : flugs.get(0);
    }

    public Flug create(Flug flug, Integer s, Integer id) {
        return repository.save(flug, s, id);
    }

    @Override
    public Integer saveIt(String... arr) {
        return null;
    }

    @Override
    public Integer saveIt(Integer[] t, String... arr) {
        Flug f = get(arr);
        if(f==null){
            f = new Flug(CountUtil.getNewId(), DateTimeUtil.transformToDate(arr[0]),
                    BigDecimal.valueOf(Double.parseDouble(arr[1])),
                    ConverterUtil.convertInt(arr[2]));
            create(f, t[0], t[1]);
        }
        return f.getFlId();
    }
}

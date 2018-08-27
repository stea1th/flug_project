package flug.project.web;

import flug.project.entity.*;
import flug.project.service.*;
import flug.project.utils.ConverterUtil;
import flug.project.utils.CountUtil;
import flug.project.utils.DateTimeUtil;
import flug.project.xlsreader.XLSReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;


public abstract class AbstractMainController {

    @Autowired
    private LandService landService;

    @Autowired
    private OrtService ortService;

    @Autowired
    private AdresseService adresseService;

    @Autowired
    private AnredeService anredeService;

    @Autowired
    private PassagierService passagierService;

    @Autowired
    private FlughafenService flughafenService;

    @Autowired
    private FluggeselschaftService fluggeselschaftService;

    @Autowired
    private LinieService linieService;

    @Autowired
    private FlugzeugTypService flugzeugTypService;

    @Autowired
    private FlugService flugService;

    @Autowired
    private BuchungsDatenService buchungsDatenService;

    private Map<String, Integer> landMap;
    private Map<String, Integer> ortMap;
    private Map<String, Integer> adresseMap;
    private Map<String, Integer> anredeMap;
    private List<Integer> passagierIds;
    private List<String> flughafenIds;
    private List<String> fluggesIds;
    private List<Integer> linIds;
    private Map<String, Integer> flugzeugTyps;
    private Map<LocalDate, Integer> flugs;

    private void init(){
        landMap = landService.getAll();
        ortMap = ortService.getAll();
        adresseMap = adresseService.getAll();
        anredeMap = anredeService.getAll();
        passagierIds = passagierService.getAllIds();
        flughafenIds = flughafenService.getAllIds();
        fluggesIds = fluggeselschaftService.getAllIds();
        linIds = linieService.getAllIds();
        flugzeugTyps = flugzeugTypService.getAll();
        flugs = flugService.getAll();
    }


    public void saveAll(String url) throws IOException {
        init();
        for(String[] arr : XLSReader.readXLS(ConverterUtil.convertToUrl(url))){
            int landId = saveLand(arr[24]);
            int ortId = saveOrt(arr[22], landId);
            int adrId = saveAdresse(ortId, arr[21], arr[23]);
            int anrId = saveAnrede(arr[19]);
            int passId = savePassagier(anrId, adrId, arr[18], arr[20]);

            String vonFlug = saveFlughafen(arr[3], arr[4], arr[5]);
            String bisFlug = saveFlughafen(arr[6], arr[7], arr[8]);

            String fluggesId = saveFluggeselschaft(arr[0], arr[1]);

            int linId = saveLinie(new String[]{arr[2], arr[9], vonFlug, bisFlug, fluggesId});
            int ftId = saveFlugzeugTyp(new String[]{arr[12], arr[15], arr[13]});
            int flId = saveFlug(ftId, linId, arr[10], arr[11]);
            saveBuchungsDaten(arr[0], arr[16], arr[17], passId, flId);
        }
    }

    private int saveLand(String land){
        Integer id;
            if(landMap.containsKey(land)){
                id = landMap.get(land);
            }else{
                Land l = new Land(CountUtil.getNewId(), land);
                id = l.getlId();
                landMap.put(l.getBezeichnung(), id);
                landService.create(l);
            }
            return id;
    }

    private int saveOrt(String ort, int landId){
        Integer id;
        if(ortMap.containsKey(ort)){
                id = ortMap.get(ort);
        }else{
                Ort o = new Ort(CountUtil.getNewId(), ort);
                id = o.getoId();
                ortMap.put(o.getBezeichnung(), id);
                ortService.create(o, landId);
        }
        return id;
    }

    private int saveAdresse(int ortId, String... arr){
        Integer id;
        String adresse = arr[1]+" "+ConverterUtil.splitNull(arr[0]);
        if(adresseMap.containsKey(adresse)){
            id = adresseMap.get(adresse);
        }else{
            Adresse a = new Adresse(CountUtil.getNewId(), ConverterUtil.splitNull(arr[0]), arr[1]);
            id = a.getAdrId();
            adresseMap.put(adresse, id);
            adresseService.create(a, ortId);
        }
        return id;
    }

    private int saveAnrede(String anrede){
        Integer id;
        if(anredeMap.containsKey(anrede)){
            id = anredeMap.get(anrede);
        }else{
            Anrede an = new Anrede(CountUtil.getNewId(), anrede);
            id = an.getaId();
            anredeMap.put(an.getBezeichnung(), id);
            anredeService.create(an);
        }
        return id;
    }

    private int savePassagier(int anrId, int adrId, String... arr){
        Integer id = ConverterUtil.convertInt(arr[0]);
        if(!passagierIds.contains(id)){
            passagierService.create(new Passagier(id, arr[1]), anrId, adrId);
            passagierIds.add(id);
        }
        return id;
    }

    private String saveFlughafen(String flugId, String land, String ort){
        int ortId = saveOrt(ort, saveLand(land));
        if(!flughafenIds.contains(flugId)){
            flughafenService.create(new Flughafen(flugId), ortId);
            flughafenIds.add(flugId);
        }
        return flugId;
    }

    private String saveFluggeselschaft(String id, String name){
        if(!fluggesIds.contains(id)){
            fluggeselschaftService.create(new Fluggesellschaft(id, name));
            fluggesIds.add(id);
        }
        return id;
    }

    private int saveLinie(String[] arr){
        Integer id = ConverterUtil.convertInt(arr[0]);
        String[] time = arr[1].split(":");
        LocalTime dauer = LocalTime.of(Integer.parseInt(time[0].trim()), Integer.parseInt(time[1].trim()));
        if(!linIds.contains(id)){
            linieService.create(new Linie(id, dauer), arr[2], arr[3], arr[4]);
            linIds.add(id);
        }
        return id;
    }

    private int saveFlugzeugTyp(String[] arr){
        String bez = arr[0]+" "+ConverterUtil.splitNull(arr[1]);
        Integer id;
        if(flugzeugTyps.containsKey(bez)){
            id = flugzeugTyps.get(bez);
        }else{
            FlugzeugTyp ft = new FlugzeugTyp(CountUtil.getNewId(), arr[0], ConverterUtil.convertInt(arr[1]), arr[2]);
            id = ft.getFtId();
            flugzeugTyps.put(bez, id);
            flugzeugTypService.create(ft);
        }
        return id;
    }

    private int saveFlug(int ftId, int linId, String... arr){
        LocalDate date = DateTimeUtil.transformToDate(arr[0]);
        Integer id;
        if(flugs.containsKey(date)){
            id = flugs.get(date);
        }else{
            Flug flug = new Flug(CountUtil.getNewId(), date, BigDecimal.valueOf(Double.parseDouble(arr[1])));
            id = flug.getFlId();
            flugs.put(date, id);
            flugService.create(flug, ftId, linId);
        }
        return id;
    }

    private void saveBuchungsDaten(String fluggesId, String nummer, String datum, int passId, int flugId){
        Integer num = ConverterUtil.convertInt(nummer);
        if(buchungsDatenService.get(num, fluggesId).size()==0){
            BuchungsDaten bd = new BuchungsDaten(CountUtil.getNewId(), num, DateTimeUtil.transformToDate(datum));
            buchungsDatenService.create(bd, passId, flugId);
        }
    }
}

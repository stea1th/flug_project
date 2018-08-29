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

    public void saveAll(String url) throws IOException {

        for(String[] arr : XLSReader.readXLS(ConverterUtil.convertToUrl(url))){
            String landId = saveLand(arr[24]);
            String ortId = saveOrt(arr[22], landId);
            int adrId = saveAdresse(ortId, arr[21], arr[23]);
            int anrId = saveAnrede(arr[19]);
            int passId = savePassagier(anrId, adrId, arr[18], arr[20]);

            String vonFlug = saveFlughafen(arr[3], arr[4], arr[5]);
            String bisFlug = saveFlughafen(arr[6], arr[7], arr[8]);

            String fluggesId = saveFluggeselschaft(arr[0], arr[1]);

            int linId = saveLinie(new String[]{arr[2], arr[9], vonFlug, bisFlug, fluggesId});
            int ftId = saveFlugzeugTyp(new String[]{arr[12], arr[15], arr[13]});
            int flId = saveFlug(ftId, linId, arr[10], arr[11], arr[14]);
            saveBuchungsDaten(arr[0], arr[16], arr[17], passId, flId);
        }
    }

    private String saveLand(String land){
        if(landService.get(land) == null){
            landService.create(new Land(land));
        }
        return land;
    }

    private String saveOrt(String ort, String landId){
        if(ortService.get(ort) == null){
            ortService.create(new Ort(ort), landId);
        }
        return ort;
    }

    private int saveAdresse(String ortId, String... arr){
        Adresse a = adresseService.get(arr[1], ConverterUtil.splitNull(arr[0]));
        if(a == null){
            a = new Adresse(CountUtil.getNewId(), ConverterUtil.splitNull(arr[0]), arr[1]);
            adresseService.create(a, ortId);
        }
        return a.getAdrId();
    }

    private int saveAnrede(String anrede){
        Anrede an = anredeService.get(anrede);
        if(an == null){
            an = new Anrede(CountUtil.getNewId(), anrede);
            anredeService.create(an);
        }
        return an.getaId();
    }

    private int savePassagier(int anrId, int adrId, String... arr){
        Integer id = ConverterUtil.convertInt(arr[0]);
        if(passagierService.get(id)== null){
            passagierService.create(new Passagier(id, arr[1]), anrId, adrId);
        }
        return id;
    }

    private String saveFlughafen(String flugId, String land, String ort){
        if(flughafenService.get(flugId)==null){
            flughafenService.create(new Flughafen(flugId), saveOrt(ort, saveLand(land)));
        }
        return flugId;
    }

    private String saveFluggeselschaft(String id, String name){
        if(fluggeselschaftService.get(id)==null){
            fluggeselschaftService.create(new Fluggesellschaft(id, name));
        }
        return id;
    }

    private int saveLinie(String[] arr){
        Integer id = ConverterUtil.convertInt(arr[0]);
        if(linieService.get(id)==null){
            linieService.create(new Linie(id, DateTimeUtil.transformToTime(arr[1])), arr[2], arr[3], arr[4]);
        }
        return id;
    }

    private int saveFlugzeugTyp(String[] arr){
        FlugzeugTyp ft = flugzeugTypService.get(arr);
        if(ft==null){
            ft = new FlugzeugTyp(CountUtil.getNewId(), arr[0], ConverterUtil.convertInt(arr[1]), arr[2]);
            flugzeugTypService.create(ft);
        }
        return ft.getFtId();
    }

    private int saveFlug(int ftId, int linId, String... arr){
        Flug f = flugService.get(arr);
        if(f==null){
            f = new Flug(CountUtil.getNewId(), DateTimeUtil.transformToDate(arr[0]),
                    BigDecimal.valueOf(Double.parseDouble(arr[1])),
                    ConverterUtil.convertInt(arr[2]));
            flugService.create(f, ftId, linId);
        }
        return f.getFlId();
    }

    private void saveBuchungsDaten(String fluggesId, String nummer, String datum, int passId, int flugId){
        Integer num = ConverterUtil.convertInt(nummer);
        if(buchungsDatenService.get(num, fluggesId).size()==0){
            BuchungsDaten bd = new BuchungsDaten(CountUtil.getNewId(), num, DateTimeUtil.transformToDate(datum));
            buchungsDatenService.create(bd, passId, flugId);
        }
    }
}

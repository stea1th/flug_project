package flug.project.web;

import flug.project.entity.*;
import flug.project.service.*;
import flug.project.utils.CountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class RestController {

    private List<String[]> xlsList;

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

    private Map<String, Integer> landMap;
    private Map<String, Integer> ortMap;
    private Map<String, Integer> adresseMap;
    private Map<String, Integer> anredeMap;
    private List<Integer> passagierIds;

    public void setXlsList(List<String[]> xlsList) {
        this.xlsList = xlsList;
    }

    private void init(){
        landMap = landService.getAll();
        ortMap = ortService.getAll();
        adresseMap = adresseService.getAll();
        anredeMap = anredeService.getAll();
        passagierIds = passagierService.getAllIds();
    }


    public void saveAll(){
        init();
        for(String[] arr : xlsList){
            int landId = saveLand(arr[24]);
            int ortId = saveOrt(arr[22], landId);
            int adrId = saveAdresse(ortId, arr[21], arr[23]);
            int anrId = saveAnrede(arr[19]);
            int passId = savePassagier(anrId, adrId, arr[18], arr[20] );
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
        String adresse = arr[1]+" "+arr[0].replace(".0", "");
        if(adresseMap.containsKey(adresse)){
            id = adresseMap.get(adresse);
        }else{
            Adresse a = new Adresse(CountUtil.getNewId(), arr[0].replace(".0", ""), arr[1]);
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
        Integer id = Integer.valueOf(arr[0].replace(".0", ""));
        if(!passagierIds.contains(id)){
            passagierService.create(new Passagier(id, arr[1]), anrId, adrId);
            passagierIds.add(id);
        }
        return id;
    }

    /*for(String[] arr : xlsList){
        Integer id;
        Integer pId = Integer.parseInt(arr[0]);
        if(anredeMap.containsKey(arr[1])){
            id = anredeMap.get(arr[1]);
        }else{
            Anrede an = new Anrede(flug.project.utils.CountUtil.getNewId(), arr[1]);
            anredeMap.put(an.getBezeichnung(), an.getId());
            anredeRestController.create(an);
            id = an.getId();
        }
        if(!passIds.contains(pId)){
            passIds.add(pId);
            passagierRestController.create(new Passagier(pId, arr[2]), id);
        }
    }*/
}

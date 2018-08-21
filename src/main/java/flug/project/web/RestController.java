package flug.project.web;

import flug.project.entity.Land;
import flug.project.entity.Ort;
import flug.project.service.LandService;
import flug.project.service.OrtService;
import flug.project.utils.CountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class RestController {

    private List<String[]> xlsList;

    public void setXlsList(List<String[]> xlsList) {
        this.xlsList = xlsList;
    }

    @Autowired
    private LandService landService;

    @Autowired
    private OrtService ortService;

    private Map<String, Integer> landMap;
    private Map<String, Integer> ortMap;

    private void init(){
        landMap = landService.getAll();
        ortMap = ortService.getAll();
    }


    public void saveAll(){
        init();
        for(String[] arr : xlsList){
            int landId = saveLand(arr[24]);
            saveOrt(arr[22], landId);
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

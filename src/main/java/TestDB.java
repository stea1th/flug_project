import flug.project.model.Anrede;
import flug.project.model.Passagier;
import flug.project.repository.AnredeRepository;
import flug.project.service.AnredeService;
import flug.project.service.AnredeServiceImpl;
import flug.project.web.AnredeRestController;
import flug.project.web.PassagierRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestDB {

    public static void main(String[] args)throws IOException {

        List<String[]> xlsList = XLSReader.readXLS();
        xlsList.remove(0);
        saveAnredeUndPassagier(xlsList);
    }

    public static void saveAnredeUndPassagier(List<String[]> xlsList){
        try(ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            AnredeRestController anredeRestController = appCtx.getBean(AnredeRestController.class);
            PassagierRestController passagierRestController = appCtx.getBean(PassagierRestController.class);

            Map<String, Integer> anredeMap = anredeRestController.getAll()
                    .stream()
                    .collect(Collectors.toMap(Anrede::getBezeichnung, Anrede::getId));
            List<Integer> passIds = passagierRestController.getAllIds();

            for(String[] arr : xlsList){
                Integer id;
                Integer pId = Integer.parseInt(arr[0]);
                if(anredeMap.containsKey(arr[1])){
                    id = anredeMap.get(arr[1]);
                }else{
                    Anrede an = new Anrede(CountUtil.getNewId(), arr[1]);
                    anredeMap.put(an.getBezeichnung(), an.getId());
                    anredeRestController.create(an);
                    id = an.getId();
                }
                if(!passIds.contains(pId)){
                    passIds.add(pId);
                    passagierRestController.create(new Passagier(pId, arr[2]), id);
                }
            }
        }
    }
}

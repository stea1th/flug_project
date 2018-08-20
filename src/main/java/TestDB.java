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

        try(ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            AnredeRestController anredeRestController = appCtx.getBean(AnredeRestController.class);
            PassagierRestController passagierRestController = appCtx.getBean(PassagierRestController.class);
//            List<Anrede> list = anredeRestController.getAll();
//            list.forEach(System.out::println);
//            for(Anrede a : list){
//                a.getPassagiers().forEach(System.out::println);
//            }
//            Anrede an = anredeRestController.create(new Anrede(5,""));
//            passagierRestController.create(new Passagier(35,"Pavlik Durov"), an.getId());

            Map<String, Integer> anredeMap = anredeRestController.getAll()
                    .stream()
                    .collect(Collectors.toMap(Anrede::getBezeichnung, Anrede::getId));
            List<Integer> passIds = passagierRestController.getAllIds();

            for(String[] arr : xlsList){
                Passagier passagier = null;
                if(!passIds.contains(Integer.parseInt(arr[0]))){
                    passagier = new Passagier(Integer.parseInt(arr[0]), arr[2]);
                    passIds.add(Integer.parseInt(arr[0]));
                }
                if(anredeMap.containsKey(arr[1])){
                    if(passagier != null)
                        passagierRestController.create(passagier, anredeMap.get(arr[1]));
                }else{
                    Anrede an = new Anrede(CountUtil.getNewId(), arr[1]);
                    anredeMap.put(an.getBezeichnung(), an.getId());
                    anredeRestController.create(an);
                    if(passagier != null)
                        passagierRestController.create(passagier, an.getId());
                }
            }


            /*for(String[] arr : xlsList){
                if(!anredeList.contains(arr[1])) {
                    anredeRestController.create(new Anrede(arr[1]));
                    anredeList.add(arr[1]);
                }
                passagierRestController.create(new Passagier(Integer.parseInt(arr[0]), arr[2]), arr[1]);
                //System.out.println(arr[0]+" "+ arr[1]+" "+arr[2]);*/
            }
        }
}

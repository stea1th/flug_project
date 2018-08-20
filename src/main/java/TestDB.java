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
import java.util.stream.Collectors;

public class TestDB {

    public static void main(String[] args)throws IOException {

        /*List<String[]> xlsList = XLSReader.readXLS();
        xlsList.remove(0);*/

        try(ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            AnredeRestController anredeRestController = appCtx.getBean(AnredeRestController.class);
            PassagierRestController passagierRestController = appCtx.getBean(PassagierRestController.class);
//            List<Anrede> list = anredeRestController.getAll();
//            list.forEach(System.out::println);
//            for(Anrede a : list){
//                a.getPassagiers().forEach(System.out::println);
//            }
            Anrede an = anredeRestController.create(new Anrede(5,""));
            passagierRestController.create(new Passagier(35,"Pavlik Durov"), an.getId());

            /*List<String> anredeList = anredeRestController.getAll()
                    .stream()
                    .map(Anrede::getId)
                    .collect(Collectors.toList());
            for(String[] arr : xlsList){
                if(!anredeList.contains(arr[1])) {
                    anredeRestController.create(new Anrede(arr[1]));
                    anredeList.add(arr[1]);
                }
                passagierRestController.create(new Passagier(Integer.parseInt(arr[0]), arr[2]), arr[1]);
                //System.out.println(arr[0]+" "+ arr[1]+" "+arr[2]);*/
            }
        }
}

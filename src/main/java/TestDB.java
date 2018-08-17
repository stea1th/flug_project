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
            /*Anrede an = anredeRestController.create(new Anrede(""));
            passagierRestController.create(new Passagier(35,"Pavlik Durov"), an.getId());*/


            for(String[] arr : xlsList){
                Anrede an = anredeRestController.create(new Anrede(arr[1]));
                passagierRestController.create(new Passagier(Integer.parseInt(arr[0]), arr[2]), an.getId());
                //System.out.println(arr[0]+" "+ arr[1]+" "+arr[2]);
            }
        }




    }
}

import flug.project.model.Anrede;
import flug.project.repository.AnredeRepository;
import flug.project.service.AnredeService;
import flug.project.service.AnredeServiceImpl;
import flug.project.web.AnredeRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDB {

    public static void main(String[] args) {

        try(ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            AnredeRestController controller = appCtx.getBean(AnredeRestController.class);
            List<Anrede> list = controller.getAll();
//            list.forEach(System.out::println);
            for(Anrede a : list){
                a.getPassagiers().forEach(System.out::println);
            }
        }




    }
}

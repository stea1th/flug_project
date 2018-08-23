import flug.project.web.FlugController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TestMainDB {

    public static void main(String[] args) throws IOException {

        try(ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            FlugController controller = appCtx.getBean(FlugController.class);
            controller.saveAll("D:/JavaProjects/aa_test.xls");
        }

    }
}

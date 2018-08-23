import flug.project.web.FlugController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class TestMainDB {

    public static void main(String[] args) throws IOException {

        List<String[]> xlsList = XLSReader.readXLS();
        xlsList.remove(0);
        try(ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            FlugController controller = appCtx.getBean(FlugController.class);
            controller.setXlsList(xlsList);
            controller.saveAll();
        }

    }
}

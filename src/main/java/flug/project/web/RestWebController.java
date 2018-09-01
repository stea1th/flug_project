package flug.project.web;

import flug.project.utils.exception.CannotSaveException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalTime;

@RestController

public class RestWebController extends AbstractMainController {

    @PostMapping("/upload")
    @ResponseBody
    public String postString(@RequestBody String url)  {
        int start = LocalTime.now().toSecondOfDay();
        try {
           super.saveAll(url);
        } catch (IOException e) {
            return "Error";
        } catch (CannotSaveException e) {
            return "Error on line "+e.getLocalizedMessage();
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("File was saved in: "+(LocalTime.now().toSecondOfDay()-start)+" seconds");
        return "Done";
    }
}

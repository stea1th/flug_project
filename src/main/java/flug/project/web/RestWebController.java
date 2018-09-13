package flug.project.web;

import flug.project.utils.exception.CannotSaveException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalTime;

@RestController
public class RestWebController extends AbstractMainController {

    @PostMapping("/upload")
    public String postString(@RequestBody String url)  {
        StopWatch stopWatch = new StopWatch("Save time of " + url);
        try {
            stopWatch.start("saveAll()");
            System.out.println("StopWatch start");
            super.saveAll(url);
        } catch (IOException e) {
            return "Error";
        } catch (CannotSaveException e) {
            return "Error on line "+e.getLocalizedMessage();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            stopWatch.stop();
            System.out.println("StopWatch stop");
            System.out.println(stopWatch.prettyPrint());
        }
        return "Done";
    }
}

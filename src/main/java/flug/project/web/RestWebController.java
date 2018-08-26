package flug.project.web;

import flug.project.message.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController

public class RestWebController extends AbstractMainController {

    @PostMapping("/upload")
    @ResponseBody
    public String postString(@RequestBody String url)  {
        System.out.println(url);
        try {
            super.saveAll(url);
        } catch (IOException e) {
            return "Error";
        }
        return "Done";
    }
}

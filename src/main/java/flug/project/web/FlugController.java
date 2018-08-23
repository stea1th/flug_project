package flug.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlugController extends AbstractMainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

}

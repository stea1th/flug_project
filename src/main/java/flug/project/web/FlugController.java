package flug.project.web;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class FlugController extends AbstractMainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @PostMapping
    public String getXLS(HttpServletRequest request) throws IOException {
        super.saveAll(request.getParameter("file"));
        return "index";
    }



    /*@Override
    public void saveAll(String url) throws IOException {
        super.saveAll(url);
    }*/
}

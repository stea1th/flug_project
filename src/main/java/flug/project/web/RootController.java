package flug.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class RootController extends AbstractMainController{

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadFile(HttpServletRequest request,
                             Model model) throws IOException {
        String text = request.getParameter("text");
        super.setUrl(text);
        //saveAll(text);
        model.addAttribute("mess", text);
        return "redirect:upload";
    }
}

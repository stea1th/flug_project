package flug.project.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//    @PostMapping("/upload")
//    public String getXLS(HttpServletRequest request) throws IOException, ServletException {
//        //super.saveAll(request.getParameter("file"));
//        Part filePart = request.getPart("file");
//        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//        System.out.println(fileName);
//        return "index";
//    }

    @PostMapping("/upload")
    public String uploadFile(HttpServletRequest request,
                             Model model) {
        String text = request.getParameter("text");
        try {
            saveAll(text);
        } catch (IOException e) {
            model.addAttribute("mess", "Falsche File/Daten err");
            return "index";
        }
        model.addAttribute("mess", "Die Daten aus "+text+" wurde gespeichert!");
        return "index";
    }

    @Override
    public void saveAll(String url) throws IOException {
        super.saveAll(url);
    }
}

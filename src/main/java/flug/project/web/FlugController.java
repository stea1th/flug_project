package flug.project.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping(value = "/upload")
public class FlugController extends AbstractMainController {



//    @PostMapping("/upload")
//    public String getXLS(HttpServletRequest request) throws IOException, ServletException {
//        //super.saveAll(request.getParameter("file"));
//        Part filePart = request.getPart("file");
//        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//        System.out.println(fileName);
//        return "index";
//    }



    @GetMapping
    public String getMessage(HttpServletRequest request, Model model) throws IOException {
        String x = request.getParameter("mess");
        Thread t = new Thread(() -> {
            try {
                saveAll(x);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        model.addAttribute("mess", x);
        t.run();
        return "upload";
    }

    /*@GetMapping("save")
    public String tryToSave(Model model) throws IOException {
        saveAll(super.getUrl());
        model.addAttribute("ber", "All done");
        return "index";
    }*/

    @Override
    public void saveAll(String url) throws IOException {
        super.saveAll(url);
    }


}

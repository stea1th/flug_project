package flug.project.web;

import flug.project.model.Anrede;
import flug.project.service.AnredeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AnredeRestController {

    @Autowired
    private AnredeService service;

    public List<Anrede> getAll(){
        return service.getAll();
    }



}

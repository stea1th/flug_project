package flug.project.mock.web;

import flug.project.mock.service.AnredeService;
import flug.project.mock.model.Anrede;
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


    public Anrede create(Anrede anrede){
        return service.create(anrede);
    }
}

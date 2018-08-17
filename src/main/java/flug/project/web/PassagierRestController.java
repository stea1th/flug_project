package flug.project.web;

import flug.project.model.Passagier;
import flug.project.service.PassagierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PassagierRestController {

    @Autowired
    private PassagierService service;

    public Passagier create(Passagier passagier, int id){
        return service.create(passagier, id);
    }
}

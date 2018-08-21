package flug.project.mock.web;

import flug.project.mock.model.Passagier;
import flug.project.mock.service.PassagierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PassagierRestController {

    @Autowired
    private PassagierService service;

    public Passagier create(Passagier passagier, int id){
        return service.create(passagier, id);
    }

    public List<Integer> getAllIds(){
        return service.getAllIds();
    }
}

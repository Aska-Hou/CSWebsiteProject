package controller.indexController;

import domain.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TutorService;

import java.util.List;

@Controller
@RequestMapping(value = "/tutor")
public class TutorController {

    @Autowired
    public TutorService tutorService;

    @RequestMapping(value = "/showTutorList")
    @ResponseBody
    public List<Tutor> showTutorList(){
        return tutorService.showTutorList();
    }


}

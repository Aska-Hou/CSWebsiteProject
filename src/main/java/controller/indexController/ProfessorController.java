package controller.indexController;

import domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ProfessorService;

import java.util.List;

@Controller
@RequestMapping(value = "/professor")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @RequestMapping(value = "/showProfessorList")
    @ResponseBody
    public List<Professor> showProfessorList(){
        return professorService.showProfessorList();
    }

    @RequestMapping(value = "/showProfessorDetail")
    @ResponseBody
    public Professor showProfessorDetail(Professor professor){
        return professorService.showProfessorDetail(professor);
    }
}

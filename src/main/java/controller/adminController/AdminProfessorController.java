package controller.adminController;

import domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ProfessorService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/professor")
public class AdminProfessorController {

    @Autowired
    ProfessorService professorService;

    @RequestMapping(value = "/showProfessorList")
    @ResponseBody
    public List<Professor> showProfessorList() {
        return professorService.showProfessorList();
    }


    //    管理员： 根据关键词展示professor列表
    @RequestMapping(value = "/searchProfessorList")
    @ResponseBody
    public List<Professor> searchProfessorList(Professor professor) {
        //            如果未传值，则展示所有的professor
        if (professor.getProf_id() == 0 && professor.getName().equals("null")){
            return professorService.showProfessorList();
        }

        else {
            List<Professor> professors = professorService.searchProfessorList(professor);
            return professors;
        }
    }


}

package controller.adminController;

import domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ProfessorService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
        if (professor.getProf_id() == 0 && professor.getName().equals("null")) {
            return professorService.showProfessorList();
        } else {
            List<Professor> professors = professorService.searchProfessorList(professor);
            return professors;
        }
    }

    //    管理员： 加入新professor
    @RequestMapping(value = "/addNewProfessor")
    public ModelAndView addNewProfessor(@RequestParam(value = "img", required = true) MultipartFile img, Professor professor) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        if (professor == null) {
            modelAndView.setViewName("/facultyInfo.html");
            return modelAndView;
        } else {
            Professor newProfessor = professorService.addNewProfessor(img, professor);
            modelAndView.setViewName("/facultyEdit.html?prof_id=" + newProfessor.getProf_id() + "&add=true");
            return modelAndView;
        }
    }

    //    管理员： 查看指定professor的详细信息
    @RequestMapping(value = "/getProfessorDetails")
    @ResponseBody
    public Professor getProfessorDetails(Professor professor) {
        Professor detail = professorService.showProfessorDetail(professor);
        return detail;
    }

    //    管理员： 更新professor信息
    @RequestMapping(value = "/editProfessor")
    public String editProfessor(@RequestParam(value = "img", required = false) MultipartFile img, Professor professor) {
        boolean result = professorService.updateProfessor(img, professor);
        if (result) {
            return "redirect:/admin/facultyEdit.html?prof_id=" + professor.getProf_id() + "&update=true";
        } else {
            return "redirect:/admin/facultyEdit.html?prof_id=" + professor.getProf_id() + "&update=false";
        }
    }

}

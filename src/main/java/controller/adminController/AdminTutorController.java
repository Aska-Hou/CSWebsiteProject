package controller.adminController;

import domain.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.TutorService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin/tutor")
public class AdminTutorController {

    @Autowired
    TutorService tutorService;

    @RequestMapping(value = "/showTutorList")
    @ResponseBody
    public List<Tutor> showTutorList() {
        return tutorService.showTutorList();
    }


    //    管理员： 根据关键词展示tutor列表
    @RequestMapping(value = "/searchTutorList")
    @ResponseBody
    public List<Tutor> searchTutorList(Tutor tutor) {
        //            如果未传值，则展示所有的tutor
        if (tutor.getTutor_id() == 0 && tutor.getName().equals("null")) {
            return tutorService.showTutorList();
        } else {
            List<Tutor> tutors = tutorService.searchTutorList(tutor);
            return tutors;
        }
    }

    //    管理员： 加入新tutor
    @RequestMapping(value = "/addNewTutor")
    public ModelAndView addNewTutor(@RequestParam(value = "img", required = true) MultipartFile img, Tutor tutor) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        if (tutor == null) {
            modelAndView.setViewName("redirect:/admin/tutorInfo.html?add=false");
            return modelAndView;
        } else {
            Tutor newTutor = tutorService.addNewTutor(img, tutor);
            modelAndView.setViewName("redirect:/admin/tutorEdit.html?tutor_id=" + newTutor.getTutor_id() + "&add=true");
            return modelAndView;
        }
    }

    //    管理员： 查看指定tutor的详细信息
    @RequestMapping(value = "/getTutorDetails")
    @ResponseBody
    public Tutor getTutorDetails(Tutor tutor) {
        Tutor detail = tutorService.showTutorDetail(tutor);
        return detail;
    }

    //    管理员： 更新tutor信息
    @RequestMapping(value = "/editTutor")
    public String editTutor(@RequestParam(value = "img", required = false) MultipartFile img, Tutor tutor) {
        boolean result = tutorService.updateTutor(img, tutor);
        if (result) {
            return "redirect:/admin/tutorEdit.html?tutor_id=" + tutor.getTutor_id() + "&update=true";
        } else {
            return "redirect:/admin/tutorEdit.html?tutor_id=" + tutor.getTutor_id() + "&update=false";
        }
    }

    //    删除所选tutor
    @RequestMapping(value = "/deleteSelectedTutor")
    public String deleteSelectedTutor(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.size() > 0) {
            boolean result = tutorService.deleteSelectedTutor(parameterMap);
            if (result) {
                return "redirect:/admin/tutorInfo.html?delete=true";
            } else return "redirect:/admin/tutorInfo.html?delete=false";
        }
        else return "redirect:/admin/tutorInfo.html?delete=false";
    }

    //    删除单个tutor
    @RequestMapping(value = "/deleteOneTutor")
    public String deleteOneTutor(Tutor tutor) {
        boolean result = tutorService.deleteOneTutor(tutor);
        if (result){
            return "redirect:/admin/tutorInfo.html?delete=true";
        }
        else return "redirect:/admin/tutorInfo.html?delete=false";
    }
}

package controller.adminController;

import domain.ResearchCenter;
import domain.ResearchCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ResearchCenterService;
import service.ResearchCenterService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin/center")
public class AdminResearchCenterController {

    @Autowired
    ResearchCenterService centerService;

    @RequestMapping(value = "/showCenterList")
    @ResponseBody
    public List<ResearchCenter> showCenterList() {
        return centerService.showResearchCenterList();
    }


    //    管理员： 根据关键词展示center列表
    @RequestMapping(value = "/searchCenterList")
    @ResponseBody
    public List<ResearchCenter> searchCenterList(ResearchCenter center) {
        //            如果未传值，则展示所有的center
        if (center.getCenter_id() == 0 && center.getTitle().equals("null")) {
            return centerService.showResearchCenterList();
        } else {
            List<ResearchCenter> centers = centerService.searchResearchCenterList(center);
            return centers;
        }
    }

    //    管理员： 加入新center
    @RequestMapping(value = "/addNewCenter")
    public ModelAndView addNewCenter(@RequestParam(value = "img", required = true) MultipartFile img, ResearchCenter center) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        if (center == null) {
            modelAndView.setViewName("redirect:/admin/researchCenterInfo.html?add=false");
            return modelAndView;
        } else {
            ResearchCenter newCenter = centerService.addNewResearchCenter(img, center);
            modelAndView.setViewName("redirect:/admin/researchCenterEdit.html?center_id=" + newCenter.getCenter_id() + "&add=true");
            return modelAndView;
        }
    }

    //    管理员： 查看指定center的详细信息
    @RequestMapping(value = "/getCenterDetails")
    @ResponseBody
    public ResearchCenter getCenterDetails(ResearchCenter center) {
        ResearchCenter detail = centerService.showResearchCenterDetail(center);
        return detail;
    }

    //    管理员： 更新center信息
    @RequestMapping(value = "/editCenter")
    public String editCenter(@RequestParam(value = "img", required = false) MultipartFile img, ResearchCenter center) {
        boolean result = centerService.updateResearchCenter(img, center);
        if (result) {
            return "redirect:/admin/researchCenterEdit.html?center_id=" + center.getCenter_id() + "&update=true";
        } else {
            return "redirect:/admin/researchCenterEdit.html?center_id=" + center.getCenter_id() + "&update=false";
        }
    }

    //    删除所选center
    @RequestMapping(value = "/deleteSelectedCenter")
    public String deleteSelectedCenter(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.size() > 0) {
            boolean result = centerService.deleteSelectedResearchCenter(parameterMap);
            if (result) {
                return "redirect:/admin/researchCenterInfo.html?delete=true";
            } else return "redirect:/admin/researchCenterInfo.html?delete=false";
        }
        else return "redirect:/admin/researchCenterInfo.html?delete=false";
    }

    //    删除单个center
    @RequestMapping(value = "/deleteOneCenter")
    public String deleteOneCenter(ResearchCenter center) {
        boolean result = centerService.deleteOneResearchCenter(center);
        if (result){
            return "redirect:/admin/researchCenterInfo.html?delete=true";
        }
        else return "redirect:/admin/researchCenterInfo.html?delete=false";
    }
}

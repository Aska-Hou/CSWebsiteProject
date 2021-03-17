package controller.indexController;

import domain.ResearchCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ResearchCenterService;

import java.util.List;

@Controller
@RequestMapping(value = "/center")
public class ResearchCenterController {

    @Autowired
    ResearchCenterService professorService;

    @RequestMapping(value = "/showCenterList")
    @ResponseBody
    public List<ResearchCenter> showResearchCenterList(){
        return professorService.showResearchCenterList();
    }

    @RequestMapping(value = "/showCenterDetail")
    @ResponseBody
    public ResearchCenter showResearchCenterDetail(ResearchCenter professor){
        return professorService.showResearchCenterDetail(professor);
    }
}

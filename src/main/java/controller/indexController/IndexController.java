package controller.indexController;


import domain.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IndexService;

import java.util.List;

@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    public IndexService indexService;

    @RequestMapping(value = "/showIndexSliderImage")
    @ResponseBody
    public List<Index> showIndexSliderImage(){
        return indexService.showIndexList();
    }

}

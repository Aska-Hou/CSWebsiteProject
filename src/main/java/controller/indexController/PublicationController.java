package controller.indexController;

import domain.Page;
import domain.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.PublicationService;

import java.util.List;

@Controller
@RequestMapping(value = "/publication")
public class PublicationController {

    @Autowired
    PublicationService publicationService;

    //    展示所有的Publication
    @RequestMapping(value = "/showPublication")
    @ResponseBody
    public List<Paper> showPaperList(Page page) {
        return publicationService.showPaperList(page);
    }

    //    展示页码
    @RequestMapping(value = "/showPageList")
    @ResponseBody
    public Page showPageList() {
        return publicationService.showPageList();
    }
}

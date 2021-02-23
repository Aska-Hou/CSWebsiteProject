package controller.adminController;

import domain.News;
import domain.Page;
import domain.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.PublicationService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin/publication")
public class AdminPublicationController {

    @Autowired
    public PublicationService publicationService;

    //    管理员： 分页展示所有的publication列表
    @RequestMapping(value = "/showPublicationList")
    @ResponseBody
    public List<Publication> showPublicationList(Page page) {
        return publicationService.showPublicationList(page);
    }

    //    管理员： publication列表页数展示
    @RequestMapping(value = "/showPagesList")
    @ResponseBody
    public Page showPagesList(Publication publication) {
        if (publication.getPublication_id() == 0 && publication.getTitle() == null) {
            return publicationService.showPageList();
        } else {
            return publicationService.showPageList(publication);
        }
    }

    //    管理员： 根据关键词展示publication列表
    @RequestMapping(value = "/searchPublicationList")
    @ResponseBody
    public List<Publication> searchPublicationList(Publication publication, Page page) {
        //   如果未传值，则展示所有的publication
        if (publication.getPublication_id() == 0 && publication.getTitle().equals("null")) {
            return publicationService.showPublicationList(page);
        } else {
            List<Publication> publications = publicationService.showPublicationList(publication, page);
            return publications;
        }
    }

    //    管理员： 加入新publication
    @RequestMapping(value = "/addNewPublication")
    public ModelAndView addNewPublication(Publication publication) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        if (publication == null) {
            modelAndView.setViewName("redirect:/admin/publicationInfo.html?add=false");
            return modelAndView;
        } else {
            Publication newPublication = publicationService.addNewPublication(publication);
            modelAndView.setViewName("redirect:/admin/publicationEdit.html?publication_id=" + newPublication.getPublication_id() + "&add=true");
            return modelAndView;
        }
    }

    //    管理员： 查看指定publication的详细信息
    @RequestMapping(value = "/getPublicationDetails")
    @ResponseBody
    public Publication getPublicationDetails(Publication publication) {
        Publication detail = publicationService.showPublicationDetail(publication);
        return detail;
    }

    //    管理员： 更新publication信息
    @RequestMapping(value = "/editPublication")
    public String editPublication(@RequestParam(value = "img", required = false) MultipartFile img, Publication publication) {
        boolean result = publicationService.updatePublication(publication);
        if (result) {
            return "redirect:/admin/publicationEdit.html?publication_id=" + publication.getPublication_id() + "&update=true";
        } else {
            return "redirect:/admin/publicationEdit.html?publication_id=" + publication.getPublication_id() + "&update=false";
        }
    }

    //    删除所选Publication
    @RequestMapping(value = "/deleteSelectedPublication")
    public String deleteSelectedPublication(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.size() > 0) {
            boolean result = publicationService.deleteSelectedPublication(parameterMap);
            if (result) {
                return "redirect:/admin/publicationInfo.html?delete=true";
            } else return "redirect:/admin/publicationInfo.html?delete=false";
        } else return "redirect:/admin/publicationInfo.html?delete=false";
    }

    //    删除单个Publication
    @RequestMapping(value = "/deleteOnePublication")
    public String deleteOnePublication(Publication Publication) {
        boolean result = publicationService.deleteOnePublication(Publication);
        if (result) {
            return "redirect:/admin/publicationInfo.html?delete=true";
        } else return "redirect:/admin/publicationInfo.html?delete=false";
    }

}

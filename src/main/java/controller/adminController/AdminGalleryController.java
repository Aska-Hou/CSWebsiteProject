package controller.adminController;

import domain.Gallery;
import domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.GalleryService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin/gallery")
public class AdminGalleryController {

    @Autowired
    public GalleryService galleryService;

    //    管理员： 分页展示所有的gallery列表
    @RequestMapping(value = "/showGalleryList")
    @ResponseBody
    public List<Gallery> showGalleryList(Page page) {
        return galleryService.showGalleryList(page);
    }

    //    管理员： gallery列表页数展示
    @RequestMapping(value = "/showPagesList")
    @ResponseBody
    public Page showPagesList(Gallery gallery) {
        if (gallery.getGallery_id() == 0 && gallery.getTitle() == null) {
            return galleryService.showPageList();
        } else {
            return galleryService.showPageList(gallery);
        }
    }

    //    管理员： 根据关键词展示gallery列表
    @RequestMapping(value = "/searchGalleryList")
    @ResponseBody
    public List<Gallery> searchGalleryList(Gallery gallery, Page page) {
        //   如果未传值，则展示所有的gallery
        if (gallery.getGallery_id() == 0 && gallery.getTitle().equals("null")) {
            return galleryService.showGalleryList(page);
        } else {
            List<Gallery> gallerys = galleryService.showGalleryList(gallery, page);
            return gallerys;
        }
    }

    //    Add gallery 界面展示related gallery
    @RequestMapping(value = "/showRecentGallery")
    @ResponseBody
    public List<Gallery> showRecentGallery() {
        return galleryService.showRecentGallery();
    }

    //    管理员： 加入新gallery
    @RequestMapping(value = "/addNewGallery")
    public ModelAndView addNewGallery(@RequestParam(value = "img", required = true) MultipartFile img, Gallery gallery) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        if (gallery == null) {
            modelAndView.setViewName("redirect:/admin/galleryInfo.html?add=false");
            return modelAndView;
        } else {
            Gallery newGallery = galleryService.addNewGallery(img, gallery);
            modelAndView.setViewName("redirect:/admin/galleryEdit.html?gallery_id=" + newGallery.getGallery_id() + "&add=true");
            return modelAndView;
        }
    }

    //    管理员： 查看指定gallery的详细信息
    @RequestMapping(value = "/getGalleryDetails")
    @ResponseBody
    public Gallery getGalleryDetails(Gallery gallery) {
        Gallery detail = galleryService.showGalleryDetail(gallery);
        return detail;
    }

    //    管理员： 更新gallery信息
    @RequestMapping(value = "/editGallery")
    public String editGallery(@RequestParam(value = "img", required = false) MultipartFile img, Gallery gallery) {
        boolean result = galleryService.updateGallery(img, gallery);
        if (result) {
            return "redirect:/admin/galleryEdit.html?gallery_id=" + gallery.getGallery_id() + "&update=true";
        } else {
            return "redirect:/admin/galleryEdit.html?gallery_id=" + gallery.getGallery_id() + "&update=false";
        }
    }

    //    删除所选Gallery
    @RequestMapping(value = "/deleteSelectedGallery")
    public String deleteSelectedGallery(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.size() > 0) {
            boolean result = galleryService.deleteSelectedGallery(parameterMap);
            if (result) {
                return "redirect:/admin/galleryInfo.html?delete=true";
            } else return "redirect:/admin/galleryInfo.html?delete=false";
        } else return "redirect:/admin/galleryInfo.html?delete=false";
    }

    //    删除单个Gallery
    @RequestMapping(value = "/deleteOneGallery")
    public String deleteOneGallery(Gallery Gallery) {
        boolean result = galleryService.deleteOneGallery(Gallery);
        if (result) {
            return "redirect:/admin/galleryInfo.html?delete=true";
        } else return "redirect:/admin/galleryInfo.html?delete=false";
    }

}

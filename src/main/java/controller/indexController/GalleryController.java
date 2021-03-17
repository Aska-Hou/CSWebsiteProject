package controller.indexController;

import domain.Gallery;
import domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.GalleryService;

import java.util.List;

@Controller
@RequestMapping(value = "/gallery")
public class GalleryController {

    @Autowired
    public GalleryService galleryService;

    @RequestMapping(value = "/showGalleryList")
    @ResponseBody
    public List<Gallery> showGalleryList(Page page){
        List<Gallery> gallery = galleryService.showGalleryList(page);
        return gallery;
    }

    @RequestMapping(value = "/showPageList")
    @ResponseBody
    public Page showPageList(){
        Page page = galleryService.showPageList();
        return page;
    }

    @RequestMapping(value = "/showDetail")
    @ResponseBody
    public Gallery showGalleryDetail(Gallery gallery){
        return galleryService.showGalleryDetail(gallery);
    }

    @RequestMapping(value = "/showRecentGallery")
    @ResponseBody
    public List<Gallery> showRecentGallery(){
        return galleryService.showRecentGallery();
    }
}

package controller.adminController;

import domain.Index;
import domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.IndexService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/index")
public class AdminIndexController {

    @Autowired
    public IndexService indexService;

    @RequestMapping(value = "/showRecentNews")
    @ResponseBody
    public List<News> showRecentNews(){
        return indexService.showRecentNews();
    }

    @RequestMapping(value = "/addNewIndex")
    public String addNewIndex(MultipartFile img, String news_id) throws IOException {
        Index index = new Index();
        if (news_id.length() != 0){
            index.setNews_id(news_id);
        }
        boolean result = indexService.addNewIndex(img, index);
        if (result){
            return "redirect:/admin/adminUserIndex.html?add=true";
        }
        else {
            return "redirect:/admin/adminUserIndex.html?add=false";
        }
    }

    @RequestMapping(value = "/showIndexList")
    @ResponseBody
    public List<Index> showIndexList(){
        return indexService.showIndexList();
    }

    @RequestMapping(value = "/deleteIndex")
    @ResponseBody
    public String deleteIndex(Index index){
        if(indexService.deleteIndex(index)){
            return "true";
        }
        else {
            return "false";
        }
    }
}

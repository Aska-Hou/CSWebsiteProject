package controller.indexController;

import domain.News;
import domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.NewsService;

import java.util.List;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    public NewsService newsService;

    @RequestMapping(value = "/showNewsList")
    @ResponseBody
    public List<News> showNewsList(Page page){
        List<News> news = newsService.showNewsList(page);
        return news;
    }

    @RequestMapping(value = "/showPageList")
    @ResponseBody
    public Page showPageList(){
        Page page = newsService.showPageList();
        return page;
    }

    @RequestMapping(value = "/showDetail")
    @ResponseBody
    public News showNewsDetail(News news){
        return newsService.showNewsDetail(news);
    }

    @RequestMapping(value = "/showRecentNews")
    @ResponseBody
    public List<News> showReceentNews(){
        return newsService.showRecentNews();
    }
}

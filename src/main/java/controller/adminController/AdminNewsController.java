package controller.adminController;

import domain.News;
import domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.NewsService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin/news")
public class AdminNewsController {

    @Autowired
    public NewsService newsService;

    //    管理员： 分页展示所有的news列表
    @RequestMapping(value = "/showNewsList")
    @ResponseBody
    public List<News> showNewsList(Page page) {
        return newsService.showNewsList(page);
    }

    //    管理员： news列表页数展示
    @RequestMapping(value = "/showPagesList")
    @ResponseBody
    public Page showPagesList(News news) {
        if (news.getNews_id() == 0 && news.getTitle() == null) {
            return newsService.showPageList();
        } else {
            return newsService.showPageList(news);
        }
    }

    //    管理员： 根据关键词展示news列表
    @RequestMapping(value = "/searchNewsList")
    @ResponseBody
    public List<News> searchNewsList(News news, Page page) {
        //   如果未传值，则展示所有的news
        if (news.getNews_id() == 0 && news.getTitle().equals("null")) {
            return newsService.showNewsList(page);
        } else {
            List<News> newss = newsService.showNewsList(news, page);
            return newss;
        }
    }

    //    Add news 界面展示related news
    @RequestMapping(value = "/showRecentNews")
    @ResponseBody
    public List<News> showRecentNews() {
        return newsService.showRecentNews();
    }

    //    管理员： 加入新news
    @RequestMapping(value = "/addNewNews")
    public ModelAndView addNewNews(@RequestParam(value = "img", required = true) MultipartFile img, News news) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        if (news == null) {
            modelAndView.setViewName("redirect:/admin/newsInfo.html?add=false");
            return modelAndView;
        } else {
            News newNews = newsService.addNewNews(img, news);
            modelAndView.setViewName("redirect:/admin/newsEdit.html?news_id=" + newNews.getNews_id() + "&add=true");
            return modelAndView;
        }
    }

    //    管理员： 查看指定news的详细信息
    @RequestMapping(value = "/getNewsDetails")
    @ResponseBody
    public News getNewsDetails(News news) {
        News detail = newsService.showNewsDetail(news);
        return detail;
    }

    //    管理员： 更新news信息
    @RequestMapping(value = "/editNews")
    public String editNews(@RequestParam(value = "img", required = false) MultipartFile img, News news) {
        boolean result = newsService.updateNews(img, news);
        if (result) {
            return "redirect:/admin/newsEdit.html?news_id=" + news.getNews_id() + "&update=true";
        } else {
            return "redirect:/admin/newsEdit.html?news_id=" + news.getNews_id() + "&update=false";
        }
    }

    //    删除所选News
    @RequestMapping(value = "/deleteSelectedNews")
    public String deleteSelectedNews(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.size() > 0) {
            boolean result = newsService.deleteSelectedNews(parameterMap);
            if (result) {
                return "redirect:/admin/newsInfo.html?delete=true";
            } else return "redirect:/admin/newsInfo.html?delete=false";
        } else return "redirect:/admin/newsInfo.html?delete=false";
    }

    //    删除单个News
    @RequestMapping(value = "/deleteOneNews")
    public String deleteOneNews(News News) {
        boolean result = newsService.deleteOneNews(News);
        if (result) {
            return "redirect:/admin/newsInfo.html?delete=true";
        } else return "redirect:/admin/newsInfo.html?delete=false";
    }

}

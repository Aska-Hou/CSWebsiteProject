package service;

import domain.News;
import domain.Page;
import domain.News;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface NewsService {

    //    分页展示News List内容(无关键词）
    public List<News> showNewsList(Page page);

    //    分页展示News List内容(有关键词）
    public List<News> showNewsList(News news, Page page);

    //页码展示 (无关键词）
    public Page showPageList();

    //页码展示 (有关键词）
    public Page showPageList(News news);

    //    添加功能：
    //    1. Add界面展示recent news
    public List<News> showRecentNews();

    //    2. Add 功能
    public News addNewNews(MultipartFile img, News news);


    //    查询news详细信息
    public News showNewsDetail(News news);

    //    删除：
    //    1. 单个删除
    public boolean deleteOneNews(News news);

    //    2. 批量删除
    public boolean deleteSelectedNews(Map<String, String[]> paraMap);

    //    更新 News 信息
    public boolean updateNews(MultipartFile img, News news);


}

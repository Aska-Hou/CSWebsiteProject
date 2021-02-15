package service;

import domain.News;
import domain.Page;

import java.util.List;

public interface NewsService {

    public List<News> showNewsList(Page page);

    public Page showPageList();

    public News showNewsDetail(News news);
}

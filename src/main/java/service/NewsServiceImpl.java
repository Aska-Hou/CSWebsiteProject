package service;

import dao.NewsDao;
import domain.News;
import domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    public NewsDao newsDao;

    @Override
    public News showNewsDetail(News news) {
        return newsDao.selectNewsByID(news);
    }

    @Override
    public Page showPageList() {
        Integer result = newsDao.showLineNumber();
        Page page = new Page();
        page.setTotalLine(result);
        page.setLineEachPage(6);
        if (result % page.getLineEachPage() == 0){
            page.setTotalPage(result / page.getLineEachPage());
        }
        else {
            page.setTotalPage(result / page.getLineEachPage() + 1);
        }
        return page;
    }

    @Override
    public List<News> showNewsList(Page page) {
        page.setLineEachPage(6);
        int currentPage = page.getCurrentPage();
        page.setCurrentLine((currentPage - 1) * page.getLineEachPage());
        return newsDao.selectAllNewsByPage(page);
    }
}

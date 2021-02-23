package service;

import dao.NewsDao;
import dao.NewsDao;
import domain.News;
import domain.Page;
import domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    public NewsDao newsDao;

    @Override
    public List<News> showNewsList(Page page) {
        page.setLineEachPage(6);
        int currentPage = page.getCurrentPage();
        int currentLine = (currentPage - 1) * (page.getLineEachPage());
        page.setCurrentLine(currentLine);
        return newsDao.showAllNews(page);
    }

    @Override
    public List<News> showNewsList(News news, Page page) {
        List<News> newss = new ArrayList<>();

        if (news.getNews_id() != 0) {
            newss.add(newsDao.selectNewsByID(news));
        } else if (!news.getTitle().equals("null")) {
            page.setLineEachPage(6);
            int currentPage = page.getCurrentPage();
            int currentLine = (currentPage - 1) * (page.getLineEachPage());
            page.setCurrentLine(currentLine);
            newss = newsDao.selectNewsByTitle(news, page);
        }

        return newss;
    }

    @Override
    public Page showPageList() {
        Page page = new Page();
        Integer numberOfLine = newsDao.showNumberOfLine();
        page.setTotalLine(numberOfLine);
        page.setLineEachPage(6);
        if (numberOfLine % page.getLineEachPage() == 0) {
            page.setTotalPage(numberOfLine / page.getLineEachPage());
        } else {
            page.setTotalPage(numberOfLine / page.getLineEachPage() + 1);
        }
        return page;
    }

    @Override
    public Page showPageList(News news) {
        Page page = new Page();
        Integer numberOfLine = 0;
        if (news.getNews_id() != 0) {
            numberOfLine = 1;
        } else {
            numberOfLine = newsDao.showNumberOfLineByTitle(news);
        }

        page.setTotalLine(numberOfLine);
        page.setLineEachPage(6);
        if (numberOfLine % page.getLineEachPage() == 0) {
            page.setTotalPage(numberOfLine / page.getLineEachPage());
        } else {
            page.setTotalPage(numberOfLine / page.getLineEachPage() + 1);
        }
        return page;
    }

    @Override
    public List<News> showRecentNews() {
        return newsDao.selectRecentNews();
    }

    //   新加入 news
    @Override
    public News addNewNews(MultipartFile img, News news) {
        //  保存照片
        String basePath = "D:\\WEB-IMG\\CSWebsite\\";
        String uuid = UUID.randomUUID().toString();
        news.setPhoto("NewsImg/" + uuid + ".png");
        try {
            img.transferTo(new File(basePath + news.getPhoto()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  向数据库插入新news的所有信息
        Integer result = newsDao.insertNews(news);
        System.out.println("News id: " + news.getNews_id());

        //  此news的news_id已经被mybatis填充
        if (result == 1) {
            return news;
        } else return null;
    }

    //    News Detail 显示
    @Override
    public News showNewsDetail(News news) {
        return newsDao.selectNewsByID(news);
    }

    //    删除所选news
    @Override
    public boolean deleteSelectedNews(Map<String, String[]> paraMap) {
        Set<String> keySet = paraMap.keySet();
        List<News> newss = new ArrayList<>();
        for (String key : keySet) {
            String choice = paraMap.get(key)[0];
            if ("on".equals(choice)) {
                News news = new News();
                news.setNews_id(Integer.parseInt(key));
                news = newsDao.selectNewsByID(news);
                newss.add(news);
            }
        }
        Integer result = newsDao.deleteNewsByID(newss);
        //        删除服务器图片文件
        for (News news: newss) {
            deleteNewsPhoto(news);
        }
        if (result == newss.size()) {
            System.out.println("Delete Newss Successfully! ");
            return true;
        } else {
            return false;
        }
    }

    //    删除单个news
    @Override
    public boolean deleteOneNews(News news) {
        List<News> newss = new ArrayList<>();
        newss.add(news);
        deleteNewsPhoto(newsDao.selectNewsByID(news));
        Integer result = newsDao.deleteNewsByID(newss);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    //    Method: 删除faculty照片文件
    public void deleteNewsPhoto(News news) {
        String basePath = "D:\\WEB-IMG\\CSWebsite\\";
        new File(basePath + news.getPhoto()).delete();
    }

    //  更新news信息
    @Override
    public boolean updateNews(MultipartFile img, News news) {
        Integer result = 0;

        //  如果图片不为空，保存照片且删除之前的照片
        if (img.getSize() != 0) {
            news.setPhoto(newsDao.selectNewsByID(news).getPhoto());
            String basePath = "D:\\WEB-IMG\\CSWebsite\\";
            deleteNewsPhoto(news);
            String uuid = UUID.randomUUID().toString();
            news.setPhoto("NewsImg/" + uuid + ".png");
            try {
                img.transferTo(new File(basePath + news.getPhoto()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = newsDao.updateAllNewsByID(news);
        }
        //  如果图片为空，不改变图片
        else {
            result = newsDao.updatePartNewsByID(news);
        }

        if (result == 1) {
            return true;
        } else
            return false;
    }

}

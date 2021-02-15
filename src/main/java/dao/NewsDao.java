package dao;

import domain.News;
import domain.Page;

import java.util.List;

public interface NewsDao {

    public List<News> selectAllNewsByPage(Page page);

    public Integer showLineNumber();

    public News selectNewsByID(News news);
}

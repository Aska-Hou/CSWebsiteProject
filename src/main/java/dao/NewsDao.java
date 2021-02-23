package dao;

import domain.News;
import domain.Page;
import domain.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsDao {
    
    //    展示最近六条数据
    public List<News> selectRecentNews();
    
    //    展示所有news
    public List<News> showAllNews(Page page);

    //    根据News ID查询News
    public News selectNewsByID(News News);

    //    根据News name查询News
    public List<News> selectNewsByTitle(@Param("news") News news, @Param("page") Page page);

    //    展示所有数据页码
    public Integer showNumberOfLine();

    //    根据Title模糊查询展示页码
    public Integer showNumberOfLineByTitle(News news);

    //    插入新news
    public Integer insertNews(News news);

    //    批量删除所选news
    public Integer deleteNewsByID(List<News> news);

    //    根据news id更新信息（不保存图片）
    public Integer updatePartNewsByID(News news);

    //    根据news id更新信息（保存图片）
    public Integer updateAllNewsByID(News news);


}

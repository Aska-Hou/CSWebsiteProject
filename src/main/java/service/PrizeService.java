package service;

import domain.News;
import domain.Page;
import domain.Prize;
import domain.Professor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface PrizeService {

    //    分页展示Prize List内容(无关键词）
    public List<Prize> showPrizeList(Page page);

    //    分页展示Prize List内容(有关键词）
    public List<Prize> showPrizeList(Prize prize, Page page);

    //页码展示 (无关键词）
    public Page showPageList();

    //页码展示 (有关键词）
    public Page showPageList(Prize prize);

    //    添加功能：
    //    1. Add界面展示recent news
    public List<News> showRecentNews();

    //    2. Add 功能
    public Prize addNewPrize(MultipartFile img, Prize prize);


    //    查询prize详细信息
    public Prize showPrizeDetail(Prize prize);

    //    删除：
    //    1. 单个删除
    public boolean deleteOnePrize(Prize prize);

    //    2. 批量删除
    public boolean deleteSelectedPrize(Map<String, String[]> paraMap);

    //    更新 Prize 信息
    public boolean updatePrize(MultipartFile img, Prize prize);


}

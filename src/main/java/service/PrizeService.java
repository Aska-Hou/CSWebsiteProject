package service;

import domain.Page;
import domain.Prize;

import java.util.List;

public interface PrizeService {

    //    分页展示Prize List内容(无关键词）
    public List<Prize> showPrizeList(Page page);

    //    分页展示Prize List内容(有关键词）
    public List<Prize> showPrizeList(Prize prize, Page page);

    //页码展示 (无关键词）
    public Page showPageList();

    //页码展示 (有关键词）
    public Page showPageList(Prize prize);

}

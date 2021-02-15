package service;

import domain.Page;
import domain.Prize;

import java.util.List;

public interface PrizeService {

    //    分页展示Prize List内容
    public List<Prize> showPrizeList(Page page);

    //页码展示
    public Page showPageList();
}

package dao;

import domain.Page;
import domain.Prize;

import java.util.List;

public interface PrizeDao {

    public List<Prize> showAllPrize(Page page);

    public Integer showNumberOfLine();
}

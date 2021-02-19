package dao;

import domain.Page;
import domain.Prize;
import domain.Professor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrizeDao {

    //    展示所有prize
    public List<Prize> showAllPrize(Page page);

    //    根据Prize ID查询Prize
    public Prize selectPrizeByID(Prize Prize);

    //    根据Prize name查询Prize
    public List<Prize> selectPrizeByName(@Param("prize") Prize prize, @Param("page") Page page);


    //    展示所有数据页码
    public Integer showNumberOfLine();

    //    根据Name模糊查询展示页码
    public Integer showNumberOfLineByName(Prize prize);
}

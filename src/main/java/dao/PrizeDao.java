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

    //    插入新prize
    public Integer insertPrize(Prize prize);

    //    批量删除所选prizes
    public Integer deletePrizesByID(List<Prize> prizes);

    //    根据prize id更新信息（不保存图片）
    public Integer updatePartPrizeByID(Prize prize);

    //    根据prize id更新信息（保存图片）
    public Integer updateAllPrizeByID(Prize prize);

    //     查找最近三条prize
    public List<Prize> selectRecentThreePrize();


}

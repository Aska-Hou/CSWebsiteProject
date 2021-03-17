package dao;

import domain.ResearchCenter;

import java.util.List;

public interface ResearchCenterDao {

    //    查询所有的ResearchCenter, 返回List
    public List<ResearchCenter> showAllResearchCenter();

    //    根据ResearchCenter ID查询ResearchCenter
    public ResearchCenter selectResearchCenterByID(ResearchCenter center);

    //    根据center name查询center
    public List<ResearchCenter> selectResearchCenterByName(ResearchCenter center);

    //    插入新center
    public Integer insertResearchCenter(ResearchCenter center);

    //    根据center id更新信息（不保存图片）
    public Integer updatePartResearchCenterByID(ResearchCenter center);

    //    根据center id更新信息（保存图片）
    public Integer updateAllResearchCenterByID(ResearchCenter center);

    //    批量删除所选center
    public Integer deleteResearchCentersByID(List<ResearchCenter> centers);

}

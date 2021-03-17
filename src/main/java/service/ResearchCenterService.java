package service;

import domain.ResearchCenter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ResearchCenterService {

    //    展示所有center
    public List<ResearchCenter> showResearchCenterList();

    //    根据ID展示center detail
    public ResearchCenter showResearchCenterDetail(ResearchCenter center);

    //    管理员账户根据关键词搜索center
    public List<ResearchCenter> searchResearchCenterList(ResearchCenter center);

    //    加入新的center
    public ResearchCenter addNewResearchCenter(MultipartFile img, ResearchCenter center);

    //    更新center信息
    public boolean updateResearchCenter(MultipartFile img, ResearchCenter center);

    //    删除所选center
    public boolean deleteSelectedResearchCenter(Map<String, String[]> paraMap);

    //    删除单个center
    public boolean deleteOneResearchCenter(ResearchCenter center);
}

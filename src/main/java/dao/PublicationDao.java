package dao;

import domain.Page;
import domain.Publication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublicationDao {
    
    //    展示所有publication
    public List<Publication> showAllPublication(Page page);

    //    根据Publication ID查询Publication
    public Publication selectPublicationByID(Publication Publication);

    //    根据Publication name查询Publication
    public List<Publication> selectPublicationByName(@Param("publication") Publication publication, @Param("page") Page page);

    //    展示所有数据页码
    public Integer showNumberOfLine();

    //    根据Name模糊查询展示页码
    public Integer showNumberOfLineByName(Publication publication);

    //    插入新publication
    public Integer insertPublication(Publication publication);

    //    批量删除所选publications
    public Integer deletePublicationsByID(List<Publication> publications);

    //    根据publication id更新信息
    public Integer updatePublicationByID(Publication publication);


}

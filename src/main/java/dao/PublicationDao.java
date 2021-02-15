package dao;

import domain.Page;
import domain.Paper;

import java.util.List;

public interface PublicationDao {

    //    分页查询所有paper
    public List<Paper> selectAllPublication(Page page);

    //    查询总paper条数
    public Integer showNumberOfLine();
}
